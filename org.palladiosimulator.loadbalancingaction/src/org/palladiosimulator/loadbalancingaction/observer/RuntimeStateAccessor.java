package org.palladiosimulator.loadbalancingaction.observer;

import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;
import org.palladiosimulator.simulizar.runtimestate.IRuntimeStateAccessor;

public class RuntimeStateAccessor implements IRuntimeStateAccessor {

    private AbstractSimuLizarRuntimeState runtimeState;

    public RuntimeStateAccessor() {
    }

    @Override
    public void setRuntimeStateModel(AbstractSimuLizarRuntimeState state) {
        this.runtimeState = state;
        runtimeState.getEventNotificationHelper().addObserver(new FinishedJobsListener());
    }
}
