package org.palladiosimulator.loadbalancingaction.strategy;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

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

    private volatile ResourceContainer targetContainer;
    private Long requiredSlots;
    private volatile boolean wokeUp;
    private final JobSlotStrategyHelper helper;

    public JobSlotFirstFitStrategy(InterpreterDefaultContext context, JobSlotStrategyHelper helper) {
        super(context);
        this.helper = helper;
        wokeUp = false;

        if (helper.systemAssemblyContext == null) {
            helper.systemAssemblyContext = context.getAssemblyContextStack().get(0);
            helper.isActive = true;
        }
    }

    @Override
    public LoadbalancingBranchTransition determineBranch(EList<LoadbalancingBranchTransition> branchTransitions) {

        requiredSlots = evaluateRequiredSlots();

        if (helper.hasToBeQueued(requiredSlots)) {
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
            // Hack: somehow the jobs are activated. To avoid
            // exceptions, put them to sleep again.
            context.getThread().passivate();
        }

        return findBranchToContainer(branchTransitions);
    }

    private LoadbalancingBranchTransition findBranchWithFreeSlots(
            EList<LoadbalancingBranchTransition> branchTransitions, Long requiredSlots) {
        for (LoadbalancingBranchTransition branchTransition : branchTransitions) {

            ResourceContainer container = helper.getResourceContainerForBranch(branchTransition,
                    context);
            Long freeSlots = helper.getFreeSlotsOfContainer(container, context);
            long remainingSlots = freeSlots - requiredSlots;

            if (remainingSlots >= 0) {
                helper.resourceContainerSlots.put(container, remainingSlots);
                return branchTransition;
            }
        }
        return null;
    }

    private LoadbalancingBranchTransition findBranchToContainer(
            EList<LoadbalancingBranchTransition> branchTransitions) {
        for (LoadbalancingBranchTransition branchTransition : branchTransitions) {
            ResourceContainer container = helper.getResourceContainerForBranch(branchTransition,
                    context);
            if (container.equals(targetContainer)) {

                Long freeSlots = helper.getFreeSlotsOfContainer(container, context);
                if (freeSlots < 0) {
                    throw new PCMModelInterpreterException("Job got scheduled on container with too less resources");
                }
                return branchTransition;
            }
        }
        return null;
    }

    private Long evaluateRequiredSlots() {
        return StackContext.evaluateStatic(JobSlotStrategyHelper.REQUIRED_SLOTS_PARAMETER_SPECIFICATION, Long.class,
                context.getStack().currentStackFrame());
    }

    private void putJobInQueueAndPassivate() {
        helper.jobQueue.add(this);
        System.out.println("Put job to sleep. Queue Length: " + helper.jobQueue.size());
        context.getThread().passivate();
    }

    public void setTargetContainer(ResourceContainer container) {
        this.targetContainer = container;
    }

    public void activate() {
        this.wokeUp = true;
        this.context.getThread().activate();

    }

    public Long getRequiredSlots() {
        return requiredSlots;
    }
}
