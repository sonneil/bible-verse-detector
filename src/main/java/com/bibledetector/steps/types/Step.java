package com.bibledetector.steps.types;

public interface Step {
    StepResult run(StepInput stepInput);

    StepInput extractParam(StepResult stepResult);
}
