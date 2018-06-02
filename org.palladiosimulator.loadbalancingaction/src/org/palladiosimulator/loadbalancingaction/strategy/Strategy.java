package org.palladiosimulator.loadbalancingaction.strategy;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public interface Strategy {

    public abstract LoadbalancingBranchTransition determineBranch(
            EList<LoadbalancingBranchTransition> branchTransitions, InterpreterDefaultContext context);

}
