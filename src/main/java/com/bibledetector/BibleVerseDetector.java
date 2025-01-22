package com.bibledetector;

import com.bibledetector.flow.FlowHandler;
import com.bibledetector.steps.impl.*;
import com.bibledetector.steps.impl.actions.restclient.RestClient;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class BibleVerseDetector {
    public static void main(String[] args) throws LineUnavailableException, IOException {
        FlowHandler flowHandler = new FlowHandler(
                new DefaultExtractionImpl(),
                new DefaultValidationImpl(),
                new DefaultActionsImpl(),
                new DefaultSelectionImpl(),
                new DefaultExecutionImpl()
        );

        flowHandler.start();
    }
}
