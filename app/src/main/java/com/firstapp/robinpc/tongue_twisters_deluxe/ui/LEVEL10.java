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

public class LEVEL10 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String[] levelTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.level10);
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Master this app, Master your pronunciation skills!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


        levelTen= getResources().getStringArray(R.array.ten);

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        int tts_index;

        switch (v.getId()){

            case R.id.one1:{
                tts_index=0;
                autoSpeak(levelTen[tts_index]);
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.one2:{
                tts_index=1;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one3:{
                tts_index=2;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one4:{
                tts_index=3;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one5:{
                tts_index=4;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one6:{
                tts_index=5;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one7:{
                tts_index=6;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one8:{
                tts_index=7;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one9:{
                tts_index=8;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one10:{
                tts_index=9;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one11:{
                tts_index=10;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one12:{
                tts_index=11;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one13:{
                tts_index=12;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one14:{
                tts_index=13;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
                break;
            }
            case R.id.one15:{
                tts_index=14;
                alert.setMessage(levelTen[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(levelTen[tts_index]);
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
