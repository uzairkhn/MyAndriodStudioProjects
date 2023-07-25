package com.app.ttsexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(this, status -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setPitch(1f);
            textToSpeech.setSpeechRate(0.8f);
        });
    }

    public void doSomething(View view) {
        textToSpeech.speak("Hello My name is Uzair ",TextToSpeech.QUEUE_FLUSH,null);
    }
}