package com.firstapp.robinpc.tongue_twisters_deluxe

import android.app.Activity
import android.app.Application
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.DaggerAppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.AppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.ContextModule

import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class TwisterApp : Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/WS-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build())

        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun appComponent(): AppComponent {
        return component
    }

    companion object {
        fun get(activity: Activity): TwisterApp {
            return activity.application as TwisterApp
        }
    }
}
