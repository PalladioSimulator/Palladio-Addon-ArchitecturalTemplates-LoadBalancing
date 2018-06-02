package org.palladiosimulator.loadbalancingaction.strategy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
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

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Determines branch transition based on the free job slots on the resource containers. If no slots
 * are free, jobs are put into a queue. Caution: Makes assumptions about the model, should only be
 * used in combination with MiddlewarePassiveResource AT and StaticResourceContainer AT.
 *
 * @author Patrick Firnkes
 *
 */
public class JobSlotFirstFitStrategy implements Strategy {
    private static final String MIDDLEWARE_PASSIVE_RESOURCE_COMPONENT_NAME = "MiddlewarePassiveResource";
    private static final String REQUIRED_SLOTS_PARAMETER_SPECIFICATION = "REQUIRED_SLOTS.VALUE";

    public static final Queue<SimuComSimProcess> JOB_QUEUE = new LinkedList<SimuComSimProcess>();

    private InterpreterDefaultContext context;
    private Stack<AssemblyContext> assemblyStackWithoutInstanceAssemblyContext;

    @SuppressWarnings("unchecked")
    @Override
    public LoadbalancingBranchTransition determineBranch(EList<LoadbalancingBranchTransition> branchTransitions,
            InterpreterDefaultContext context) {

        this.context = context;
        assemblyStackWithoutInstanceAssemblyContext = (Stack<AssemblyContext>) context.getAssemblyContextStack()
                .clone();
        assemblyStackWithoutInstanceAssemblyContext.pop();

        while (true) {
            Long requiredSlots = getRequiredSlots();
            for (LoadbalancingBranchTransition branchTransition : branchTransitions) {
                AssemblyConnector assemblyConnectorToLoadbalanced = findAssemblyConnectorToLoadbalancedComponent(
                        branchTransition);
                AssemblyContext loadbalancedAssemblyContext = assemblyConnectorToLoadbalanced
                        .getProvidingAssemblyContext_AssemblyConnector();

                ResourceContainer container = findResourceContainer(loadbalancedAssemblyContext);
                long freeSlots = findFreeSlotsOfContainer(container);

                if (freeSlots - requiredSlots >= 0) {
                    return branchTransition;
                }
            }
            // no possible branch found, sleep and get woke up when other jobs finish
            putThreadInQueueAndPassivate();
        }
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
        return context.getLocalPCMModelAtContextCreation().getAllocation().getAllocationContexts_Allocation().stream()
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
        Stream<AllocationContext> allocsOnContainer = context.getLocalPCMModelAtContextCreation().getAllocation()
                .getAllocationContexts_Allocation().stream()
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
        SimulatedStackHelper.createAndPushNewStackFrame(this.context.getStack(),
                middlewarePassiveAssembly.getConfigParameterUsages__AssemblyContext(),
                this.context.getStack().currentStackFrame());

        long capacity = StackContext.evaluateStatic(passiveResource.getCapacity_PassiveResource().getSpecification(),
                Long.class, context.getStack().currentStackFrame());
        context.getStack().removeStackFrame();
        return capacity;
    }

    private boolean isComponentRegistered(FQComponentID fqID) {
        return context.getRuntimeState().getComponentInstanceRegistry().hasComponentInstance(fqID);
    }

    @SuppressWarnings("unchecked")
    private FQComponentID getFQComponentIDForMiddleware(AssemblyContext middleware) {
        Stack<AssemblyContext> assemblyStack = (Stack<AssemblyContext>) assemblyStackWithoutInstanceAssemblyContext
                .clone();
        assemblyStack.push(middleware);
        FQComponentID fqID = new FQComponentID(assemblyStack);
        return fqID;
    }

    private void putThreadInQueueAndPassivate() {
        JOB_QUEUE.add(context.getThread());
        context.getThread().passivate();
    };
}
