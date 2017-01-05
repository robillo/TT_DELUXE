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

public class LEVEL8 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String[] levelNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.level8);
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);

        levelNine = getResources().getStringArray(R.array.nine);

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        int tts_index;

        switch (v.getId()){

            case R.id.eight1:{
                tts_index=0;
                autoSpeak(levelNine[tts_index]);
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.eight2:{
                tts_index=1;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight3:{
                tts_index=2;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight4:{
                tts_index=3;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight5:{
                tts_index=4;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight6:{
                tts_index=5;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight7:{
                tts_index=6;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight8:{
                tts_index=7;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight9:{
                tts_index=8;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight10:{
                tts_index=9;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight11:{
                tts_index=10;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight12:{
                tts_index=11;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight13:{
                tts_index=12;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight14:{
                tts_index=13;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
                break;
            }
            case R.id.eight15:{
                tts_index=14;
                alert.setMessage(levelNine[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 8 TT " + (tts_index+1)).create().show();
                autoSpeak(levelNine[tts_index]);
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
