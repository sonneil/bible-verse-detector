package com.bibledetector.steps.bibleflow.types.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.types.StepResult;

public record ExtractionResult(String book, String chapter, String verse, ResultStatusCode statusCode) implements StepResult {
    @Override
    public ResultStatusCode resultStatusCode() {
        return statusCode;
    }
}
