package com.bibledetector.flow;

import com.bibledetector.speechrecognition.SpeechRecognition;
import com.bibledetector.utils.RestClient;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.List;

public class FlowHandler {

    private final SpeechRecognition speechRecognition;
    private final List<FlowExecution> flows;

    public FlowHandler(List<FlowExecution> flows) {
        this.speechRecognition = new SpeechRecognition();
        this.flows = flows;
    }

    public void start() {
        try {
            speechRecognition.startRecognition(flows);
        } catch (IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        } finally {
            RestClient.getClient().close();
        }
    }
}
