package com.bibledetector.steps.bibleflow.types.impl;

import com.bibledetector.steps.types.StepInput;

import java.util.Objects;

public record ActionInput(String book, String chapter, String verse) implements StepInput {

    @Override
    public String toString() {
        return book + " " + chapter + (Objects.isNull(verse) || verse.isEmpty() ? "" : (":" + verse));
    }
}
