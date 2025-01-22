package com.bibledetector.steps;

import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;

public interface Step {
    StepResult run(StepInput stepInput);

    StepInput extractParam(StepResult stepResult);
}
