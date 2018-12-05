package com.firstapp.robinpc.tongue_twisters_deluxe.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppConstants.PREFERENCE_FILE_NAME;
import static com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppConstants.PREFERENCE_IS_AUTO_PLAY_ON;
import static com.firstapp.robinpc.tongue_twisters_deluxe.utils.AppConstants.PREFERENCE_THEME_NAME;

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

    public String getThemeName() { return prefs.getString(PREFERENCE_THEME_NAME, ThemeColorsUtils.FRESH_GREEN); }

    public void setThemeName(String themeName) {
        prefs.edit().putString(PREFERENCE_THEME_NAME, themeName).apply();
    }

}
