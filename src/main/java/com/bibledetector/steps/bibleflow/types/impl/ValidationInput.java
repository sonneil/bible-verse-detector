package com.bibledetector.steps.bibleflow.types.impl;

import com.bibledetector.steps.types.StepInput;

public record ValidationInput(String book, String chapter, String verse) implements StepInput {
}
