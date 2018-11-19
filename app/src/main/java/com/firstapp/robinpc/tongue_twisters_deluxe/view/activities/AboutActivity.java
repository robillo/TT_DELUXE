package com.firstapp.robinpc.tongue_twisters_deluxe.view.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AboutActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setupActionBar();

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        Glide.with(this)
                .load("https://2.bp.blogspot.com/-uj-cptq9ELE/WITQa8VA1xI/AAAAAAAAADg/In0g-bhXoUscy1xR8PTjdueG8PjOTgi3gCLcB/s1600/IMG-20161006-WA0009.jpg")
                .into(imageView1);
        Glide.with(this)
                .load("https://3.bp.blogspot.com/-YjGwQN3cJqQ/WJA0np9XwBI/AAAAAAAAAEo/V5n452vyVVsTTLEh-6jluIhO5mgWhwEOwCLcB/s1600/1485676792605a.jpg")
                .into(imageView2);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
