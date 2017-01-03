package com.firstapp.robinpc.tongue_twisters_deluxe.ui;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;

public class LEVEL3 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String[] levelThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        levelThree = getResources().getStringArray(R.array.three);

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        int tts_index;

        switch (v.getId()){

            case R.id.three1:{
                tts_index=0;
                autoSpeak(levelThree[tts_index]);
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.three2:{
                tts_index=1;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three3:{
                tts_index=2;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three4:{
                tts_index=3;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three5:{
                tts_index=4;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three6:{
                tts_index=5;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three7:{
                tts_index=6;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three8:{
                tts_index=7;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three9:{
                tts_index=8;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three10:{
                tts_index=9;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three11:{
                tts_index=10;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three12:{
                tts_index=11;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three13:{
                tts_index=12;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three14:{
                tts_index=13;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
            case R.id.three15:{
                tts_index=14;
                alert.setMessage(levelThree[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 2 TT " + (tts_index+1)).create().show();
                autoSpeak(levelThree[tts_index]);
                break;
            }
        }

    }

    private void autoSpeak(String text) {
        if (TextUtils.isEmpty(text) || tts == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "SpeakText");
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        stopTextToSpeech();
        super.onDestroy();
    }

    private synchronized void stopTextToSpeech() {
        if (tts == null) return;
        tts.stop();
        tts.shutdown();
        tts = null;
    }
    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.SUCCESS) {
            Log.d("InitTextToSpeech", "init text to speech failed; status: " + status);
            tts = null;
        }
    }
}
