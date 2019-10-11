package com.firstapp.robinpc.tongue_twisters_deluxe.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.TwisterApp
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.AppComponent
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val LIGHT_STATUS_BAR = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setup()
    }

    abstract fun getLayoutResId(): Int

    abstract fun setup()

    @Suppress("SameParameterValue")
    @SuppressLint("ObsoleteSdkInt")
    protected fun setStatusBarColor(color: Int, shouldShowLightStatusBar: Boolean) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, color)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowLightStatusBar)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    protected fun animateActivityTransition(enterAnim: Int, exitAnim: Int) {
        overridePendingTransition(enterAnim, exitAnim)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    protected fun getAppComponent(): AppComponent {
        return TwisterApp.get(this).appComponent()
    }

    protected fun getDrawableForId(drawableId: Int): Drawable {
        ContextCompat.getDrawable(this, drawableId)?.let {
            return it
        } ?: run {
            return ColorDrawable(getColorForId(R.color.black))
        }
    }

    @Suppress("SameParameterValue")
    protected fun getColorForId(colorId: Int): Int {
        return ContextCompat.getColor(this, colorId)
    }
}