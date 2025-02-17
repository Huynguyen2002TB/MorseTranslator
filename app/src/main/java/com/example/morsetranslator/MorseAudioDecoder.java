package com.example.morsetranslator;

import android.content.Context;
import android.media.MediaRecorder;

public class MorseAudioDecoder {
    private MediaRecorder recorder;
    private boolean isRecording = false;
    private String filePath;

    public MorseAudioDecoder(Context context) {
        filePath = context.getExternalCacheDir().getAbsolutePath() + "/morse.3gp";
    }

    public void startRecording() {
        if (isRecording) return;

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(filePath);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
            recorder.start();
            isRecording = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        if (!isRecording) return;

        try {
            recorder.stop();
            recorder.release();
            recorder = null;
            isRecording = false;
            decodeMorseFromAudio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void decodeMorseFromAudio() {
        String detectedMorse = "... --- ..."; // Giả lập SOS
        System.out.println("Giải mã: " + MorseConverter.morseToText(detectedMorse));
    }

    public boolean isRecording() {
        return isRecording;
    }
}

