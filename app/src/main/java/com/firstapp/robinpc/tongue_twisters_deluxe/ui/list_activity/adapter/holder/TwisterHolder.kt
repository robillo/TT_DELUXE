package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import kotlinx.android.synthetic.main.cell_twister.view.*

class TwisterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var twisterClickListener: TwisterClickListener

    fun setTwister(twister: Twister) {
        inflateViews(twister)
        setClickListeners(twister)
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
    }

    private fun setClickListeners(twister: Twister) {
        itemView.setOnClickListener {
            if(!::twisterClickListener.isInitialized) return@setOnClickListener

            if(twister.isLocked)
                twisterClickListener.onLockedTwisterClicked(twister)
            else
                twisterClickListener.onUnlockedTwisterClicked(twister)
        }
    }

    fun setTwisterClickListener(twisterClickListener: TwisterClickListener) {
        this.twisterClickListener = twisterClickListener
    }

    interface TwisterClickListener {
        fun onLockedTwisterClicked(twister: Twister)
        fun onUnlockedTwisterClicked(twister: Twister)
    }
}