package com.firstapp.robinpc.tongue_twisters;

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

public class LEVEL5 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level5);
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

    // DIALOG FOR TT NUMBER 1
    public void TT1(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveone)
                .setTitle("Level 5 TT 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveone));
    }
    // DIALOG FOR TT NUMBER 2
    public void TT2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivetwo)
                .setTitle("Level 5 TT 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivetwo));
    }
    // DIALOG FOR TT NUMBER 3
    public void TT3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivethree)
                .setTitle("Level 5 TT 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivethree));
    }
    // DIALOG FOR TT NUMBER 4
    public void TT4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivefour)
                .setTitle("Level 5 TT 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivefour));
    }
    // DIALOG FOR TT NUMBER 5
    public void TT5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivefive)
                .setTitle("Level 5 TT 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivefive));
    }
    // DIALOG FOR TT NUMBER 6
    public void TT6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.six)
                .setTitle("Level 5 TT 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.six));
    }
    // DIALOG FOR TT NUMBER 7
    public void TT7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveseven)
                .setTitle("Level 5 TT 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveseven));
    }
    // DIALOG FOR TT NUMBER 8
    public void TT8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveeight)
                .setTitle("Level 5 TT 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveeight));
    }
    // DIALOG FOR TT NUMBER 9
    public void TT9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivenine)
                .setTitle("Level 5 TT 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivenine));
    }
    // DIALOG FOR TT NUMBER 10
    public void TT10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveten)
                .setTitle("Level 5 TT 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveten));
    }
    // DIALOG FOR TT NUMBER 11
    public void TT11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveeleven)
                .setTitle("Level 5 TT 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveeleven));
    }
    // DIALOG FOR TT NUMBER 12
    public void TT12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivetwelve)
                .setTitle("Level 5 TT 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivetwelve));
    }
    // DIALOG FOR TT NUMBER 13
    public void TT13(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivethirteen)
                .setTitle("Level 5 TT 13").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivethirteen));
    }
    // DIALOG FOR TT NUMBER 14
    public void TT14(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fiveforteen)
                .setTitle("Level 5 TT 14").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fiveforteen));
    }
    // DIALOG FOR TT NUMBER 15
    public void TT15(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.fivefifteen)
                .setTitle("Level 5 TT 15").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.fivefifteen));
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
