package com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setup()
    }

    private fun setup() {
        setStatusBarColor()
    }

    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryIntensity3)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
