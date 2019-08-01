package com.firstapp.robinpc.tongue_twisters_deluxe.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.annotation.WorkerThread
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_FLOAT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_INT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_LONG
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_STRING
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.EXTRA_PREFERENCES_TWISTER
import com.google.gson.Gson

@Suppress("unused", "RedundantSuspendModifier", "MemberVisibilityCanBePrivate")
class TwisterPreferences(context: Context, private val gson: Gson) {

    private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun getBoolean(key: String, value: Boolean): Boolean {
        return preferences.getBoolean(key, value)
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun getFloat(key: String, value: Float): Float {
        return preferences.getFloat(key, value)
    }

    fun getFloat(key: String): Float {
        return getFloat(key, DEFAULT_VALUE_FLOAT)
    }

    fun getInt(key: String, value: Int): Int {
        return preferences.getInt(key, value)
    }

    fun getInt(key: String): Int {
        return getInt(key, DEFAULT_VALUE_INT)
    }

    fun getLong(key: String, value: Long): Long {
        return preferences.getLong(key, value)
    }

    fun getLong(key: String): Long {
        return getLong(key, DEFAULT_VALUE_LONG)
    }

    fun getString(key: String, default: String): String {
        return preferences.getString(key, default)!!
    }

    fun getString(key: String): String {
        return getString(key, DEFAULT_VALUE_STRING)
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun putFloat(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }

    fun putInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun putLong(key: String, value: Long) {
        editor.putLong(key, value)
        editor.apply()
    }

    @WorkerThread
    suspend fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun toggle(key: String) {
        setEnabled(key, !isEnabled(key))
    }

    fun isEnabled(key: String): Boolean {
        return getBoolean(key)
    }

    fun setEnabled(preferenceKey: String, b: Boolean) {
        editor.putBoolean(preferenceKey, b).apply()
    }

    @WorkerThread
    suspend fun getTwister(): Twister {
        return gson.fromJson(getString(EXTRA_PREFERENCES_TWISTER), Twister::class.java)
    }

    fun clearAll() {
        editor.clear().commit()
    }

    fun clear(key: String) {
        editor.remove(key).apply()
    }
}