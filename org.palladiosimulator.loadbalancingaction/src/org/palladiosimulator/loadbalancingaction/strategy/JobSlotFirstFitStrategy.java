package org.palladiosimulator.loadbalancingaction.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;
import org.eclipse.emf.common.util.EList;
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
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Determines branch transition based on the free job slots on the resource containers. If no slots
 * are free, jobs are put into a queue. Caution: Makes assumptions about the model, should only be
 * used in combination with LoadbalancingActionMiddlewarePassiveResource AT and
 * LoadbalancingActionStaticResourceContainer AT.
 *
 * @author Patrick Firnkes
 *
 */

public class JobSlotFirstFitStrategy extends AbstractStrategy {

    public static final String MIDDLEWARE_PASSIVE_RESOURCE_COMPONENT_NAME = "MiddlewarePassiveResource";
    public static final String REQUIRED_SLOTS_PARAMETER_SPECIFICATION = "NUMBER_REQUIRED_RESOURCES.VALUE";
    public static final String COMPUTE_COMPONENT_NAME = "computeJob";

    private static final int QUEUE_LENGTH_TO_SEARCH = 50;

    private static final ArrayList<Entry<Long, SimuComSimProcess>> JOB_QUEUE = new ArrayList<Entry<Long, SimuComSimProcess>>();
    private static final HashMap<LoadbalancingBranchTransition, ResourceContainer> BRANCH_MAPPING = new HashMap<LoadbalancingBranchTransition, ResourceContainer>();
    private static final HashMap<ResourceContainer, Long> RESOURCE_CONTAINER_SLOTS = new HashMap<ResourceContainer, Long>();

    private static Stack<AssemblyContext> assemblyStackWithoutInstanceAssemblyContext;

    private Allocation allocation;
    private ComponentInstanceRegistry componentRegistry;

    public JobSlotFirstFitStrategy(InterpreterDefaultContext context) {
        super(context);

        allocation = context.getLocalPCMModelAtContextCreation().getAllocation();
        componentRegistry = context.getRuntimeState().getComponentInstanceRegistry();
    }

    @SuppressWarnings("unchecked")
    @Override
    public LoadbalancingBranchTransition determineBranch(EList<LoadbalancingBranchTransition> branchTransitions) {
        assemblyStackWithoutInstanceAssemblyContext = (Stack<AssemblyContext>) context.getAssemblyContextStack()
                .clone();
        assemblyStackWithoutInstanceAssemblyContext.pop();

        Long requiredSlots = getRequiredSlots();
        boolean wokeUp = false;

        if (!JOB_QUEUE.isEmpty()) {
            putThreadInQueueAndPassivate(requiredSlots, context);
        }

        while (true) {
            for (LoadbalancingBranchTransition branchTransition : branchTransitions) {

                ResourceContainer container = getResourceContainer(branchTransition);

                Long freeSlots = getFreeSlots(container);

                long remainingSlots = freeSlots - requiredSlots;

                // wokeUp means resources got freed. Because the resources could be enough for
                // several jobs we have to start more than one, if there a slots remaining.
                if (wokeUp && remainingSlots > 0) {
                    wakeUpFitting(remainingSlots);
                }

                if (remainingSlots >= 0) {
                    RESOURCE_CONTAINER_SLOTS.put(container, remainingSlots);
                    return branchTransition;
                }
            }
            // no possible branch found, sleep and get woke up when other jobs finish
            putThreadInQueueAndPassivate(requiredSlots, context);
            wokeUp = true;
        }
    }

    private Long getFreeSlots(ResourceContainer container) {
        Long freeSlots = RESOURCE_CONTAINER_SLOTS.get(container);
        if (freeSlots == null) {
            freeSlots = findFreeSlotsOfContainer(container);
            RESOURCE_CONTAINER_SLOTS.put(container, freeSlots);
        }
        return freeSlots;
    }

    private ResourceContainer getResourceContainer(LoadbalancingBranchTransition branchTransition) {
        ResourceContainer container = BRANCH_MAPPING.get(branchTransition);
        if (container == null) {
            AssemblyConnector assemblyConnectorToLoadbalanced = findAssemblyConnectorToLoadbalancedComponent(
                    branchTransition);
            AssemblyContext loadbalancedAssemblyContext = assemblyConnectorToLoadbalanced
                    .getProvidingAssemblyContext_AssemblyConnector();

            container = findResourceContainer(loadbalancedAssemblyContext);
            BRANCH_MAPPING.put(branchTransition, container);
        }
        return container;
    }

