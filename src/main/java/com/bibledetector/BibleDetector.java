package com.bibledetector;

import com.bibledetector.flow.FlowHandler;
import com.bibledetector.flow.impl.BibleFlow;
import com.bibledetector.steps.bibleflow.impl.*;
import com.bibledetector.threads.ThreadExecutor;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class BibleDetector {
    public static void main(String[] args) throws LineUnavailableException, IOException {
        ExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        executorService.submit(BibleDetector::flowExecution);
    }

    private static void flowExecution() {
        FlowHandler flowHandler = new FlowHandler(
                List.of(
                    new BibleFlow(new DefaultExtractionImpl(),
                            new DefaultValidationImpl(),
                            new DefaultActionsImpl(),
                            new DefaultSelectionImpl(),
                            new DefaultExecutionImpl())
                )
        );

        flowHandler.start();
    }
}
