package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.holders.LengthHolder

class LengthAdapter(private val lengthList:
                    List<LengthLevel>): RecyclerView.Adapter<LengthHolder>(),
                    LengthHolder.LengthLevelClickListener {

    private lateinit var lengthLevelClickListener: LengthLevelClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LengthHolder {
        return LengthHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.cell_twister_by_length, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lengthList.size
    }

    override fun onBindViewHolder(holder: LengthHolder, position: Int) {
        holder.setLengthLevel(lengthList[position])
        holder.setLengthLevelClickListener(this)
    }

    override fun lengthLevelClicked(lengthLevel: LengthLevel) {
        lengthLevelClickListener.lengthLevelClicked(lengthLevel)
    }

    interface LengthLevelClickListener {
        fun lengthLevelClicked(lengthLevel: LengthLevel)
    }

    fun setLengthLevelClickListener(lengthLevelClickListener: LengthLevelClickListener) {
        this.lengthLevelClickListener = lengthLevelClickListener
    }
}