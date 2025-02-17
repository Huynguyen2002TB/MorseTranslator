package com.example.morsetranslator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private TextView outputText;
    private Button convertButton, recordButton;

    private MorseConverter mMorseConverter;
    private MorseSoundPlayer mSoundPlayer;
    private MorseFlash mMorseFlash;
    private MorseAudioDecoder mAudioDecoder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //khoi tao doi tuong
        inputText  = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        convertButton = findViewById(R.id.convertButton);

        mMorseConverter = new MorseConverter();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        // Sự kiện nhấn nút "Convert"
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString().trim();
                if (input.isEmpty()) return;

                if (input.matches("[-.\\s/]+")) {
                    outputText.setText("Dịch Morse: " + mMorseConverter.morseToText(input));
                } else {
                    String morse = mMorseConverter.textToMorse(input);
                    outputText.setText("Mã Morse: " + morse);
                    // loi
//                    mSoundPlayer.playMorseSound(morse);
//                    mMorseFlash.flashMorseCode(morse);
                }
            }
        });

        // Sự kiện nhấn nút "Record"
//        recordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!mAudioDecoder.isRecording()) {
//                    mAudioDecoder.startRecording();
//                    recordButton.setText("Dừng ghi âm");
//                } else {
//                    mAudioDecoder.stopRecording();
//                    recordButton.setText("Ghi âm Morse");
//                }
//            }
//        });
    }

}