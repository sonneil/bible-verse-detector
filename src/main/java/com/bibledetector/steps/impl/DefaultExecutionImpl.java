package com.bibledetector.steps.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.Execution;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.types.impl.*;

public class DefaultExecutionImpl implements Execution {

    @Override
    public StepResult run(StepInput executionInput) {
        if (!(executionInput instanceof ExecutionInput)) return new ExecutionResult(null, ResultStatusCode.ABORT);

        return new ExecutionResult("Execution completed", ResultStatusCode.CONTINUE);
    }

    @Override
    public StepInput extractParam(StepResult selectionResult) {
        if (!(selectionResult instanceof SelectionResult)) throw new IllegalArgumentException("Invalid Selection result type");

        return new ExecutionInput(
                ((SelectionResult) selectionResult).book(),
                ((SelectionResult) selectionResult).chapter(),
                ((SelectionResult) selectionResult).verse());
    }
}
