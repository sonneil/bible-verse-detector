package com.bibledetector.steps.bibleflow.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.bibleflow.Actions;
import com.bibledetector.steps.bibleflow.impl.actions.GoLiveOpenLP;
import com.bibledetector.steps.bibleflow.impl.actions.GoLivePRS;
import com.bibledetector.steps.bibleflow.impl.actions.windows.OpenLPConfirmation;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.bibleflow.types.impl.ActionInput;
import com.bibledetector.steps.bibleflow.types.impl.ActionResult;
import com.bibledetector.steps.bibleflow.types.impl.ValidationResult;
import com.bibledetector.steps.bibleflow.types.step.Action;

import java.util.ArrayList;
import java.util.List;

public class DefaultActionsImpl implements Actions {
    @Override
    public StepResult run(StepInput actionInput) {
        if (!(actionInput instanceof ActionInput)) return new ActionResult(null, null, null, ResultStatusCode.ABORT);

        List<Action> actions = new ArrayList<>();
        actions.add(new GoLiveOpenLP());
        actions.add(new GoLivePRS());

        OpenLPConfirmation.display(new GoLiveOpenLP(), (ActionInput) actionInput);

        return new ActionResult(
                ((ActionInput) actionInput).book(),
                ((ActionInput) actionInput).chapter(),
                ((ActionInput) actionInput).verse(),
                ResultStatusCode.CONTINUE);
    }

    @Override
    public StepInput extractParam(StepResult validationResult) {
        if (!(validationResult instanceof ValidationResult)) throw new IllegalArgumentException("Invalid Validation result type");

        return new ActionInput(
                ((ValidationResult) validationResult).book(),
                ((ValidationResult) validationResult).chapter(),
                ((ValidationResult) validationResult).verse());
    }
}
