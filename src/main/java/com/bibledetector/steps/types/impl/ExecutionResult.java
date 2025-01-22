package com.bibledetector.steps.types.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.types.StepResult;

public record ExecutionResult(String outputMessage, ResultStatusCode statusCode) implements StepResult {
    @Override
    public ResultStatusCode resultStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return statusCode().name() + ":" + outputMessage;
    }
}
