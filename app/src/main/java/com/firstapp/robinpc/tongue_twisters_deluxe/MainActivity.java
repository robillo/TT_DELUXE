package com.firstapp.robinpc.tongue_twisters_deluxe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Master this app, Master your pronunciation skills!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id ==  R.id.action_settings)
        {
            Intent i=new Intent(this,ABOUT.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){

        Intent i= new Intent();

        switch (v.getId()){
            case R.id.level1:
            {
                i= new Intent(this, LEVEL1.class);
                break;
            }
            case R.id.level2:
            {
                i= new Intent(this, LEVEL2.class);
                break;
            }
            case R.id.level3:
            {
                i= new Intent(this, LEVEL3.class);
                break;
            }
            case R.id.level4:
            {
                i= new Intent(this, LEVEL4.class);
                break;
            }
            case R.id.level5:
            {
                i= new Intent(this, LEVEL5.class);
                break;
            }
            case R.id.level6:
            {
                i= new Intent(this, LEVEL6.class);
                break;
            }
            case R.id.level7:
            {
                i= new Intent(this, LEVEL7.class);
                break;
            }
            case R.id.level8:
            {
                i= new Intent(this, LEVEL8.class);
                break;
            }
            case R.id.level9:
            {
                i= new Intent(this, LEVEL9.class);
                break;
            }
            case R.id.level10:
            {
                i= new Intent(this, LEVEL10.class);
                break;
            }
        }
        startActivity(i);
    }


}
