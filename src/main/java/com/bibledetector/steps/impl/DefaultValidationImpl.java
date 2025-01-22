package com.bibledetector.steps.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.Validation;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.types.impl.*;
import com.bibledetector.utils.BooksUtils;

public class DefaultValidationImpl implements Validation {
    @Override
    public StepResult run(StepInput validationInput) {
        if (!(validationInput instanceof ValidationInput)) return new ValidationResult(null, null, null, ResultStatusCode.ABORT);

        if (!validInput((ValidationInput)validationInput)) {
            return new ValidationResult(null, null, null, ResultStatusCode.ABORT);
        }

        return new ValidationResult(
                ((ValidationInput) validationInput).book(),
                ((ValidationInput) validationInput).chapter(),
                ((ValidationInput) validationInput).verse(),
                ResultStatusCode.CONTINUE);
    }

    private boolean validInput(ValidationInput validationInput) {
        return !(validationInput.book() == null ||
                validationInput.book().isEmpty() ||
                !BooksUtils.bibleBooks().contains(validationInput.book()));
    }

    @Override
    public StepInput extractParam(StepResult stepResult) {
        if (!(stepResult instanceof ExtractionResult)) throw new IllegalArgumentException("Invalid Extraction result result type.");

        return new ValidationInput(
                ((ExtractionResult) stepResult).book(),
                ((ExtractionResult) stepResult).chapter(),
                ((ExtractionResult) stepResult).verse());
    }
}
