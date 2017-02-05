package com.firstapp.robinpc.tongue_twisters_deluxe.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;

public class AddActivity extends AppCompatActivity {

    Button add;
    private MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add = (Button)  findViewById(R.id.add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.edit_twister:{
                Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.delete_twister:{
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
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


    public void onClick(View v){
        switch (v.getId()){
            case R.id.add:{
                //Do something
                Toast.makeText(getApplicationContext(), "Add Twister Pressed", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
