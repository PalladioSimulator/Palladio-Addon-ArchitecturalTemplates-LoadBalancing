package org.palladiosimulator.loadbalancingaction.strategy;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class RandomStrategy extends AbstractStrategy {

    public RandomStrategy(InterpreterDefaultContext context) {
        super(context);
    }

    @Override
    public LoadbalancingBranchTransition determineBranch(EList<LoadbalancingBranchTransition> branchTransitions) {
        Random random = new Random();
        return branchTransitions.get(random.nextInt(branchTransitions.size()));
    }

}
