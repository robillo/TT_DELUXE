package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others

import android.content.Context
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.NetworkModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.TwisterAppScope
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.TwisterPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class, NetworkModule::class])
class SharedPreferenceModule {

    @Provides
    @TwisterAppScope
    fun sharedPreferenceUtil(context: Context, gson: Gson): TwisterPreferences {
        return TwisterPreferences(context, gson)
    }

}