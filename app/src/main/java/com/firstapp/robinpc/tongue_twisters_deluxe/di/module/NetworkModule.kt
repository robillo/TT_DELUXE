package com.firstapp.robinpc.tongue_twisters_deluxe.di.module

import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.TwisterAppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    @TwisterAppScope
    fun gson(): Gson {
        return Gson()
    }
}