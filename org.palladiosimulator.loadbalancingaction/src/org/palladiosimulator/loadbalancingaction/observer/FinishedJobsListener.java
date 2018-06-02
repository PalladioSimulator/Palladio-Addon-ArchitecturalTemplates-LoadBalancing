package org.palladiosimulator.loadbalancingaction.observer;

import org.palladiosimulator.loadbalancingaction.strategy.JobSlotFirstFitStrategy;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.simulizar.interpreter.listener.AbstractInterpreterListener;
import org.palladiosimulator.simulizar.interpreter.listener.ModelElementPassedEvent;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;


/**
 * Listens to interpreter events to detect finished jobs in order to wake up sleeping threads.
 *
 * @author Patrick Firnkes
 *
 */
public class FinishedJobsListener extends AbstractInterpreterListener {
    /*
     * (non-Javadoc)
     *
     * @see de.upb.pcm.interpreter.interpreter.listener.IInterpreterListener#
     * endUsageScenarioInterpretation
     * (de.upb.pcm.interpreter.interpreter.listener.ModelElementPassedEvent)
     */
    @Override
    public void endUsageScenarioInterpretation(final ModelElementPassedEvent<UsageScenario> event) {
        SimuComSimProcess sleepingThread = JobSlotFirstFitStrategy.JOB_QUEUE.poll();
        if (sleepingThread != null) {
            sleepingThread.activate();
        }
    }
}
