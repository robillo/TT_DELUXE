package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import kotlinx.android.synthetic.main.cell_twister_by_length.view.*

class LengthHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun setLengthLevel(lengthLevel: LengthLevel) {
        inflateViews(lengthLevel)
    }

    fun inflateViews(lengthLevel: LengthLevel) {
        itemView.levelHeaderTv.text = lengthLevel.title

        itemView.levelTwistersCountTv.text =
                (lengthLevel.endIndex - lengthLevel.startIndex + 1)
                        .toString().plus("+ Twisters")
    }
}