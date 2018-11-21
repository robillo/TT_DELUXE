package com.firstapp.robinpc.tongue_twisters_deluxe.new_app.dashboard_screen

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.WindowManager
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.dashboard_screen.adapters.DashboardAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.data.LevelFigures
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils.RetrieveLevelFigures
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var levelFiguresList: List<LevelFigures>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setup()
    }

    private fun setup() {
        setStatusBarColor()
        setRecyclerView()
    }

    private fun setStatusBarColor() {
        var flags = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryIntensity3)
        setWindowFlags(flags)
    }

    private fun setWindowFlags(flags: Int) {
        window.decorView.systemUiVisibility = flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    }

    private fun setRecyclerView() {
        inflateLevelFiguresList()
        recycler_view.adapter = DashboardAdapter(this, levelFiguresList)
    }

    private fun inflateLevelFiguresList() {
        levelFiguresList = RetrieveLevelFigures(this).getLevelFiguresList()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
