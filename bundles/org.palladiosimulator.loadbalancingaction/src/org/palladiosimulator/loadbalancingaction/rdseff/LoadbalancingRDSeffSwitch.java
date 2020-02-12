package org.palladiosimulator.loadbalancingaction.rdseff;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour;
import org.palladiosimulator.loadbalancingaction.loadbalancing.util.LoadbalancingSwitch;
import org.palladiosimulator.loadbalancingaction.strategy.Strategy;
import org.palladiosimulator.loadbalancingaction.strategy.StrategyFactory;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.IComposableSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.listener.EventType;
import org.palladiosimulator.simulizar.interpreter.listener.RDSEFFElementPassedEvent;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

/**
 * Extends the simulizar RDSeffSwitch using an extension point.
 *
 * Introduces the interpretation of the new elements LoadbalancerResourceDemandingBehaviour and
 * LoadbalancerAction. LoadbalancerAction is similar to a branch action, beside the branch transition is
 * chosen by load balancing algorithm instead of by a probability function or guard.
 *
 * @author Patrick Firnkes
 *
 */
public class LoadbalancingRDSeffSwitch extends LoadbalancingSwitch<Object> implements IComposableSwitch {
    protected static final Logger LOGGER = Logger.getLogger(LoadbalancingRDSeffSwitch.class);

    private static final Boolean SUCCESS = true;

    private final InterpreterDefaultContext context;
    private final ComposedSwitch<Object> parentSwitch;

    public LoadbalancingRDSeffSwitch(InterpreterDefaultContext context,
            SimulatedBasicComponentInstance basicComponentInstance, ComposedSwitch<Object> parentSwitch) {
        this.context = context;
        this.parentSwitch = parentSwitch;
    }

    @Override
    public Switch<Object> getParentSwitch() {
        return parentSwitch;
    }

    @Override
    public Object caseLoadbalancingResourceDemandingBehaviour(final LoadbalancingResourceDemandingBehaviour object) {

        AbstractAction currentAction = null;
        // interpret start action
        for (final AbstractAction abstractAction : object.getSteps_Behaviour()) {
            if (abstractAction.eClass() == SeffPackage.eINSTANCE.getStartAction()) {
                this.firePassedEvent(abstractAction, EventType.BEGIN);
                currentAction = abstractAction.getSuccessor_AbstractAction();
                this.firePassedEvent(abstractAction, EventType.END);
                break;
            }
        }
        if (currentAction == null) {
            throw new PCMModelInterpreterException("RDSEFF is invalid, it misses a start action");
        }

        while (currentAction.eClass() != SeffPackage.eINSTANCE.getStopAction()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Interpret " + currentAction.eClass().getName() + ": " + currentAction);
            }
            this.firePassedEvent(currentAction, EventType.BEGIN);
            this.getParentSwitch().doSwitch(currentAction);
            this.firePassedEvent(currentAction, EventType.END);
            currentAction = currentAction.getSuccessor_AbstractAction();
        }
        return SUCCESS;
    }

    @Override
    public Object caseLoadbalancingAction(LoadbalancingAction object) {
        final EList<LoadbalancingBranchTransition> loadbalancerBranchTransitions = object.getBranches_Loadbalancing();
        if (loadbalancerBranchTransitions.isEmpty()) {
            throw new PCMModelInterpreterException("Empty load balancer action is not allowed: " + object + " Id: " + object.getId());
        }

        if (LOGGER.isDebugEnabled()) {
            final StringBuilder sb = new StringBuilder();

            sb.append("Load Balancer \"");
            sb.append(object.getEntityName());
            sb.append("\" [ID: ");
            sb.append(object.getId());
            sb.append("\"] with ");
            sb.append(object.getBranches_Loadbalancing().size());
            sb.append(" branches.");

            LOGGER.debug(sb.toString());
        }

        final Strategy strategy = StrategyFactory.createStrategy(object.getLoadbalancingStrategy(), this.context);
        if (strategy == null) {
            LOGGER.error("No load balancing strategy selected: " + object);
            throw new PCMModelInterpreterException("No load balancer balancing strategy selected. This is not allowed.");
        }
        else {
            LOGGER.debug("Selected load balancing strategy: " + strategy.getClass().toString());
        }

        final LoadbalancingBranchTransition loadBalancerBranchTransition = strategy.determineBranch(loadbalancerBranchTransitions);

        if (loadBalancerBranchTransition == null) {
            LOGGER.error("No branch selected: " + object);
            throw new PCMModelInterpreterException("No load balancer branch transition was active. This is not allowed.");
        } else {
            this.getParentSwitch().doSwitch(loadBalancerBranchTransition.getBranchBehaviour_LoadbalancingBranchTransition());
        }

        return SUCCESS;
    }
    /**
     *
     * @param abstractAction
     * @param eventType
     */
    private <T extends AbstractAction> void firePassedEvent(final T abstractAction, final EventType eventType) {
        this.context.getRuntimeState().getEventNotificationHelper().firePassedEvent(new RDSEFFElementPassedEvent<T>(
                abstractAction, eventType, this.context, this.context.getAssemblyContextStack().peek()));
    }

}
