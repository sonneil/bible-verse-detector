package com.bibledetector.steps.types.impl;

import com.bibledetector.steps.types.StepInput;

public record SelectionInput(String book, String chapter, String verse) implements StepInput {
}
