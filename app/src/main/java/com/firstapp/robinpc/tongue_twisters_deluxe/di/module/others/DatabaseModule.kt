package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others

import android.content.Context
import androidx.room.Room
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.TwisterAppScope
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.APP_DATABASE
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Provides
    @TwisterAppScope
    fun appDatabase(context: Context): TwisterDatabase {
        return Room.databaseBuilder(context, TwisterDatabase::class.java, APP_DATABASE).build()
    }
}