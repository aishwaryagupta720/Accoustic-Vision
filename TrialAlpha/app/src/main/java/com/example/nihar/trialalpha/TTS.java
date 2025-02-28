package com.example.nihar.trialalpha;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TTS {

    private static TextToSpeech mTTS;
    private static Locale lang= Locale.ENGLISH;
    public static void Initalize(Context ctx){
        mTTS = new TextToSpeech(ctx, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(lang);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {

                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
    }

    public static void speak(String text) {
        /*
        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
    */
        mTTS.setPitch((float) 1.0);
        mTTS.setSpeechRate((float)1.0);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }
    public static void destroy(){
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

    }

}
