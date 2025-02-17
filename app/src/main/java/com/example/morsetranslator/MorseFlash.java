package com.example.morsetranslator;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Handler;

public class MorseFlash {
    private CameraManager cameraManager;
    private String cameraId;

    public MorseFlash(Context context) {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void flashMorseCode(String morseCode) {
        Handler handler = new Handler();
        long delay = 0;
        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                handler.postDelayed(() -> toggleFlash(true), delay);
                handler.postDelayed(() -> toggleFlash(false), delay + 200);
                delay += 300;
            } else if (c == '-') {
                handler.postDelayed(() -> toggleFlash(true), delay);
                handler.postDelayed(() -> toggleFlash(false), delay + 600);
                delay += 700;
            } else {
                delay += 300;
            }
        }
    }

    private void toggleFlash(boolean status) {
        try {
            cameraManager.setTorchMode(cameraId, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

