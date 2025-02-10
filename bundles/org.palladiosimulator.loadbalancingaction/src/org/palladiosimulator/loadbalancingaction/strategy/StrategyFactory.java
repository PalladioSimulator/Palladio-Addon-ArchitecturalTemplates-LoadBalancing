package org.palladiosimulator.loadbalancingaction.strategy;

import jakarta.inject.Inject;
import jakarta.inject.Provider;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class StrategyFactory {
    private final Provider<JobSlotStrategyHelper> strategyHelperProvider;

    @Inject
    public StrategyFactory(Provider<JobSlotStrategyHelper> strategyHelperProvider) {
        this.strategyHelperProvider = strategyHelperProvider;
    }

    public Strategy createStrategy(LoadbalancingStrategy strategyEnum, InterpreterDefaultContext context) {
        Strategy strategy;

        switch (strategyEnum) {
        case RANDOM:
            strategy = new RandomStrategy(context);
            break;
        case JOBSLOT_FIRSTFIT:
            strategy = new JobSlotFirstFitStrategy(context, strategyHelperProvider.get());
            break;
        default:
            strategy = null;
            break;
        }
        return strategy;
    }

}
