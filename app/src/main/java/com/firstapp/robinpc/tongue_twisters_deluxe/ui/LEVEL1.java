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

public class LEVEL1 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Master this app, Master your pronunciation skills!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
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

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        String[] array={getString(R.string.one1),getString(R.string.one2),getString(R.string.one3),
                getString(R.string.one4),getString(R.string.one5),getString(R.string.one6),
                getString(R.string.one7),getString(R.string.one8),getString(R.string.one9),
                getString(R.string.one10),getString(R.string.one11),getString(R.string.one12),
                getString(R.string.one13),getString(R.string.one14),getString(R.string.one15)};

        int tts_index;

        switch (v.getId()){

            case R.id.one1:{
                tts_index=0;
                autoSpeak(array[tts_index]);
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.one2:{
                tts_index=1;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one3:{
                tts_index=2;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one4:{
                tts_index=3;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one5:{
                tts_index=4;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one6:{
                tts_index=5;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one7:{
                tts_index=6;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one8:{
                tts_index=7;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one9:{
                tts_index=8;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one10:{
                tts_index=9;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one11:{
                tts_index=10;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one12:{
                tts_index=11;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one13:{
                tts_index=12;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one14:{
                tts_index=13;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
            case R.id.one15:{
                tts_index=14;
                alert.setMessage(array[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 1 TT " + (tts_index+1)).create().show();
                autoSpeak(array[tts_index]);
                break;
            }
        }
        
    }

}
