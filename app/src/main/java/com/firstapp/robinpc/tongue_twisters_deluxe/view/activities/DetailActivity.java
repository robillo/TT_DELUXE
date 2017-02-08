package com.firstapp.robinpc.tongue_twisters_deluxe.view.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.Recycler_View_Adapter;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.RecyclerviewTouchListener;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DetailActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{


    CoordinatorLayout coordinatorLayout;
    TextView mainText, header1, header2;
    Context context;
    private TextToSpeech tts;
    private int level_number;
    private String[] level_headers, level_twisters;
    List<Data> data;
    ListIterator<Data> dataListIterator;
    Button prev, next;
    Data test_data;
    FloatingActionButton fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fb=(FloatingActionButton)findViewById(R.id.fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);

        header1 = (TextView) findViewById(R.id.header1);
        header2 = (TextView) findViewById(R.id.header2);
        mainText = (TextView) findViewById(R.id.mainText);
        context = getApplicationContext();

        Intent i = getIntent();
        level_number = i.getIntExtra("level_number", 1);

        inflateInfo();

        data = fillWithData();
        dataListIterator = data.listIterator();

        test_data = dataListIterator.next();

        header1.setText(test_data.Title);
        header2.setText(test_data.subTitle);
        mainText.setText(test_data.TT);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);

        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);

        //for RV Touch Listener
        recyclerView.addOnItemTouchListener(new RecyclerviewTouchListener(context, recyclerView, new RecyclerviewTouchListener.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                //Toast.makeText(context, "ROBIN " + position, Toast.LENGTH_SHORT).show();
                //to take dataListIterator to 0 index
                while (dataListIterator.hasPrevious()){
                    test_data = dataListIterator.previous();
                }

                if(position == 0){
                    header1.setText(test_data.Title);
                    header2.setText(test_data.subTitle);
                    mainText.setText(test_data.TT);
                    prev.setEnabled(false);
                    if(!next.isEnabled())
                        next.setEnabled(true);
                }
                else {
                    for(int i = 0; i <= position; i++){
                        test_data = dataListIterator.next();
                    }
                    header1.setText(test_data.Title);
                    header2.setText(test_data.subTitle);
                    mainText.setText(test_data.TT);
                    if(position < 14){
                        if(!prev.isEnabled())
                            prev.setEnabled(true);
                        if(!next.isEnabled())
                            next.setEnabled(true);
                    }
                    if(position == 14){
                        if(!prev.isEnabled())
                            prev.setEnabled(true);
                        if(next.isEnabled())
                            next.setEnabled(false);
                    }
                }

            }

            @Override
            public void onLongClick(View v, int position) {
                //Toast.makeText(context, "ROBIN ", Toast.LENGTH_SHORT).show();
                while (dataListIterator.hasPrevious()){
                    test_data = dataListIterator.previous();
                }

                if(position == 0){
                    header1.setText(test_data.Title);
                    header2.setText(test_data.subTitle);
                    mainText.setText(test_data.TT);
                    prev.setEnabled(false);
                    if(!next.isEnabled())
                        next.setEnabled(true);
                }
                else {
                    for(int i = 0; i <= position; i++){
                        test_data = dataListIterator.next();
                    }
                    header1.setText(test_data.Title);
                    header2.setText(test_data.subTitle);
                    mainText.setText(test_data.TT);
                    if(position < 14){
                        if(!prev.isEnabled())
                            prev.setEnabled(true);
                        if(!next.isEnabled())
                            next.setEnabled(true);
                    }
                    if(position == 14){
                        if(!prev.isEnabled())
                            prev.setEnabled(true);
                        if(next.isEnabled())
                            next.setEnabled(false);
                    }
                }
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //nonspection SimplifiableIfStatement

        switch (id){
            case R.id.action_settings:{
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
            }
            case R.id.action_stop_tts:{
                if(tts.isSpeaking()){
                    tts.stop();
                    Snackbar.make(coordinatorLayout, "TTS Stopped.", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Snackbar.make(coordinatorLayout, "TTS is already off.", Snackbar.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.action_about:{
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            }
            case R.id.action_rate:{
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe"));
                startActivity(i);
                break;
            }
            case R.id.action_share:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hey, Check out this exciting App at: https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe");
                i.setType("text/plain");
                startActivity(i);
                break;
            }
            case R.id.action_share_current_twister:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, header2.getText() + ": \n " + mainText.getText());
                i.setType("text/plain");
                startActivity(i);
                break;
            }
            case android.R.id.home:{
                onBackPressed();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }


    private void inflateInfo() {
        switch (level_number){
            case 1:{
                level_headers = getResources().getStringArray(R.array.one_headers);
                level_twisters = getResources().getStringArray(R.array.one);
                break;
            }
            case 2:{
                level_headers = getResources().getStringArray(R.array.two_headers);
                level_twisters = getResources().getStringArray(R.array.two);
                break;
            }
            case 3:{
                level_headers = getResources().getStringArray(R.array.three_headers);
                level_twisters = getResources().getStringArray(R.array.three);
                break;
            }
            case 4:{
                level_headers = getResources().getStringArray(R.array.four_headers);
                level_twisters = getResources().getStringArray(R.array.four);
                break;
            }
            case 5:{
                level_headers = getResources().getStringArray(R.array.five_headers);
                level_twisters = getResources().getStringArray(R.array.five);
                break;
            }
            case 6:{
                level_headers = getResources().getStringArray(R.array.six_headers);
                level_twisters = getResources().getStringArray(R.array.six);
                break;
            }
            case 7:{
                level_headers = getResources().getStringArray(R.array.seven_headers);
                level_twisters = getResources().getStringArray(R.array.seven);
                break;
            }
            case 8:{
                level_headers = getResources().getStringArray(R.array.eight_headers);
                level_twisters = getResources().getStringArray(R.array.eight);
                break;
            }
            case 9:{
                level_headers = getResources().getStringArray(R.array.nine_headers);
                level_twisters = getResources().getStringArray(R.array.nine);
                break;
            }
            case 10:{
                level_headers = getResources().getStringArray(R.array.ten_headers);
                level_twisters = getResources().getStringArray(R.array.ten);
                break;
            }
        }
    }

    private List<Data> fillWithData() {
        List<Data> data = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            data.add(new Data("LEVEL " + level_number + " TT " + i, level_headers[i - 1], level_twisters[i - 1]));
        }
        return data;
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab: {
                //progressBar.setVisibility(View.VISIBLE);
                //progressBar.setIndeterminate(true);
                if (tts.isSpeaking()) {
                    tts.stop();
                }
                autoSpeak((String) mainText.getText());
                /*while (tts.isSpeaking()){
                    stop_tts.setVisibility(View.VISIBLE);
                }*/

                //above part supposed to be in a thread

                break;
            }

            case R.id.prev: {
                if (dataListIterator.hasPrevious()) {
                    test_data = dataListIterator.previous();
                    if (test_data.Title != null) {
                        if (!next.isEnabled()) {
                            next.setEnabled(true);
                        }
                        header1.setText(test_data.Title);
                        header2.setText(test_data.subTitle);
                        mainText.setText(test_data.TT);
                    }
                } else {
                    dataListIterator.next();
                    dataListIterator.next();
                    prev.setEnabled(false);
                    Toast.makeText(context, "No previous element", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.next: {
                if (dataListIterator.hasNext()) {
                    test_data = dataListIterator.next();
                    if (test_data.Title != null) {
                        if (!prev.isEnabled()) {
                            prev.setEnabled(true);
                        }
                        header1.setText(test_data.Title);
                        header2.setText(test_data.subTitle);
                        mainText.setText(test_data.TT);
                    }
                } else {
                    dataListIterator.previous();
                    dataListIterator.previous();
                    next.setEnabled(false);
                    Toast.makeText(context, "No next element", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private void autoSpeak(String text) {
        if (TextUtils.isEmpty(text) || tts == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, "SpeakText");
        } else {
            tts.speak(text, TextToSpeech.QUEUE_ADD, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (tts.isSpeaking()) {
            tts.stop();
        }
        super.onDestroy();

        tts.shutdown();
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.SUCCESS) {
            Log.d("InitTextToSpeech", "init text to speech failed; status: " + status);
            tts = null;
        }
    }

    @Override
    protected void onStop() {
        if (tts.isSpeaking()) {
            tts.stop();
        }
        super.onStop();
    }

    @Override
    protected void onStart() {

        tts = new TextToSpeech(DetailActivity.this, DetailActivity.this);

        super.onStart();
    }
}
