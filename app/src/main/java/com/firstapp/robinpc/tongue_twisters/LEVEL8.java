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

import org.w3c.dom.Text;

public class LEVEL8 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level8);
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
        oneonealert.setMessage(R.string.eightone)
                .setTitle("Level 8 TT 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightone));
    }
    // DIALOG FOR TT NUMBER 2
    public void TT2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eighttwo)
                .setTitle("Level 8 TT 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eighttwo));
    }
    // DIALOG FOR TT NUMBER 3
    public void TT3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightthree)
                .setTitle("Level 8 TT 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightthree));
    }
    // DIALOG FOR TT NUMBER 4
    public void TT4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightfour)
                .setTitle("Level 8 TT 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightfour));
    }
    // DIALOG FOR TT NUMBER 5
    public void TT5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightfive)
                .setTitle("Level 8 TT 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightfive));
    }
    // DIALOG FOR TT NUMBER 6
    public void TT6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightsix)
                .setTitle("Level 8 TT 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightsix));
    }
    // DIALOG FOR TT NUMBER 7
    public void TT7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightseven)
                .setTitle("Level 8 TT 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightseven));
    }
    // DIALOG FOR TT NUMBER 8
    public void TT8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eighteight)
                .setTitle("Level 8 TT 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eighteight));
    }
    // DIALOG FOR TT NUMBER 9
    public void TT9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightnine)
                .setTitle("Level 8 TT 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightnine));
    }
    // DIALOG FOR TT NUMBER 10
    public void TT10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightten)
                .setTitle("Level 8 TT 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightten));
    }
    // DIALOG FOR TT NUMBER 11
    public void TT11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eighteleven)
                .setTitle("Level 8 TT 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eighteleven));
    }
    // DIALOG FOR TT NUMBER 12
    public void TT12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eighttwelve)
                .setTitle("Level 8 TT 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eighttwelve));
    }
    // DIALOG FOR TT NUMBER 13
    public void TT13(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightthirteen)
                .setTitle("Level 8 TT 13").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightthirteen));
    }
    // DIALOG FOR TT NUMBER 14
    public void TT14(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage("14.\tMy friend Gladys Oh, the sadness of her sadness when she’s sad.\n" +
                "Oh, the gladness of her gladness when she’s glad. But the sadness of her sadness, and the gladness of her gladness, are nothing like her madness when she’s mad.\n")
                .setTitle("Level 8 TT 14").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightforteen));
    }
    // DIALOG FOR TT NUMBER 15
    public void TT15(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.eightfifteen)
                .setTitle("Level 8 TT 15").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.eightfifteen));
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
