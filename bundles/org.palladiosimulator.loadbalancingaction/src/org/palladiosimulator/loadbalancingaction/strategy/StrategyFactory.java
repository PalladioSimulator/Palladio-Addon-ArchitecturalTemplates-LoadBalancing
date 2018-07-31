package org.palladiosimulator.loadbalancingaction.strategy;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class StrategyFactory {

    public static Strategy createStrategy(LoadbalancingStrategy strategyEnum, InterpreterDefaultContext context) {
        Strategy strategy;

        switch (strategyEnum) {
        case RANDOM:
            strategy = new RandomStrategy(context);
            break;
        case JOBSLOT_FIRSTFIT:
            strategy = new JobSlotFirstFitStrategy(context);
            break;
        default:
            strategy = null;
            break;
        }
        return strategy;
    }

}
