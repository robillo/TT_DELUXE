package com.firstapp.robinpc.tongue_twisters_deluxe.di.component

import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.DatabaseModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.JsonModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.SharedPreferenceModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.UtilsModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.TwisterAppScope
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.TwisterPreferences
import com.google.gson.Gson

import dagger.Component
import java.io.InputStream

@TwisterAppScope
@Component(modules = [ SharedPreferenceModule::class, UtilsModule::class , DatabaseModule::class, JsonModule::class ])
interface TwisterAppComponent {

    fun getGson(): Gson
    fun getInputStream(): InputStream
    fun twisterPreferences(): TwisterPreferences
    fun getDatabase(): TwisterDatabase

}
