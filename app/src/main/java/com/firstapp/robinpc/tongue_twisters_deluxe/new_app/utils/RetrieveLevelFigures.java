package com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.data.LevelFigures;

import java.util.ArrayList;
import java.util.List;

public class RetrieveLevelFigures {

    private Context context;

    private List<LevelFigures> levelFiguresList = new ArrayList<>();
    private String[] levelNumberHeaders, levelNames;
    private int[] levelImages;

    public RetrieveLevelFigures(Context context) {
        this.context = context;
        fetchLevelFigures();
        addLevelFiguresToList();
    }

    private void fetchLevelFigures() {
        fetchLevelImages();
        fetchLevelNumberHeaders();
        fetchLevelNames();
    }

    private void fetchLevelImages() {
        levelImages = new int[] {
                R.drawable.level_one,
                R.drawable.level_two,
                R.drawable.level_three,
                R.drawable.level_four,
                R.drawable.level_five,
                R.drawable.level_six,
                R.drawable.level_seven,
                R.drawable.level_eight,
                R.drawable.level_nine,
                R.drawable.level_ten
        };
    }

    private void fetchLevelNumberHeaders() {
        levelNumberHeaders = context.getResources().getStringArray(R.array.level_number_headers);
    }

    private void fetchLevelNames() {
        levelNames = context.getResources().getStringArray(R.array.level_names);
    }

    private void addLevelFiguresToList() {
        for(int i=0; i<levelImages.length; i++) {
            addLevelFigureToList(levelImages[i], levelNumberHeaders[i], levelNames[i]);
        }
    }

    public List<LevelFigures> getLevelFiguresList() {
        return levelFiguresList;
    }

    private void addLevelFigureToList(int levelDrawable, String levelNumberHeader, String levelName) {
        levelFiguresList.add(new LevelFigures(levelDrawable, levelNumberHeader, levelName));
    }
}
