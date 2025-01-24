package com.bibledetector.steps.bibleflow.impl;

import com.bibledetector.constants.ResultStatusCode;
import com.bibledetector.steps.bibleflow.Extraction;
import com.bibledetector.steps.types.SpeechRecognitionOutput;
import com.bibledetector.steps.types.StepInput;
import com.bibledetector.steps.types.StepResult;
import com.bibledetector.steps.bibleflow.types.impl.ExtractionResult;
import com.bibledetector.utils.BooksUtils;
import com.bibledetector.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;

public class DefaultExtractionImpl implements Extraction {

    @Override
    public StepResult run(StepInput stepInput) {
        if (!(stepInput instanceof SpeechRecognitionOutput)) return new ExtractionResult(null, null, null, ResultStatusCode.ABORT);

        String text = NumberUtils.convertAllNumbersToDigits(((SpeechRecognitionOutput) stepInput).text());

        String book = StringUtils.capitalize(BooksUtils.extractBibleBookFromText(text));
        String chapter = BooksUtils.extractChapter(text);
        String verse = BooksUtils.extractVerse(text);

        return new ExtractionResult(book, chapter, verse, ResultStatusCode.CONTINUE);
    }

    @Override
    public StepInput extractParam(StepResult stepResult) {
        return new SpeechRecognitionOutput("");
    }
}
