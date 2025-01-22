package com.bibledetector.speechrecognition.config;

public class SpeechConfiguration {
    public final static String MODEL_DIRECTORY = "vosk-model-small-es";
    public final static String END_SPEECH_RECOGNITION_PHRASE = "FINALIZAR RECONOCIMIENTO";

    // Audio config
    public final static int AUDIO_SAMPLE_RATE = 48000;
    public final static int AUDIO_SAMPLE_SIZE_BITS = 16;
    public final static int AUDIO_CHANNELS = 1;
    public final static boolean AUDIO_BITS_SIGNED = true;
    public final static boolean AUDIO_BITS_BIG_INDIAN = false;

    // Recognizer config
    public final static int RECOGNIZER_BUFFER_SIZE = 8192;

}
