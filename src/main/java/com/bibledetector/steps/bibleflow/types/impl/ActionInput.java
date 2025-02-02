package com.bibledetector.steps.bibleflow.types.impl;

import com.bibledetector.steps.types.StepInput;

import java.util.Objects;

public record ActionInput(String book, String chapter, String verse) implements StepInput {

    @Override
    public String toString() {
        return book + " " + chapter + (Objects.isNull(verse) || verse.isEmpty() ? "" : (":" + verse));
    }

    public String prettyString() {
        String toString = this.toString();
        if (toString.isEmpty()) return toString;
        if (toString.charAt(toString.length() - 1) == '-') {
            return toString.substring(0, toString.length()-1);
        }
        return toString;
    }
}
