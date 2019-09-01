package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import kotlinx.android.synthetic.main.cell_stateful_difficulty_level.view.*

class DifficultyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var difficultyClickListener: DifficultyLevelClickListener

    fun setDifficultyLevel(difficultyLevel: DifficultyLevel) {
        inflateViews(difficultyLevel)
    }

    private fun inflateViews(difficultyLevel: DifficultyLevel) {
        itemView.levelNameTv.text = difficultyLevel.title

        itemView.setOnClickListener {
            difficultyClickListener.difficultyClicked(difficultyLevel)
        }
    }

    interface DifficultyLevelClickListener {
        fun difficultyClicked(difficultyLevel: DifficultyLevel)
    }

    fun setDifficultyClickListener(difficultyClickListener: DifficultyLevelClickListener) {
        this.difficultyClickListener = difficultyClickListener
    }
}