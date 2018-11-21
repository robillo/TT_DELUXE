package com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;

import static com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils.AppConstants.PREFERENCE_FILE_NAME;
import static com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils.AppConstants.PREFERENCE_IS_AUTO_PLAY_ON;

public class AppPreferencesHelper {

    private SharedPreferences prefs;

    public AppPreferencesHelper(Context context) {
        prefs = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }

    public boolean isAutoPlayOn() {
        return prefs.getBoolean(PREFERENCE_IS_AUTO_PLAY_ON, true);
    }

    public void setIsAutoPlayOn(boolean isAutoPlayOn) {
        prefs.edit().putBoolean(PREFERENCE_IS_AUTO_PLAY_ON, isAutoPlayOn).apply();
    }

}
