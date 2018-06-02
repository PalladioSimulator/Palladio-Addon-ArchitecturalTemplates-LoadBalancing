package org.palladiosimulator.loadbalancingaction.strategy;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy;

public class StrategyFactory {

    public static Strategy createStrategy(LoadbalancingStrategy strategyEnum) {
        Strategy strategy;

        switch (strategyEnum) {
        case RANDOM:
            strategy = new RandomStrategy();
            break;
        case JOBSLOT_FIRSTFIT:
            strategy = new JobSlotFirstFitStrategy();
            break;
        default:
            strategy = null;
            break;
        }
        return strategy;
    }

}
