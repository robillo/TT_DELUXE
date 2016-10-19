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

public class LEVEL3 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3);
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
        oneonealert.setMessage(getResources().getString(R.string.threeone))
                .setTitle("Level 3 TT 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeone));
    }
    // DIALOG FOR TT NUMBER 2
    public void TT2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getResources().getString(R.string.threetwo))
                .setTitle("Level 3 TT 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threetwo));
    }
    // DIALOG FOR TT NUMBER 3
    public void TT3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(getResources().getString(R.string.threethree))
                .setTitle("Level 3 TT 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threethree));
    }
    // DIALOG FOR TT NUMBER 4
    public void TT4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threefour)
                .setTitle("Level 3 TT 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threefour));
    }
    // DIALOG FOR TT NUMBER 5
    public void TT5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threefive)
                .setTitle("Level 3 TT 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threefive));
    }
    // DIALOG FOR TT NUMBER 6
    public void TT6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threesix)
                .setTitle("Level 3 TT 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threesix));
    }
    // DIALOG FOR TT NUMBER 7
    public void TT7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threeseven)
                .setTitle("Level 3 TT 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeseven));
    }
    // DIALOG FOR TT NUMBER 8
    public void TT8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threeeight)
                .setTitle("Level 3 TT 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeeight));
    }
    // DIALOG FOR TT NUMBER 9
    public void TT9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threenine)
                .setTitle("Level 3 TT 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threenine));
    }
    // DIALOG FOR TT NUMBER 10
    public void TT10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threeten)
                .setTitle("Level 3 TT 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeten));
    }
    // DIALOG FOR TT NUMBER 11
    public void TT11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threeeleven)
                .setTitle("Level 3 TT 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeeleven));
    }
    // DIALOG FOR TT NUMBER 12
    public void TT12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threetwelve)
                .setTitle("Level 3 TT 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threetwelve));
    }
    // DIALOG FOR TT NUMBER 13
    public void TT13(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threethirteen)
                .setTitle("Level 3 TT 13").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threethirteen));
    }
    // DIALOG FOR TT NUMBER 14
    public void TT14(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threeforteen)
                .setTitle("Level 3 TT 14").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threeforteen));
    }
    // DIALOG FOR TT NUMBER 15
    public void TT15(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.threefifteen)
                .setTitle("Level 3 TT 15").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.threefifteen));
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
