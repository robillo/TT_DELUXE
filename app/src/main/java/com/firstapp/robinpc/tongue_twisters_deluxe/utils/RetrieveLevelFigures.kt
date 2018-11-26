package com.firstapp.robinpc.tongue_twisters_deluxe.utils

import android.content.Context

import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.LevelFigures

import java.util.ArrayList

class RetrieveLevelFigures(private val context: Context) {

    private val levelFiguresList = ArrayList<LevelFigures>()
    private var levelNumberHeaders: Array<String>? = null
    private var levelNames: Array<String>? = null
    private var levelImages: IntArray? = null

    init {
        fetchLevelFigures()
        addLevelFiguresToList()
    }

    private fun fetchLevelFigures() {
        fetchLevelImages()
        fetchLevelNumberHeaders()
        fetchLevelNames()
    }

    private fun fetchLevelImages() {
        levelImages = intArrayOf(NULL_EQUIVALENT_DRAWABLE_ID, R.drawable.level_one, R.drawable.level_two, R.drawable.level_three, R.drawable.level_four, R.drawable.level_five, R.drawable.level_six, R.drawable.level_seven, R.drawable.level_eight, R.drawable.level_nine, R.drawable.level_ten)
    }

    private fun fetchLevelNumberHeaders() {
        levelNumberHeaders = context.resources.getStringArray(R.array.level_number_headers)
    }

    private fun fetchLevelNames() {
        levelNames = context.resources.getStringArray(R.array.level_names)
    }

    private fun addLevelFiguresToList() {
        for (i in levelImages!!.indices) {
            addLevelFigureToList(levelImages!![i], levelNumberHeaders!![i], levelNames!![i])
        }
    }

    fun getLevelFiguresList(): List<LevelFigures> {
        return levelFiguresList
    }

    private fun addLevelFigureToList(levelDrawable: Int, levelNumberHeader: String, levelName: String) {
        levelFiguresList.add(LevelFigures(levelDrawable, levelNumberHeader, levelName))
    }

    companion object {
        const val NULL_EQUIVALENT_DRAWABLE_ID = -1
    }
}
