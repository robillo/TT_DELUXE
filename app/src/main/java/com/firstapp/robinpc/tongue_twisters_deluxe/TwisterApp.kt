package com.firstapp.robinpc.tongue_twisters_deluxe

import android.app.Activity
import android.app.Application
import android.app.Service
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.DaggerAppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.AppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.ContextModule
import com.google.android.gms.ads.MobileAds

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

        initialiseAds()
    }

    private fun initialiseAds() {
        MobileAds.initialize(this) {

        }
    }

    fun appComponent(): AppComponent {
        return component
    }

    companion object {
        fun get(activity: Activity): TwisterApp {
            return activity.application as TwisterApp
        }
        fun get(service: Service): TwisterApp {
            return service.application as TwisterApp
        }
    }
}
