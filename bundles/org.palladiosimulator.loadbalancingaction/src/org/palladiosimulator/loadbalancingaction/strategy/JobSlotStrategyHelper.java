package org.palladiosimulator.loadbalancingaction.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;
import jakarta.inject.Inject;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.ComponentInstanceRegistry;
import org.palladiosimulator.simulizar.runtimestate.FQComponentID;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;
import org.palladiosimulator.simulizar.scopes.RuntimeExtensionScope;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

@RuntimeExtensionScope
public class JobSlotStrategyHelper {
    public static final String MIDDLEWARE_PASSIVE_RESOURCE_COMPONENT_NAME = "MiddlewarePassiveResource";
    public static final String REQUIRED_SLOTS_PARAMETER_SPECIFICATION = "NUMBER_REQUIRED_RESOURCES.VALUE";
    public static final String COMPUTE_COMPONENT_NAME = "computeJob";

    public final List<JobSlotFirstFitStrategy> jobQueue = Collections
            .synchronizedList(new ArrayList<JobSlotFirstFitStrategy>());
    public final Map<LoadbalancingBranchTransition, ResourceContainer> branchMapping = Collections
            .synchronizedMap(new HashMap<LoadbalancingBranchTransition, ResourceContainer>());
    public final Map<ResourceContainer, Long> resourceContainerSlots = Collections
            .synchronizedMap(new HashMap<ResourceContainer, Long>());
    public static final int QUEUE_LENGTH_TO_SEARCH = 1;

    // TODO: determine via applied template which strategy is active
    public boolean isActive = false;

    public AssemblyContext systemAssemblyContext;
    
    private final ComponentInstanceRegistry componentRegistry;
    
    @Inject
    public JobSlotStrategyHelper(ComponentInstanceRegistry componentRegistry) {
        this.componentRegistry = componentRegistry;
    }

    public void jobFinished(AssemblyContext assemblyFinished, InterpreterDefaultContext context) {
        Allocation allocation = context.getLocalPCMModelAtContextCreation().getAllocation();

        ResourceContainer container = findResourceContainer(assemblyFinished, allocation);

        AssemblyContext middlewarePassiveAssembly = findMiddlewarePassiveAssembly(container, allocation);
        PassiveResource passiveResource = ((BasicComponent) middlewarePassiveAssembly
                .getEncapsulatedComponent__AssemblyContext()).getPassiveResource_BasicComponent().get(0);

        Long freeSlots = getPassiveResourceAvailable(passiveResource,
                getFQComponentIDForMiddleware(middlewarePassiveAssembly), context);
        resourceContainerSlots.put(container, freeSlots);

        activateFitting(container);
    }

    public boolean hasToBeQueued(long requiredSlots) {
        if (jobQueue.isEmpty()) {
            return false;
        } else if (jobQueue.size() >= QUEUE_LENGTH_TO_SEARCH) {
            return true;
        } else {
            return jobQueue.stream().anyMatch(entry -> entry.getRequiredSlots() <= requiredSlots);
        }
    }

    public void reset() {
        jobQueue.clear();
        branchMapping.clear();
        resourceContainerSlots.clear();
        isActive = false;
        systemAssemblyContext = null;
    }

    public ResourceContainer getResourceContainerForBranch(LoadbalancingBranchTransition branchTransition,
            InterpreterDefaultContext context) {
        ResourceContainer container = branchMapping.get(branchTransition);
        if (container == null) {
            AssemblyConnector assemblyConnectorToLoadbalanced = findAssemblyConnectorToLoadbalancedComponent(
                    branchTransition, context);
            AssemblyContext loadbalancedAssemblyContext = assemblyConnectorToLoadbalanced
                    .getProvidingAssemblyContext_AssemblyConnector();

            container = findResourceContainer(loadbalancedAssemblyContext,
                    context.getLocalPCMModelAtContextCreation().getAllocation());
            branchMapping.put(branchTransition, container);
        }
        return container;
    }

