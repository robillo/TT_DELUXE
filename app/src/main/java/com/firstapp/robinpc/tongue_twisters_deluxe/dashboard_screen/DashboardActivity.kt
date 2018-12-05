package com.firstapp.robinpc.tongue_twisters_deluxe.dashboard_screen

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.WindowManager
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.dashboard_screen.adapters.DashboardAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.data.LevelFigures
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorsList
import com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen.SettingsActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppPreferencesHelper
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.RetrieveLevelFigures
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.ThemeColorsUtils
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var themeColors: ThemeColorsList
    private var levelFiguresList: List<LevelFigures>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setup()
    }

    private fun setup() {
        setColorsForCurrentTheme()
        setStatusBarColor()
        setRecyclerView()
        setClickListeners()
    }

    private fun setRecyclerView() {
        inflateLevelFiguresList()
        recycler_view.adapter = DashboardAdapter(this, levelFiguresList, themeColors)
    }


    private fun setClickListeners() {
        settings_button.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
        }
    }

    private fun inflateLevelFiguresList() {
        levelFiguresList = RetrieveLevelFigures(this).getLevelFiguresList()
    }

    private fun setStatusBarColor() {
        val statusBarColor = themeColors.lightIntensity1
        var flags = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = statusBarColor
        setWindowFlags(flags)
    }

    private fun setWindowFlags(flags: Int) {
        window.decorView.systemUiVisibility = flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    }

    private fun setColorsForCurrentTheme() {
        themeColors = ThemeColorsUtils(this).getThemeColorsForThemeName(
                AppPreferencesHelper(this).themeName
        )
        val backgroundColor = themeColors.lightIntensity1
        color_linear_layout.setBackgroundColor(backgroundColor)
        color_line.setBackgroundColor(backgroundColor)
        color_difficulty_level.setBackgroundColor(backgroundColor)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
