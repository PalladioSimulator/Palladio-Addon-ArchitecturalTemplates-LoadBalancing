package org.palladiosimulator.loadbalancingaction.observer;

import org.palladiosimulator.loadbalancingaction.strategy.JobSlotFirstFitStrategy;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.listener.AbstractInterpreterListener;
import org.palladiosimulator.simulizar.interpreter.listener.ModelElementPassedEvent;

/**
 * Listens to interpreter events to detect finished jobs in order to wake up sleeping threads and
 * keep cached mappings in sync.
 *
 * @author Patrick Firnkes
 *
 */
public class FinishedJobsListener extends AbstractInterpreterListener {
    private InterpreterDefaultContext context;

    public FinishedJobsListener(InterpreterDefaultContext mainContext) {
        this.context = mainContext;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.upb.pcm.interpreter.interpreter.listener.IInterpreterListener#
     * endUsageScenarioInterpretation
     * (de.upb.pcm.interpreter.interpreter.listener.ModelElementPassedEvent)
     */
    @Override
    public void endUsageScenarioInterpretation(final ModelElementPassedEvent<UsageScenario> event) {
        // TODO: this could be optimized by listening to
        // endAssemblyProvidedOperationCallInterpretation and calling
        // resetFreeSlotsOfContainer and wakeUpFitting.
        JobSlotFirstFitStrategy strategy = new JobSlotFirstFitStrategy(context);
        strategy.resetAllFreeSlots();
        strategy.wakeUpNext();
    }

}
