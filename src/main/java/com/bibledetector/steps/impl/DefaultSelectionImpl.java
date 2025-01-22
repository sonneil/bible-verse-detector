package com.bibledetector.steps.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.Selection;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.types.impl.*;

public class DefaultSelectionImpl implements Selection {
    @Override
    public StepResult run(StepInput selectionInput) {
        if (!(selectionInput instanceof SelectionInput)) return new SelectionResult(null, null, null, ResultStatusCode.ABORT);

        return new SelectionResult(
                ((SelectionInput) selectionInput).book(),
                ((SelectionInput) selectionInput).chapter(),
                ((SelectionInput) selectionInput).verse(),
                ResultStatusCode.CONTINUE);
    }

    @Override
    public StepInput extractParam(StepResult actionResult) {
        if (!(actionResult instanceof ActionResult)) throw new IllegalArgumentException("Invalid Action result type");

        return new SelectionInput(
                ((ActionResult) actionResult).book(),
                ((ActionResult) actionResult).chapter(),
                ((ActionResult) actionResult).verse());
    }
}
