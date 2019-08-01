package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others

import android.content.Context
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.TwisterAppScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {

    @Provides
    @TwisterAppScope
    fun context(): Context {
        return context
    }
}