    private Long getRequiredSlots() {
        return StackContext.evaluateStatic(REQUIRED_SLOTS_PARAMETER_SPECIFICATION, Long.class,
                context.getStack().currentStackFrame());
    }

    private AssemblyConnector findAssemblyConnectorToLoadbalancedComponent(
            LoadbalancingBranchTransition branchTransition) {
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

    private ResourceContainer findResourceContainer(AssemblyContext providingAssemblyContext) {
        return allocation.getAllocationContexts_Allocation().stream()
                .filter(alloc -> alloc
                        .getAssemblyContext_AllocationContext().getId().equals(providingAssemblyContext.getId()))
                .findFirst()
                .orElseThrow(() -> new PCMModelInterpreterException(
                        "No allocation context for assembly context found: " + providingAssemblyContext))
                .getResourceContainer_AllocationContext();
    }

    private long findFreeSlotsOfContainer(ResourceContainer container) {
        AssemblyContext middlewarePassiveAssembly = findMiddlewarePassiveAssembly(container);
        FQComponentID middlewareFQComponentID = getFQComponentIDForMiddleware(middlewarePassiveAssembly);
        PassiveResource passiveResource = ((BasicComponent) middlewarePassiveAssembly
                .getEncapsulatedComponent__AssemblyContext()).getPassiveResource_BasicComponent().get(0);

        long freeSlots;
        if (isComponentRegistered(middlewareFQComponentID)) {
            freeSlots = getPassiveResourceAvailable(passiveResource, middlewareFQComponentID);
        } else {
            freeSlots = getPassiveResourceCapacity(middlewarePassiveAssembly, passiveResource);
        }
        return freeSlots;
    }

    private AssemblyContext findMiddlewarePassiveAssembly(ResourceContainer container) {
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

    private long getPassiveResourceAvailable(PassiveResource passiveResource, FQComponentID middlewareFQComponentID) {
        SimulatedBasicComponentInstance simulatedInstance = ((SimulatedBasicComponentInstance) context.getRuntimeState()
                .getComponentInstanceRegistry().getComponentInstance(middlewareFQComponentID));
        return simulatedInstance.getAvailablePassiveResource(passiveResource, context);
    }

    private long getPassiveResourceCapacity(AssemblyContext middlewarePassiveAssembly,
            PassiveResource passiveResource) {
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

    @SuppressWarnings("unchecked")
    private FQComponentID getFQComponentIDForMiddleware(AssemblyContext middleware) {
        Stack<AssemblyContext> assemblyStack = (Stack<AssemblyContext>) assemblyStackWithoutInstanceAssemblyContext
                .clone();
        assemblyStack.push(middleware);
        FQComponentID fqID = new FQComponentID(assemblyStack);
        return fqID;
    }

    private void putThreadInQueueAndPassivate(long requiredSlots, InterpreterDefaultContext context) {
        JOB_QUEUE.add(new SimpleEntry<Long, SimuComSimProcess>(requiredSlots, context.getThread()));
        System.out.println("Put thread to sleep. Queue Length: " + JOB_QUEUE.size());
        context.getThread().passivate();
    }

    public void wakeUpFitting(long freeSlots) {
        int i = 0;
        for (Iterator<Entry<Long, SimuComSimProcess>> it = JOB_QUEUE.iterator(); it.hasNext() && i < QUEUE_LENGTH_TO_SEARCH;) {
            Entry<Long, SimuComSimProcess> entry = it.next();
            if (entry.getKey() <= freeSlots) {
                it.remove();
                entry.getValue().activate();
                return;
            }
            i++;
        }
    }

    public void jobFinished(AssemblyContext assembly) {
        ResourceContainer container = findResourceContainer(assembly);
        Long freeSlots = findFreeSlotsOfContainer(container);
        RESOURCE_CONTAINER_SLOTS.put(container, freeSlots);

        wakeUpFitting(freeSlots);
    }

    public void reset(){
        JOB_QUEUE.clear();
        BRANCH_MAPPING.clear();
        RESOURCE_CONTAINER_SLOTS.clear();
    }
}
