package com.bibledetector.flow;

import com.bibledetector.exceptions.FlowAbortedException;
import com.bibledetector.steps.types.Step;
import com.bibledetector.steps.types.SpeechRecognitionOutput;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;

@FunctionalInterface
public interface FlowExecution {
    void execute(SpeechRecognitionOutput extractionInput);

    default StepResult executeStep(Step step, StepInput stepInput) {
        return step.run(stepInput);
    }

    default StepResult executeStep(Step step, StepInput stepInput, StepResult previousStepResult) throws FlowAbortedException {
        return switch (previousStepResult.resultStatusCode()) {
            case CONTINUE -> step.run(stepInput);
            case BACK, ABORT -> throw new FlowAbortedException("Flow aborted");
            default -> throw new IllegalArgumentException("Unrecognized status code");
        };
    }
}
