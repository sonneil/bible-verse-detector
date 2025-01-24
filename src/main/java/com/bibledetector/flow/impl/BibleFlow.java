package com.bibledetector.flow.impl;

import com.bibledetector.exceptions.FlowAbortedException;
import com.bibledetector.flow.FlowExecution;
import com.bibledetector.steps.bibleflow.*;
import com.bibledetector.steps.types.SpeechRecognitionOutput;
import com.bibledetector.steps.types.StepResult;

public class BibleFlow implements FlowExecution {
    // Steps
    private final Extraction extraction;
    private final Validation validation;
    private final Actions actions;
    private final Selection selection;
    private final Execution execution;

    public BibleFlow(Extraction extraction, Validation validation, Actions actions, Selection selection, Execution execution) {
        this.extraction = extraction;
        this.validation = validation;
        this.actions = actions;
        this.selection = selection;
        this.execution = execution;
    }

    @Override
    public void execute(SpeechRecognitionOutput speechRecognitionOutput) {
        try {
            StepResult extractionResult = executeStep(extraction, speechRecognitionOutput);
            StepResult validationResult = executeStep(validation, validation.extractParam(extractionResult), extractionResult);
            StepResult actionResult = executeStep(actions, actions.extractParam(validationResult), validationResult);
            StepResult selectionResult = executeStep(selection, selection.extractParam(actionResult), actionResult);
            StepResult executionResult = executeStep(execution, execution.extractParam(selectionResult), selectionResult);

            logExecutionResult(executionResult);
        } catch (FlowAbortedException | IllegalArgumentException e) {
            // TODO: Do something
        }
    }

    private void logExecutionResult(StepResult executionResult) {
        // TODO: Do something
    }
}
