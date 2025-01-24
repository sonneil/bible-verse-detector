package com.bibledetector.steps.bibleflow.types.step;

import com.bibledetector.steps.bibleflow.types.impl.ActionInput;

public interface Action {
    void execute(ActionInput actionInput);
}
