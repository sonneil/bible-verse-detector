package com.bibledetector.flow;

import com.bibledetector.steps.types.impl.ExtractionInput;

@FunctionalInterface
public interface FlowExecution {
    void execute(ExtractionInput extractionInput);
}
