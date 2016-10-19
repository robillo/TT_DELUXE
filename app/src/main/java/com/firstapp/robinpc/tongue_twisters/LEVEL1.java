package com.firstapp.robinpc.tongue_twisters;

import android.content.DialogInterface;
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
import android.widget.Button;

import java.util.Locale;

public class LEVEL1 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private String temp;

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



    // DIALOG FOR TT NUMBER 1
    public void TT1(View view)
    {
        temp=getResources().getString(R.string.oneone);
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(temp)
                .setTitle("Level 1 TT 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(temp);

    }
    // DIALOG FOR TT NUMBER 2
    public void TT2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onetwo))
                .setTitle("Level 1 TT 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onetwo));
    }
    // DIALOG FOR TT NUMBER 3
    public void TT3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onethree))
                .setTitle("Level 1 TT 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR TT NUMBER 4
    public void TT4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onefour))
                .setTitle("Level 1 TT 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onefour));
    }
    // DIALOG FOR TT NUMBER 5
    public void TT5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onefive))
                .setTitle("Level 1 TT 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onefive));
    }
    // DIALOG FOR TT NUMBER 6
    public void TT6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onesix))
                .setTitle("Level 1 TT 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onesix));
    }
    // DIALOG FOR TT NUMBER 7
    public void TT7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.oneseven))
                .setTitle("Level 1 TT 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.oneseven));
    }
    // DIALOG FOR TT NUMBER 8
    public void TT8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.oneeight))
                .setTitle("Level 1 TT 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.oneeight));
    }
    // DIALOG FOR TT NUMBER 9
    public void TT9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onenine))
                .setTitle("Level 1 TT 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onenine));
    }
    // DIALOG FOR TT NUMBER 10
    public void TT10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.oneten))
                .setTitle("Level 1 TT 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.oneten));
    }
    // DIALOG FOR TT NUMBER 11
    public void TT11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.oneeleven))
                .setTitle("Level 1 TT 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.oneeleven));
    }
    // DIALOG FOR TT NUMBER 12
    public void TT12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onetwelve))
                .setTitle("Level 1 TT 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onetwelve));
    }
    // DIALOG FOR TT NUMBER 13
    public void TT13(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onethirteen))
                .setTitle("Level 1 TT 13").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onethirteen));
    }
    // DIALOG FOR TT NUMBER 14
    public void TT14(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.oneforteen))
                .setTitle("Level 1 TT 14").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.oneforteen));
    }
    // DIALOG FOR TT NUMBER 15
    public void TT15(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getString(R.string.onefifteen))
                .setTitle("Level 1 TT 15").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.onefifteen));
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
