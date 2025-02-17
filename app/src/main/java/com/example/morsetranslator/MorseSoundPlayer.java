package com.example.morsetranslator;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;


public class MorseSoundPlayer {
    private ToneGenerator toneGenerator;

    public MorseSoundPlayer() {
        toneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
    }

    public void playMorseSound(String morseCode) {
        Handler handler = new Handler();
        long delay = 0;
        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                handler.postDelayed(() -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 200), delay);
                delay += 300;
            } else if (c == '-') {
                handler.postDelayed(() -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 600), delay);
                delay += 700;
            } else {
                delay += 300;
            }
        }
    }
}
