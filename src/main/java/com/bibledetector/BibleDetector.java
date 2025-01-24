package com.bibledetector;

import com.bibledetector.flow.FlowHandler;
import com.bibledetector.flow.impl.BibleFlow;
import com.bibledetector.steps.bibleflow.impl.*;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.List;

public class BibleDetector {
    public static void main(String[] args) throws LineUnavailableException, IOException {
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
