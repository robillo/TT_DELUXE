package com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorItem
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorsList
import com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen.adapters.ThemeColorAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppPreferencesHelper
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.ThemeColorsUtils
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private lateinit var themeColors: ThemeColorsList
    lateinit var themeColorItems: MutableList<ThemeColorItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setup()
    }

    private fun setup() {
        setColorsForCurrentTheme()
        setStatusBarColor()
        setClickListeners()
        instantiateThemeColors()
        setRecyclerAdapter()
    }

    private fun setClickListeners() {
        go_back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setColorsForCurrentTheme() {
        themeColors = ThemeColorsUtils(this).getThemeColorsForThemeName(
                AppPreferencesHelper(this).themeName
        )

        color_linear_layout.setBackgroundColor(themeColors.lightIntensity1)
        color_line.setBackgroundColor(themeColors.lightIntensity1)

        setStatusBarColor()
    }

    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = themeColors.lightIntensity1
    }

    private fun instantiateThemeColors() {
        themeColorItems = ThemeColorsUtils().themeColorItems
    }

    private fun setRecyclerAdapter() {
        recycler_theme_colors.adapter = ThemeColorAdapter(this, themeColorItems, ThemeChangeListener {
            AppPreferencesHelper(this).themeName = it
            setColorsForCurrentTheme()
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
