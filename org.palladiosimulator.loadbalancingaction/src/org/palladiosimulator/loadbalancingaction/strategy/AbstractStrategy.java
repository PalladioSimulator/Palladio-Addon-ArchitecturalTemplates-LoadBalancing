package org.palladiosimulator.loadbalancingaction.strategy;

import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public abstract class AbstractStrategy implements Strategy {

    protected InterpreterDefaultContext context;

    public AbstractStrategy(InterpreterDefaultContext context) {
        this.context = context;
    }

}
