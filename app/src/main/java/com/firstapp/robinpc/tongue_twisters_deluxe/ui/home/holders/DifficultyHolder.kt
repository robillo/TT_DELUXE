package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import kotlinx.android.synthetic.main.cell_twister_by_difficulty.view.*

class DifficultyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var difficultyClickListener: DifficultyLevelClickListener

    private var numTotalLevelTwisters: Int = 0
    private var numReadLevelTwisters: Int = 0

    fun setDifficultyLevel(difficultyLevel: DifficultyLevel) {
        computeValuesFromGivenData(difficultyLevel)
        inflateViews(difficultyLevel)
    }

    private fun inflateViews(difficultyLevel: DifficultyLevel) {
        itemView.levelHeaderTv.text = difficultyLevel.title
        itemView.levelNameTv.text = difficultyLevel.expandedTitle
        itemView.levelTwistersCountTv.text = numTotalLevelTwisters.toString().plus(itemView.resources.getString(R.string.twisters))
        itemView.levelProgressBar.progress = numReadLevelTwisters * 100 / numTotalLevelTwisters
        itemView.ratioReadToTotalTv.text = numReadLevelTwisters.toString().plus("/").plus(numTotalLevelTwisters)

        itemView.setOnClickListener {
            difficultyClickListener.difficultyClicked(difficultyLevel)
        }
    }

    private fun computeValuesFromGivenData(difficultyLevel: DifficultyLevel) {
        numTotalLevelTwisters = difficultyLevel.endIndex - difficultyLevel.startIndex + 1
        numReadLevelTwisters = getNumReadTwisters()
    }

    private fun getNumReadTwisters(): Int {
        //TODO: fetch from room db later
        return 20
    }

    interface DifficultyLevelClickListener {
        fun difficultyClicked(difficultyLevel: DifficultyLevel)
    }

    fun setDifficultyClickListener(difficultyClickListener: DifficultyLevelClickListener) {
        this.difficultyClickListener = difficultyClickListener
    }
}