    public Long getFreeSlotsOfContainer(ResourceContainer container, InterpreterDefaultContext context) {
        Long freeSlots = resourceContainerSlots.get(container);
        if (freeSlots == null) {
            freeSlots = findFreeSlotsOfContainer(container, context);
            resourceContainerSlots.put(container, freeSlots);
        }
        return freeSlots;
    }

    public void activateFitting(ResourceContainer container) {
        Long freeSlots = resourceContainerSlots.get(container);
        if ((long) freeSlots == 0) {
            return;
        }
        int i = 0;
        boolean found = false;
        for (Iterator<JobSlotFirstFitStrategy> it = jobQueue.iterator(); it.hasNext() && i < QUEUE_LENGTH_TO_SEARCH;) {
            JobSlotFirstFitStrategy job = it.next();
            if (job.getRequiredSlots() <= freeSlots) {
                System.out.println("Found thread to wake up at position " + i);
                found = true;
                it.remove();
                resourceContainerSlots.put(container, freeSlots - job.getRequiredSlots());

                activateJobOnContainer(job, container);
                break;
            }
            i++;
        }
        if (found) {
            // wokeUp means resources got freed. Because the resources could be enough
            // for several jobs we have to start more than one, if there are slots
            // remaining. Also this job could jave blocked others.
            activateOnOtherContainer();
        } else {
            System.out.println("Did not find thread to wake up");
        }
    }

    private void activateOnOtherContainer() {
        JobSlotFirstFitStrategy job = jobQueue.get(0);
        boolean found = false;
        for (Iterator<Map.Entry<ResourceContainer, Long>> it = resourceContainerSlots.entrySet().iterator(); it
                .hasNext();) {
            Map.Entry<ResourceContainer, Long> entry = it.next();
            if (job.getRequiredSlots() <= entry.getValue()) {
                System.out.println("Wake up thread.");
                found = true;
                jobQueue.remove(0);
                resourceContainerSlots.put(entry.getKey(), entry.getValue() - job.getRequiredSlots());
                activateJobOnContainer(job, entry.getKey());
                break;
            }
        }
        if (found) {
            activateOnOtherContainer();
        } else {
            System.out.println("Queue blocked.");
        }
    }

    private long findFreeSlotsOfContainer(ResourceContainer container, InterpreterDefaultContext context) {
        AssemblyContext middlewarePassiveAssembly = findMiddlewarePassiveAssembly(container,
                context.getLocalPCMModelAtContextCreation().getAllocation());
        FQComponentID middlewareFQComponentID = getFQComponentIDForMiddleware(middlewarePassiveAssembly);
        PassiveResource passiveResource = ((BasicComponent) middlewarePassiveAssembly
                .getEncapsulatedComponent__AssemblyContext()).getPassiveResource_BasicComponent().get(0);

        long freeSlots;
        if (isComponentRegistered(middlewareFQComponentID)) {
            freeSlots = getPassiveResourceAvailable(passiveResource, middlewareFQComponentID, context);
        } else {
            freeSlots = getPassiveResourceCapacity(middlewarePassiveAssembly, passiveResource, context);
        }
        return freeSlots;
    }

    private static AssemblyConnector findAssemblyConnectorToLoadbalancedComponent(
            LoadbalancingBranchTransition branchTransition, InterpreterDefaultContext context) {
        final AssemblyContext loadbalancingActionAssembly = context.getAssemblyContextStack().peek();

        RequiredRole requiredRole = branchTransition.getBranchBehaviour_LoadbalancingBranchTransition()
                .getSteps_Behaviour().stream().filter(ExternalCallAction.class::isInstance)
                .map(ExternalCallAction.class::cast).map(ExternalCallAction::getRole_ExternalService).findFirst()
                .orElseThrow(() -> new PCMModelInterpreterException(
                        "No ExternalCallAction with OperationRequiredRole for loadbalancing branch found."));

        AssemblyConnector assemblyConnector = loadbalancingActionAssembly.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure().stream().filter(AssemblyConnector.class::isInstance)
                .map(AssemblyConnector.class::cast)
                .filter(a -> a.getRequiringAssemblyContext_AssemblyConnector() == loadbalancingActionAssembly
                        && a.getRequiredRole_AssemblyConnector() == requiredRole)
                .findFirst().orElseThrow(() -> new PCMModelInterpreterException(
                        "Loadbalancing required role is not connected: " + requiredRole));

        return assemblyConnector;
    }

