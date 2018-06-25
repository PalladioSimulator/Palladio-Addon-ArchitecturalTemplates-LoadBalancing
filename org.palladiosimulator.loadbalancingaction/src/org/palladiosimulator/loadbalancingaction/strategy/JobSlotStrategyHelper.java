package org.palladiosimulator.loadbalancingaction.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Stream;

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
import org.palladiosimulator.simulizar.runtimestate.FQComponentID;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class JobSlotStrategyHelper {
    public static final String MIDDLEWARE_PASSIVE_RESOURCE_COMPONENT_NAME = "MiddlewarePassiveResource";
    public static final String REQUIRED_SLOTS_PARAMETER_SPECIFICATION = "NUMBER_REQUIRED_RESOURCES.VALUE";
    public static final String COMPUTE_COMPONENT_NAME = "computeJob";

    public static final ArrayList<JobSlotFirstFitStrategy> JOB_QUEUE = new ArrayList<JobSlotFirstFitStrategy>();
    public static final HashMap<LoadbalancingBranchTransition, ResourceContainer> BRANCH_MAPPING = new HashMap<LoadbalancingBranchTransition, ResourceContainer>();
    public static final HashMap<ResourceContainer, Long> RESOURCE_CONTAINER_SLOTS = new HashMap<ResourceContainer, Long>();
    public static final int QUEUE_LENGTH_TO_SEARCH = 1;

    //TODO: determine via applied template which strategy is active
    public static boolean isActive = false;

    public static AssemblyContext SYSTEM_ASSEMBLY_CONTEXT;

    public static void jobFinished(AssemblyContext assemblyFinished, InterpreterDefaultContext context) {
        Allocation allocation = context.getLocalPCMModelAtContextCreation().getAllocation();

        ResourceContainer container = findResourceContainer(assemblyFinished, allocation);

        AssemblyContext middlewarePassiveAssembly = findMiddlewarePassiveAssembly(container, allocation);
        PassiveResource passiveResource = ((BasicComponent) middlewarePassiveAssembly
                .getEncapsulatedComponent__AssemblyContext()).getPassiveResource_BasicComponent().get(0);

        Long freeSlots = getPassiveResourceAvailable(passiveResource,
                getFQComponentIDForMiddleware(middlewarePassiveAssembly), context);
        RESOURCE_CONTAINER_SLOTS.put(container, freeSlots);

        activateFitting(container);
    }

    public static boolean hasToBeQueued(long requiredSlots) {
        if (JOB_QUEUE.isEmpty()) {
            return false;
        } else if (JOB_QUEUE.size() >= QUEUE_LENGTH_TO_SEARCH) {
            return true;
        } else {
            return JOB_QUEUE.stream().anyMatch(entry -> entry.getRequiredSlots() <= requiredSlots);
        }
    }

    public static void reset() {
        JOB_QUEUE.clear();
        BRANCH_MAPPING.clear();
        RESOURCE_CONTAINER_SLOTS.clear();
        isActive = false;
        SYSTEM_ASSEMBLY_CONTEXT = null;
    }

    public static ResourceContainer getResourceContainerForBranch(LoadbalancingBranchTransition branchTransition,
            InterpreterDefaultContext context) {
        ResourceContainer container = JobSlotStrategyHelper.BRANCH_MAPPING.get(branchTransition);
        if (container == null) {
            AssemblyConnector assemblyConnectorToLoadbalanced = findAssemblyConnectorToLoadbalancedComponent(
                    branchTransition, context);
            AssemblyContext loadbalancedAssemblyContext = assemblyConnectorToLoadbalanced
                    .getProvidingAssemblyContext_AssemblyConnector();

            container = findResourceContainer(loadbalancedAssemblyContext,
                    context.getLocalPCMModelAtContextCreation().getAllocation());
            JobSlotStrategyHelper.BRANCH_MAPPING.put(branchTransition, container);
        }
        return container;
    }

    public static Long getFreeSlotsOfContainer(ResourceContainer container, InterpreterDefaultContext context) {
        Long freeSlots = JobSlotStrategyHelper.RESOURCE_CONTAINER_SLOTS.get(container);
        if (freeSlots == null) {
            freeSlots = JobSlotStrategyHelper.findFreeSlotsOfContainer(container, context);
            JobSlotStrategyHelper.RESOURCE_CONTAINER_SLOTS.put(container, freeSlots);
        }
        return freeSlots;
    }


    public static void activateFitting(ResourceContainer container) {
        Long freeSlots = RESOURCE_CONTAINER_SLOTS.get(container);
        if ((long)freeSlots == 0) {
            return;
        }
        int i = 0;
        for (Iterator<JobSlotFirstFitStrategy> it = JOB_QUEUE.iterator(); it.hasNext() && i < QUEUE_LENGTH_TO_SEARCH;) {
            JobSlotFirstFitStrategy job = it.next();
            if (job.getRequiredSlots() <= freeSlots) {
                System.out.println("Found thread to wake up at position " + i);
                it.remove();

                activateJobOnContainer(job, container);
                return;
            }
            i++;
        }
        System.out.println("Did not find thread to wake up");
    }

    private static long findFreeSlotsOfContainer(ResourceContainer container, InterpreterDefaultContext context) {
        AssemblyContext middlewarePassiveAssembly = findMiddlewarePassiveAssembly(container,
                context.getLocalPCMModelAtContextCreation().getAllocation());
        FQComponentID middlewareFQComponentID = getFQComponentIDForMiddleware(middlewarePassiveAssembly);
        PassiveResource passiveResource = ((BasicComponent) middlewarePassiveAssembly
                .getEncapsulatedComponent__AssemblyContext()).getPassiveResource_BasicComponent().get(0);

        long freeSlots;
        if (isComponentRegistered(context, middlewareFQComponentID)) {
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

    private static boolean isComponentRegistered(InterpreterDefaultContext context, FQComponentID fqID) {
        return context.getRuntimeState().getComponentInstanceRegistry().hasComponentInstance(fqID);
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

    private static FQComponentID getFQComponentIDForMiddleware(AssemblyContext middleware) {
        Stack<AssemblyContext> assemblyStack = new Stack<AssemblyContext>();
        assemblyStack.push(SYSTEM_ASSEMBLY_CONTEXT);
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

    private static long getPassiveResourceAvailable(PassiveResource passiveResource,
            FQComponentID middlewareFQComponentID, InterpreterDefaultContext context) {
        SimulatedBasicComponentInstance simulatedInstance = ((SimulatedBasicComponentInstance) context.getRuntimeState()
                .getComponentInstanceRegistry().getComponentInstance(middlewareFQComponentID));
        return simulatedInstance.getAvailablePassiveResource(passiveResource, context);
    }
}
