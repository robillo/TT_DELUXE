package com.firstapp.robinpc.tongue_twisters_deluxe.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;

public class AboutActivity extends AppCompatActivity {

    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setupActionBar();

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        Glide.with(this)
                .load("https://2.bp.blogspot.com/-uj-cptq9ELE/WITQa8VA1xI/AAAAAAAAADg/In0g-bhXoUscy1xR8PTjdueG8PjOTgi3gCLcB/s1600/IMG-20161006-WA0009.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .fitCenter()
                .into(imageView1);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
