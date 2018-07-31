package org.palladiosimulator.loadbalancingaction.rdseff;

import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.simulizar.interpreter.AbstractRDSeffSwitchFactory;

public class LoadbalancingRDSeffSwitchFactory extends AbstractRDSeffSwitchFactory {

    @Override
    protected Switch<Object> createRDSeffSwitch(InterpreterDefaultContext context,
            SimulatedBasicComponentInstance basicComponentInstance,
            ExplicitDispatchComposedSwitch<Object> parentSwitch) {
        return new LoadbalancingRDSeffSwitch(context, basicComponentInstance, parentSwitch);
    }

}
