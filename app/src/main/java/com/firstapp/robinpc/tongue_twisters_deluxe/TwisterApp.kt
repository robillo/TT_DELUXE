package com.firstapp.robinpc.tongue_twisters_deluxe

import android.app.Activity
import android.app.Application
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.DaggerTwisterAppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.TwisterAppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.ContextModule

import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class TwisterApp : Application() {

    private lateinit var component: TwisterAppComponent

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/WS-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build())

        component = DaggerTwisterAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun constitutionAppComponent(): TwisterAppComponent {
        return component
    }

    companion object {
        fun get(activity: Activity): TwisterApp {
            return activity.application as TwisterApp
        }
    }
}
