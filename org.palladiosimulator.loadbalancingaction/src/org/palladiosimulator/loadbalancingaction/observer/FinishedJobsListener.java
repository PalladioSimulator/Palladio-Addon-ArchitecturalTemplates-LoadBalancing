package org.palladiosimulator.loadbalancingaction.observer;

import org.palladiosimulator.loadbalancingaction.strategy.JobSlotFirstFitStrategy;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.listener.AbstractInterpreterListener;
import org.palladiosimulator.simulizar.interpreter.listener.AssemblyProvidedOperationPassedEvent;

/**
 * Listens to interpreter events to detect finished jobs in order to wake up sleeping threads and
 * keep cached mappings in sync.
 *
 * @author Patrick Firnkes
 *
 */
public class FinishedJobsListener extends AbstractInterpreterListener {
    private InterpreterDefaultContext context;
    private JobSlotFirstFitStrategy strategy;

    public FinishedJobsListener(InterpreterDefaultContext mainContext) {
        this.context = mainContext;
        this.strategy = new JobSlotFirstFitStrategy(context);
        new JobSlotFirstFitStrategy(context).reset();
    }

    @Override
    public <R extends ProvidedRole, S extends Signature> void endAssemblyProvidedOperationCallInterpretation(
            AssemblyProvidedOperationPassedEvent<R, S> event) {

        if (event.getModelElement().getProvidingEntity_ProvidedRole().getEntityName()
                .equals(JobSlotFirstFitStrategy.COMPUTE_COMPONENT_NAME)) {
            strategy.jobFinished(event.getAssemblyContext());
        }
    }
}
