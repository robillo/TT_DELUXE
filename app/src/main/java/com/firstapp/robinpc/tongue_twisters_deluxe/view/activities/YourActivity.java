package com.firstapp.robinpc.tongue_twisters_deluxe.view.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.adapters.Add_RV_Adapter;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.MyDBHelper;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.RecyclerviewTouchListener;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.Data;
import com.github.jorgecastilloprz.FABProgressCircle;

import java.util.List;
import java.util.ListIterator;

public class YourActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private static final String TAG = "ROBIN";
    private TextView mainText, header1, header2;
    private Context context;
    private TextToSpeech tts;
    private ListIterator<Data> dataListIterator;
    private Button prev, next;
    private Data test_data;
    FloatingActionButton fab;
    private LinearLayout layout_alternate;
    private ImageView layout_alternate2;
    private LinearLayout linearLayout2;
    private FABProgressCircle mFabProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyDBHelper myDBHelper = new MyDBHelper(this);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        header1 = (TextView) findViewById(R.id.header1);
        header2 = (TextView) findViewById(R.id.header2);
        mainText = (TextView) findViewById(R.id.mainText);
        mFabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
        context = getApplicationContext();

        linearLayout2 = (LinearLayout) findViewById(R.id.linear_layout2);
        layout_alternate2 = (ImageView) findViewById(R.id.layout_alternate2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layout_alternate= (LinearLayout) findViewById(R.id.layout_alternate);

        List<Data> data = myDBHelper.getAllTwisters();

        if(data !=null){
            dataListIterator = data.listIterator();
            if(dataListIterator.hasNext()){
                test_data = dataListIterator.next();

                header1.setText(test_data.Title);
                header2.setText(test_data.subTitle);
                mainText.setText(test_data.TT);
            }
        }

        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        registerForContextMenu(recyclerView);
        Add_RV_Adapter adapter = new Add_RV_Adapter(data, getApplicationContext());

        if(adapter.getItemCount()!=0){
            recyclerView.setVisibility(View.VISIBLE);
            layout_alternate.setVisibility(View.GONE);
            layout_alternate2.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this)
                .load("https://3.bp.blogspot.com/-V6twr9315Fo/WJBgEtsEGoI/AAAAAAAAAF0/cXpZ1Uc_4u0Zn-XAIisWwlc7oOXK6Nv-gCLcB/s1600/ph7.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(layout_alternate2);


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
                }
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_twister:{
                Intent i = new Intent(this, AddActivity.class);
                startActivity(i);
            }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_your, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_twister:{
                Intent i = new Intent(this, AddActivity.class);
                startActivity(i);
                break;
            }
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
            case android.R.id.home:{
                super.onBackPressed();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, LevelsActivity.class);
        i.putExtra("tab", 11);
        startActivity(i);
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
    protected void onStop() {
        if (tts.isSpeaking()) {
            tts.stop();
        }
        super.onStop();
    }

    @Override
    protected void onStart() {

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.SUCCESS) {
                    Log.d("InitTextToSpeech", "init text to speech failed; status: " + status);
                    tts = null;
                }
                else {
                    tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String s) {
                            if(s.equals("uttered")) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mFabProgressCircle.show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onDone(String s) {
                            if(s.equals("uttered")) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mFabProgressCircle.hide();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(String s) {

                        }
                    });
                }
            }
        });

        super.onStart();
    }

    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit_t:
                // do your stuff
                break;
            case R.id.delete_t:
                // do your stuff
                break;
        }
        return super.onContextItemSelected(item);
    }*/
}
