package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.adapter.holder.TwisterHolder

class TwisterListAdaper(private val twisterList: List<Twister>):
        RecyclerView.Adapter<TwisterHolder>(),
        TwisterHolder.TwisterClickListener {

    private lateinit var twisterClickListener: TwisterClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwisterHolder {
        return TwisterHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.cell_twister, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return twisterList.size
    }

    override fun onBindViewHolder(holder: TwisterHolder, position: Int) {
        holder.setTwister(twisterList[position])
        holder.setTwisterClickListener(this)
    }

    override fun onTwisterClicked(twister: Twister) {
        twisterClickListener.onTwisterClicked(twister)
    }

    fun setTwisterClickListener(twisterClickListener: TwisterClickListener) {
        this.twisterClickListener = twisterClickListener
    }

    interface TwisterClickListener {
        fun onTwisterClicked(twister: Twister)
    }
}