    private static long getPassiveResourceCapacity(AssemblyContext middlewarePassiveAssembly,
            PassiveResource passiveResource, InterpreterDefaultContext context) {
        /*
         * TODO: Important! Usage of probability functions for passive resource capacity would lead
         * to wrong results, because the probability function is evaluated a second time when the
         * passive resource is actually created.
         */
        SimulatedStackHelper.createAndPushNewStackFrame(context.getStack(),
                middlewarePassiveAssembly.getConfigParameterUsages__AssemblyContext(),
                context.getStack().currentStackFrame());

        long capacity = StackContext.evaluateStatic(passiveResource.getCapacity_PassiveResource().getSpecification(),
                Long.class, context.getStack().currentStackFrame());
        context.getStack().removeStackFrame();
        return capacity;
    }

    private boolean isComponentRegistered(FQComponentID fqID) {
        return componentRegistry.hasComponentInstance(fqID);
    }

    private static ResourceContainer findResourceContainer(AssemblyContext providingAssemblyContext,
            Allocation allocation) {
        return allocation.getAllocationContexts_Allocation().stream()
                .filter(alloc -> alloc
                        .getAssemblyContext_AllocationContext().getId().equals(providingAssemblyContext.getId()))
                .findFirst()
                .orElseThrow(() -> new PCMModelInterpreterException(
                        "No allocation context for assembly context found: " + providingAssemblyContext))
                .getResourceContainer_AllocationContext();
    }

    private FQComponentID getFQComponentIDForMiddleware(AssemblyContext middleware) {
        Stack<AssemblyContext> assemblyStack = new Stack<AssemblyContext>();
        assemblyStack.push(systemAssemblyContext);
        assemblyStack.push(middleware);
        FQComponentID fqID = new FQComponentID(assemblyStack);
        return fqID;
    }

    private static void activateJobOnContainer(JobSlotFirstFitStrategy job, ResourceContainer container) {
        job.setTargetContainer(container);
        job.activate();
    }

    private static AssemblyContext findMiddlewarePassiveAssembly(ResourceContainer container, Allocation allocation) {
        Stream<AllocationContext> allocsOnContainer = allocation.getAllocationContexts_Allocation().stream()
                .filter(alloc -> alloc.getResourceContainer_AllocationContext().equals(container));

        AssemblyContext middlewarePassiveAssembly = allocsOnContainer
                .map(AllocationContext::getAssemblyContext_AllocationContext)
                .filter(a -> a.getEncapsulatedComponent__AssemblyContext().getEntityName()
                        .equals(MIDDLEWARE_PASSIVE_RESOURCE_COMPONENT_NAME))
                .findFirst().orElseThrow(() -> new PCMModelInterpreterException(
                        "Did not find middleware passive resource component for resource container: " + container));
        return middlewarePassiveAssembly;
    }

    private long getPassiveResourceAvailable(PassiveResource passiveResource, FQComponentID middlewareFQComponentID,
            InterpreterDefaultContext context) {
        SimulatedBasicComponentInstance simulatedInstance = ((SimulatedBasicComponentInstance) componentRegistry
            .getComponentInstance(middlewareFQComponentID));
        return simulatedInstance.getAvailablePassiveResource(passiveResource, context);
    }
}
