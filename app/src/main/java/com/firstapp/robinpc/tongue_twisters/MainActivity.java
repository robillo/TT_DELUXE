package com.firstapp.robinpc.tongue_twisters;

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
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent i=new Intent(this,ABOUT.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void firstlevel(View view)
    {
        Intent i=new Intent(this,LEVEL1.class);
        startActivity(i);
    }
    public void secondlevel(View view)
    {
        Intent i=new Intent(this,LEVEL2.class);
        startActivity(i);
    }
    public void thirdlevel(View view)
    {
        Intent i=new Intent(this,LEVEL3.class);
        startActivity(i);
    }
    public void fourthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL4.class);
        startActivity(i);
    }
    public void fifthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL5.class);
        startActivity(i);
    }
    public void sixthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL6.class);
        startActivity(i);
    }
    public void seventhlevel(View view)
    {
        Intent i=new Intent(this,LEVEL7.class);
        startActivity(i);
    }
    public void eighthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL8.class);
        startActivity(i);
    }
    public void ninthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL9.class);
        startActivity(i);
    }
    public void tenthlevel(View view)
    {
        Intent i=new Intent(this,LEVEL10.class);
        startActivity(i);
    }
}
