package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.holders.DifficultyHolder

class DifficultyAdapter(private val difficultyLevelList: List<DifficultyLevel>):
        RecyclerView.Adapter<DifficultyHolder>(),
        DifficultyHolder.DifficultyLevelClickListener {

    private lateinit var difficultyClickListener: DifficultyLevelClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DifficultyHolder {
        return DifficultyHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.cell_twister_by_difficulty, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return difficultyLevelList.size
    }

    override fun onBindViewHolder(holder: DifficultyHolder, position: Int) {
        holder.setDifficultyLevel(difficultyLevelList[position])
        holder.setDifficultyClickListener(this)
    }

    override fun difficultyClicked(difficultyLevel: DifficultyLevel) {
        difficultyClickListener.difficultyClicked(difficultyLevel)
    }

    interface DifficultyLevelClickListener {
        fun difficultyClicked(difficultyLevel: DifficultyLevel)
    }

    fun setDifficultyClickListener(difficultyClickListener: DifficultyLevelClickListener) {
        this.difficultyClickListener = difficultyClickListener
    }
}