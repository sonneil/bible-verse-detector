package com.bibledetector.speechrecognition;

import com.bibledetector.flow.FlowExecution;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bibledetector.steps.types.impl.ExtractionInput;
import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;
import java.io.IOException;

import static com.bibledetector.speechrecognition.config.SpeechConfiguration.*;

public class SpeechRecognition {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void startRecognition(FlowExecution flowExecution) throws IOException, LineUnavailableException {
        try (Model model = new Model(MODEL_DIRECTORY)) {

            // Define audio format
            AudioFormat format = new AudioFormat(AUDIO_SAMPLE_RATE, AUDIO_SAMPLE_SIZE_BITS, AUDIO_CHANNELS, AUDIO_BITS_SIGNED, AUDIO_BITS_BIG_INDIAN);

            // Set up microphone input
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.err.println("Microphone not supported!");
                throw new RuntimeException("Microphone not supported!");
            }

            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            System.out.println("Started recognition...");

            // Initialize the recognizer
            try (Recognizer recognizer = new Recognizer(model, AUDIO_SAMPLE_RATE)) {
                byte[] buffer = new byte[RECOGNIZER_BUFFER_SIZE];
                while (true) {
                    int bytesRead = microphone.read(buffer, 0, buffer.length);
                    if (bytesRead > 0) {
                        if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                            ExtractionInput extractionInput = objectMapper.readValue(recognizer.getFinalResult(), ExtractionInput.class);
                            if (END_SPEECH_RECOGNITION_PHRASE.equalsIgnoreCase(extractionInput.text())) {
                                System.out.println("Finalizando reconocimiento de voz.");
                                break;
                            }

                            flowExecution.execute(extractionInput);

                        }
                    }
                }
            } finally {
                microphone.stop();
                microphone.close();
            }
        } catch (IOException e) {
            System.err.println("Error initializing Vosk model: " + e.getMessage());
            throw e;
        } catch (LineUnavailableException e) {
            System.err.println("Microphone unavailable: " + e.getMessage());
            throw e;
        }
    }
}
