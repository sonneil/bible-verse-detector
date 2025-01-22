package com.bibledetector.steps.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.Extraction;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.types.impl.ExtractionInput;
import com.bibledetector.steps.types.impl.ExtractionResult;
import com.bibledetector.utils.BooksUtils;
import com.bibledetector.utils.NumberUtils;

import java.util.List;

public class DefaultExtractionImpl implements Extraction {

    @Override
    public StepResult run(StepInput extractionInput) {
        if (!(extractionInput instanceof ExtractionInput)) return new ExtractionResult(null, null, null, ResultStatusCode.ABORT);

        String text = NumberUtils.convertAllNumbersToDigits(((ExtractionInput) extractionInput).text());

        String book = BooksUtils.extractBibleBookFromText(text);
        String chapter = BooksUtils.extractChapter(text);
        String verse = BooksUtils.extractVerse(text);

        return new ExtractionResult(book, chapter, verse, ResultStatusCode.CONTINUE);
    }

    @Override
    public StepInput extractParam(StepResult stepResult) {
        return new ExtractionInput("");
    }
}
