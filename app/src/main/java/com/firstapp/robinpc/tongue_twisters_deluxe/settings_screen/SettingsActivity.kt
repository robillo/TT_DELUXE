package com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorItem
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorsList
import com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen.adapters.ThemeColorAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppPreferencesHelper
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.ThemeColorsUtils
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_settings.*
import android.content.Intent
import android.net.Uri


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
        rate_app_five_stars.setOnClickListener {
            try {
                startActivity(
                        Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=".plus(packageName))
                        )
                )
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(
                        Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=".plus(packageName))
                        )
                )
            }
        }
    }

    private fun setColorsForCurrentTheme() {
        themeColors = ThemeColorsUtils(this).getThemeColorsForThemeName(
                AppPreferencesHelper(this).themeName
        )

        color_linear_layout.setBackgroundColor(themeColors.lightIntensity1)
        color_line.setBackgroundColor(themeColors.lightIntensity1)
        line_dark_color.setBackgroundColor(themeColors.darkIntensity2)

        setStatusBarColor()
    }

    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = themeColors.darkIntensity1
    }

    private fun instantiateThemeColors() {
        themeColorItems = ThemeColorsUtils().themeColorItems
    }

    private fun setRecyclerAdapter() {
        recycler_theme_colors.adapter = ThemeColorAdapter(this, themeColorItems, ThemeChangeListener {
            AppPreferencesHelper(this).themeName = it
            setColorsForCurrentTheme()
            showSnackBar(getString(R.string.theme_set).plus(" ").plus(it.toLowerCase()))
        })
    }

    private fun showSnackBar(text: String) {
        val snackbar = Snackbar.make(coordinator, text, 2000)
        val view = snackbar.view
        view.setBackgroundColor(themeColors.lightIntensity1)
        val textView = view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
        snackbar.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
