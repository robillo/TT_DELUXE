package com.firstapp.robinpc.tongue_twisters_deluxe.about_screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppConstants
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setup()
    }

    private fun setup() {
        setStatusBarColor()
        loadProfilePictures()
        setClickListeners()
    }

    private fun setClickListeners() {
        go_back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryIntensity3)
    }

    @SuppressLint("CheckResult")
    private fun loadProfilePictures() {
        val options = RequestOptions()
        options.centerCrop()
        Glide.with(this).load(AppConstants.URL_AMIT_CONTENT_CREATOR_PROFILE)
                .apply(options).into(amit_image)
        Glide.with(this).load(AppConstants.URL_ANUBHAV_CONTENT_CREATOR_PROFILE)
                .apply(options).into(anubhav_image)
        Glide.with(this).load(AppConstants.URL_ROBIN_DEVELOPER_PROFILE)
                .apply(options).into(robin_image)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
