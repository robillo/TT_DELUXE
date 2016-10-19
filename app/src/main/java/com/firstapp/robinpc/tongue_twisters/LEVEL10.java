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

public class LEVEL10 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level10);
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
        oneonealert.setMessage(R.string.tenone)
                .setTitle("Level 10 TT 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenone));
    }
    // DIALOG FOR TT NUMBER 2
    public void TT2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tentwo)
                .setTitle("Level 10 TT 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tentwo));
    }
    // DIALOG FOR TT NUMBER 3
    public void TT3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenthree)
                .setTitle("Level 10 TT 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenthree));
    }
    // DIALOG FOR TT NUMBER 4
    public void TT4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenfour)
                .setTitle("Level 10 TT 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenfour));
    }
    // DIALOG FOR TT NUMBER 5
    public void TT5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenfive)
                .setTitle("Level 10 TT 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenfive));
    }
    // DIALOG FOR TT NUMBER 6
    public void TT6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tensix)
                .setTitle("Level 10 TT 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tensix));
    }
    // DIALOG FOR TT NUMBER 7
    public void TT7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenseven)
                .setTitle("Level 10 TT 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenseven));
    }
    // DIALOG FOR TT NUMBER 8
    public void TT8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.teneight)
                .setTitle("Level 10 TT 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.teneight));
    }
    // DIALOG FOR TT NUMBER 9
    public void TT9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tennine)
                .setTitle("Level 10 TT 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tennine));
    }
    // DIALOG FOR TT NUMBER 10
    public void TT10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenten)
                .setTitle("Level 10 TT 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenten));
    }
    // DIALOG FOR TT NUMBER 11
    public void TT11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.teneleven)
                .setTitle("Level 10 TT 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.teneleven));
    }
    // DIALOG FOR TT NUMBER 12
    public void TT12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tentwelve)
                .setTitle("Level 10 TT 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tentwelve));
    }
    // DIALOG FOR TT NUMBER 13
    public void TT13(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenthirteen)
                .setTitle("Level 10 TT 13").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenthirteen));
    }
    // DIALOG FOR TT NUMBER 14
    public void TT14(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(R.string.tenforteen)
                .setTitle("Level 10 TT 14").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenforteen));
    }
    // DIALOG FOR TT NUMBER 15
    public void TT15(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage("15.\tMr. Knott and Mr. Watt on the phone\n" +
                "Hello?\n" +
                "Who’s calling?\n" +
                "Watt.\n" +
                "What’s your name?\n" +
                "Watt’s my name.\n" +
                "Yes, what is your name?\n" +
                "My name is John Watt.\n" +
                "John what?\n" +
                "Yes.\n" +
                "All right, are you jones?\n" +
                "No, I am Knott.\n" +
                "Will you tell me your name, then?\n" +
                "Will Knott.\n" +
                "Why not?\n" +
                "My name is Knott.\n" +
                "Not what?\n" +
                "Not Watt. Knott.\n" +
                "What?\n")
                .setTitle("Level 10 TT 15").setIcon(R.drawable.dialog).create();
        oneonealert.show();
        autoSpeak(getResources().getString(R.string.tenfifteen));
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
