package org.palladiosimulator.loadbalancingaction.observer;

import org.palladiosimulator.simulizar.runtimestate.SimuLizarRuntimeState;
import org.palladiosimulator.simulizar.runtimestate.IRuntimeStateAccessor;

public class RuntimeStateAccessor implements IRuntimeStateAccessor {

    private SimuLizarRuntimeState runtimeState;

    public RuntimeStateAccessor() {
    }

    @Override
    public void setRuntimeStateModel(SimuLizarRuntimeState state) {
        this.runtimeState = state;
        runtimeState.getEventNotificationHelper().addObserver(new FinishedJobsListener(state.getMainContext()));
    }
}
