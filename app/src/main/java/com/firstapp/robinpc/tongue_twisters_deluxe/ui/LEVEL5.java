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

public class LEVEL5 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String[] levelFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        levelFive = getResources().getStringArray(R.array.five);

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        int tts_index;

        switch (v.getId()){

            case R.id.five1:{
                tts_index=0;
                autoSpeak(levelFive[tts_index]);
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.five2:{
                tts_index=1;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five3:{
                tts_index=2;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five4:{
                tts_index=3;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five5:{
                tts_index=4;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five6:{
                tts_index=5;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five7:{
                tts_index=6;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five8:{
                tts_index=7;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five9:{
                tts_index=8;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five10:{
                tts_index=9;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five11:{
                tts_index=10;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five12:{
                tts_index=11;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five13:{
                tts_index=12;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five14:{
                tts_index=13;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
                break;
            }
            case R.id.five15:{
                tts_index=14;
                alert.setMessage(levelFive[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 5 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFive[tts_index]);
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
