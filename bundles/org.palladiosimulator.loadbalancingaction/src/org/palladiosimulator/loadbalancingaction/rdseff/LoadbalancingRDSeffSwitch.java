package org.palladiosimulator.loadbalancingaction.rdseff;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
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
import org.palladiosimulator.simulizar.interpreter.EventDispatcher;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RDSeffSwitchContributionFactory;
import org.palladiosimulator.simulizar.interpreter.RDSeffSwitchContributionFactory.RDSeffElementDispatcher;
import org.palladiosimulator.simulizar.interpreter.listener.EventType;
import org.palladiosimulator.simulizar.interpreter.listener.RDSEFFElementPassedEvent;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;

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
public class LoadbalancingRDSeffSwitch extends LoadbalancingSwitch<Object> {
    @AssistedFactory
    public interface Factory extends RDSeffSwitchContributionFactory {
        LoadbalancingRDSeffSwitch create(InterpreterDefaultContext context,
            RDSeffElementDispatcher<Object> parentSwitch);
        
        @Override
        default Switch<Object> createRDSeffSwitch(InterpreterDefaultContext context,
                RDSeffElementDispatcher<Object> parentSwitch) {
            return create(context, parentSwitch);
        }
    }
    
    protected static final Logger LOGGER = Logger.getLogger(LoadbalancingRDSeffSwitch.class);

    private static final Boolean SUCCESS = true;

    private final InterpreterDefaultContext context;
    private final RDSeffElementDispatcher<Object> parentSwitch;
    private final EventDispatcher eventDispatcher;
    private final StrategyFactory strategyFactory;

    @AssistedInject
    public LoadbalancingRDSeffSwitch(@Assisted InterpreterDefaultContext context,
            @Assisted RDSeffElementDispatcher<Object> parentSwitch,
            EventDispatcher eventDispatcher,
            StrategyFactory strategyFactory) {
        this.context = context;
        this.parentSwitch = parentSwitch;
        this.eventDispatcher = eventDispatcher;
        this.strategyFactory = strategyFactory;
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
            parentSwitch.doSwitch(currentAction);
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

        final Strategy strategy = strategyFactory.createStrategy(object.getLoadbalancingStrategy(), this.context);
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
            parentSwitch.doSwitch(loadBalancerBranchTransition.getBranchBehaviour_LoadbalancingBranchTransition());
        }

        return SUCCESS;
    }
    /**
     *
     * @param abstractAction
     * @param eventType
     */
    private <T extends AbstractAction> void firePassedEvent(final T abstractAction, final EventType eventType) {
        eventDispatcher.firePassedEvent(new RDSEFFElementPassedEvent<T>(
                abstractAction, eventType, this.context, this.context.getAssemblyContextStack().peek()));
    }

}
