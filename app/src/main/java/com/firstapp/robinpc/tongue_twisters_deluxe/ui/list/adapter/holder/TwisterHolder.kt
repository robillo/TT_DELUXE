package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import kotlinx.android.synthetic.main.cell_twister.view.*

class TwisterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var twisterClickListener: TwisterClickListener

    fun setTwister(twister: Twister) {
        inflateViews(twister)
    }

    private fun inflateViews(twister: Twister) {

        if(twister.isLocked) {
            itemView.unlockedIconIv.visibility = View.GONE
            itemView.openTwisterLayout.visibility = View.VISIBLE
        }
        else {
            itemView.unlockedIconIv.visibility = View.VISIBLE
            itemView.openTwisterLayout.visibility = View.GONE
        }

        itemView.twisterNameTv.text = twister.name

        itemView.setOnClickListener {
            twisterClickListener.onTwisterClicked(twister)
        }
    }

    fun setTwisterClickListener(twisterClickListener: TwisterClickListener) {
        this.twisterClickListener = twisterClickListener
    }

    interface TwisterClickListener {
        fun onTwisterClicked(twister: Twister)
    }
}