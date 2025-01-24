package com.bibledetector.steps.bibleflow.types.impl;

import com.bibledetector.steps.types.StepInput;

public record ExecutionInput(String book, String chapter, String verse) implements StepInput {
}
