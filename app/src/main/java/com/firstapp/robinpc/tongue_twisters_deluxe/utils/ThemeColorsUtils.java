package com.firstapp.robinpc.tongue_twisters_deluxe.utils;

import android.content.Context;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorItem;
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorsList;

import java.util.ArrayList;
import java.util.List;

public class ThemeColorsUtils {

    private Context context;
    private List<ThemeColorItem> themeColorItems = new ArrayList<>();

    public ThemeColorsUtils() {}

    public ThemeColorsUtils(Context context) {
        this.context = context;
    }

    public static final String CHEERFUL_BLUE = "BLUE";
    public static final String FIERCE_RED = "RED";
    public static final String HAPPY_YELLOW = "YELLOW";
    public static final String FRESH_GREEN = "GREEN";
    public static final String PITCH_BLACK = "BLACK";
    public static final String GIRL_PINK = "PINK";

    public List<ThemeColorItem> getThemeColorItems() {
        themeColorItems.add(new ThemeColorItem(R.color.cheerfulBlueLight1, CHEERFUL_BLUE));
        themeColorItems.add(new ThemeColorItem(R.color.fierceRedLight1, FIERCE_RED));
        themeColorItems.add(new ThemeColorItem(R.color.fierceRedDark1, HAPPY_YELLOW));
        themeColorItems.add(new ThemeColorItem(R.color.fierceRedLight1, FRESH_GREEN));
        themeColorItems.add(new ThemeColorItem(R.color.fierceRedDark1, PITCH_BLACK));
        themeColorItems.add(new ThemeColorItem(R.color.fierceRedLight1, GIRL_PINK));
        return themeColorItems;
    }

    public ThemeColorsList getThemeColorsForThemeName(String themeName) {
        ThemeColorsList requiredTheme;
        switch (themeName) {
            case CHEERFUL_BLUE:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.cheerful_blue));
                break;
            case FIERCE_RED:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.fierce_red));
                break;
            case HAPPY_YELLOW:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.happy_yellow));
                break;
            case FRESH_GREEN:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.fresh_green));
                break;
            case PITCH_BLACK:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.pitch_black));
                break;
            case GIRL_PINK:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.girl_pink));
                break;
            default:
                requiredTheme = new ThemeColorsList(context.getResources().getIntArray(R.array.cheerful_blue));
        }
        return requiredTheme;
    }
}
