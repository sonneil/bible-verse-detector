package com.bibledetector.flow;

import com.bibledetector.exceptions.FlowAbortedException;
import com.bibledetector.speechrecognition.SpeechRecognition;
import com.bibledetector.steps.*;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;

import javax.sound.sampled.*;
import java.io.IOException;

public class FlowHandler {

    private final SpeechRecognition speechRecognition;

    // Steps
    private final Extraction extraction;
    private final Validation validation;
    private final Actions actions;
    private final Selection selection;
    private final Execution execution;

    public FlowHandler(Extraction extraction, Validation validation, Actions actions, Selection selection, Execution execution) {
        this.speechRecognition = new SpeechRecognition();

        this.extraction = extraction;
        this.validation = validation;
        this.actions = actions;
        this.selection = selection;
        this.execution = execution;
    }

    public void start() throws LineUnavailableException, IOException {
        speechRecognition.startRecognition(extractionInput -> {
            try {
                StepResult extractionResult = executeStep(extraction, extractionInput);
                StepResult validationResult = executeStep(validation, validation.extractParam(extractionResult), extractionResult);
                StepResult actionResult = executeStep(actions, actions.extractParam(validationResult), validationResult);
                StepResult selectionResult = executeStep(selection, selection.extractParam(actionResult), actionResult);
                StepResult executionResult = executeStep(execution, execution.extractParam(selectionResult), selectionResult);

                logExecutionResult(executionResult);
            } catch (FlowAbortedException e) {
                System.out.println("Sent abort signal");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private StepResult executeStep(Step step, StepInput stepInput) {
        return step.run(stepInput);
    }

    private StepResult executeStep(Step step, StepInput stepInput, StepResult previousStepResult) throws FlowAbortedException {
        return switch (previousStepResult.resultStatusCode()) {
            case CONTINUE -> step.run(stepInput);
            case BACK, ABORT -> throw new FlowAbortedException("Flow aborted");
            default -> throw new IllegalArgumentException("Unrecognized status code");
        };
    }

    private void logExecutionResult(StepResult executionResult) {
        System.out.println("Execution Result: " + executionResult.toString());
    }
}
