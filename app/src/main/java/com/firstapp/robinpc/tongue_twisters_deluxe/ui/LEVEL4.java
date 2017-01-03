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

public class LEVEL4 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String[] levelFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        levelFour = getResources().getStringArray(R.array.four);

        tts = new TextToSpeech(this, this);
        autoSpeak("Tongue Twisters");
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        tts= new TextToSpeech(this,this);
        int tts_index;

        switch (v.getId()){

            case R.id.four1:{
                tts_index=0;
                autoSpeak(levelFour[tts_index]);
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                break;
            }
            case R.id.four2:{
                tts_index=1;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four3:{
                tts_index=2;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four4:{
                tts_index=3;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four5:{
                tts_index=4;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four6:{
                tts_index=5;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four7:{
                tts_index=6;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four8:{
                tts_index=7;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four9:{
                tts_index=8;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four10:{
                tts_index=9;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four11:{
                tts_index=10;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four12:{
                tts_index=11;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four13:{
                tts_index=12;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four14:{
                tts_index=13;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
                break;
            }
            case R.id.four15:{
                tts_index=14;
                alert.setMessage(levelFour[tts_index]).setIcon(R.drawable.dialog).setTitle("LEVEL 4 TT " + (tts_index+1)).create().show();
                autoSpeak(levelFour[tts_index]);
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
