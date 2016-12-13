package com.firstapp.robinpc.tongue_twisters_deluxe.model;

import android.speech.tts.TextToSpeech;
import android.util.Log;

/**
 * Created by robinkamboj on 14/12/16.
 */

public class tts implements TextToSpeech.OnInitListener{

    public TextToSpeech tts;

    @Override
    public void onInit(int status) {
        if(status!= TextToSpeech.SUCCESS){
            Log.d("InitTextToSpeech", "init text to speech failed; status: " + status);
            tts=null;
        }
    }
}
