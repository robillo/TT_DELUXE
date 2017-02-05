package com.firstapp.robinpc.tongue_twisters_deluxe.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.Recycler_View_Adapter;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.Data;

import java.util.ArrayList;
import java.util.List;

public class YourActivity extends AppCompatActivity {

    ImageView imageView3;
    private MyDBHelper myDBHelper;
    private RecyclerView recyclerView;
    private static final String TAG = "ROBIN";
    List<Data> data;
    LinearLayout layout_alternate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDBHelper = new MyDBHelper(this);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layout_alternate= (LinearLayout) findViewById(R.id.layout_alternate);

        data = myDBHelper.getAllTwisters();

        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        registerForContextMenu(recyclerView);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());

        if(adapter.getItemCount()!=0){
            layout_alternate.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Glide.with(this)
                .load("https://3.bp.blogspot.com/-V6twr9315Fo/WJBgEtsEGoI/AAAAAAAAAF0/cXpZ1Uc_4u0Zn-XAIisWwlc7oOXK6Nv-gCLcB/s1600/ph7.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView3);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_twister:{
                Intent i = new Intent(this, AddActivity.class);
                startActivity(i);
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
                onBackPressed();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
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
