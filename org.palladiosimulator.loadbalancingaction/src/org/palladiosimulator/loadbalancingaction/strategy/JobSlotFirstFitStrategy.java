package org.palladiosimulator.loadbalancingaction.strategy;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import org.palladiosimulator.loadbalancingaction.strategy.JobSlotStrategyHelper;

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

    private ResourceContainer targetContainer;
    private Long requiredSlots;
    private boolean wokeUp;

    public JobSlotFirstFitStrategy(InterpreterDefaultContext context) {
        super(context);
        wokeUp = false;

        if (JobSlotStrategyHelper.SYSTEM_ASSEMBLY_CONTEXT == null) {
            JobSlotStrategyHelper.SYSTEM_ASSEMBLY_CONTEXT = context.getAssemblyContextStack().get(0);
        }
    }

    @Override
    public LoadbalancingBranchTransition determineBranch(EList<LoadbalancingBranchTransition> branchTransitions) {

        requiredSlots = evaluateRequiredSlots();

        if (JobSlotStrategyHelper.hasToBeQueued(requiredSlots)) {
            putJobInQueueAndPassivate();
        } else {
            LoadbalancingBranchTransition branchTransition = findBranchWithFreeSlots(branchTransitions, requiredSlots);
            if (branchTransition == null) {
                // no possible branch found, sleep and get woke up when other jobs finish
                putJobInQueueAndPassivate();
            } else {
                return branchTransition;
            }
        }
        // if thread is here, he was queued and got woke up. So target container must be set
        while (!wokeUp) {
            // Hack: somehow the jobs are activated at the end of the simulation. To avoid
            // exceptions, put them to sleep again.
            putJobInQueueAndPassivate();
        }

        return findBranchToContainer(branchTransitions);
    }

    private LoadbalancingBranchTransition findBranchWithFreeSlots(
            EList<LoadbalancingBranchTransition> branchTransitions, Long requiredSlots) {
        for (LoadbalancingBranchTransition branchTransition : branchTransitions) {

            ResourceContainer container = JobSlotStrategyHelper.getResourceContainerForBranch(branchTransition,
                    context);
            Long freeSlots = JobSlotStrategyHelper.getFreeSlotsOfContainer(container, context);
            long remainingSlots = freeSlots - requiredSlots;

            if (remainingSlots >= 0) {
                JobSlotStrategyHelper.RESOURCE_CONTAINER_SLOTS.put(container, remainingSlots);
                return branchTransition;
            }
        }
        return null;
    }

    private LoadbalancingBranchTransition findBranchToContainer(
            EList<LoadbalancingBranchTransition> branchTransitions) {
        for (LoadbalancingBranchTransition branchTransition : branchTransitions) {
            ResourceContainer container = JobSlotStrategyHelper.getResourceContainerForBranch(branchTransition,
                    context);
            if (container.equals(targetContainer)) {

                Long freeSlots = JobSlotStrategyHelper.getFreeSlotsOfContainer(container, context);
                long remainingSlots = freeSlots - requiredSlots;
                if (remainingSlots >= 0) {
                    new PCMModelInterpreterException("Job got scheduled on container with too less resources");
                }
                JobSlotStrategyHelper.RESOURCE_CONTAINER_SLOTS.put(container, remainingSlots);

                // activateMoreOnSameContainer(remainingSlots);

                return branchTransition;
            }
        }
        return null;
    }

    private void activateMoreOnSameContainer(long remainingSlots) {
        // wokeUp means resources got freed. Because the resources could be enough
        // for several jobs we have to start more than one, if there are slots
        // remaining.
        if (remainingSlots > 0) {
            JobSlotStrategyHelper.activateFitting(targetContainer);
        }
    }

    private Long evaluateRequiredSlots() {
        return StackContext.evaluateStatic(JobSlotStrategyHelper.REQUIRED_SLOTS_PARAMETER_SPECIFICATION, Long.class,
                context.getStack().currentStackFrame());
    }

    private void putJobInQueueAndPassivate() {
        JobSlotStrategyHelper.JOB_QUEUE.add(this);
        System.out.println("Put job to sleep. Queue Length: " + JobSlotStrategyHelper.JOB_QUEUE.size());
        context.getThread().passivate();
    }

    public void setTargetContainer(ResourceContainer container) {
        this.targetContainer = container;
    }

    public void activate() {
        this.wokeUp = true;
        try {
            this.context.getThread().activate();
        } catch (IllegalStateException e) {
        }
    }

    public Long getRequiredSlots() {
        return requiredSlots;
    }
}
