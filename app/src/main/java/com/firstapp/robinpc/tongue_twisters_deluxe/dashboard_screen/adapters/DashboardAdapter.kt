package com.firstapp.robinpc.tongue_twisters_deluxe.dashboard_screen.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.LevelFigures
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorsList
import com.firstapp.robinpc.tongue_twisters_deluxe.level_screen.LevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.IntentExtras
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.RetrieveLevelFigures

internal class DashboardAdapter(
        private val context: Context,
        private val list: List<LevelFigures>?,
        private val themeColors: ThemeColorsList
        ) : RecyclerView.Adapter<DashboardAdapter.DashboardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardHolder {
        return DashboardHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.row_dashboard_plain, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DashboardHolder, position: Int) {
        if (list!![position].levelDrawable == RetrieveLevelFigures.NULL_EQUIVALENT_DRAWABLE_ID) {
            holder.itemView.visibility = View.INVISIBLE
            holder.levelImageView.visibility = View.GONE
            holder.itemView.isClickable = false
        } else {
            holder.levelNameTextView.text = list[position].levelName
            holder.levelHeaderTextView.text = list[position].levelNumberHeader
            Glide.with(context).load(list[position].levelDrawable)
                    .into(holder.levelImageView)
        }

        holder.levelLine.setBackgroundColor(themeColors.lightIntensity5)
        holder.levelHeaderTextView.setTextColor(themeColors.lightIntensity1)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, LevelActivity::class.java)
            intent.putExtra(IntentExtras.EXTRA_LEVEL_NUMBER, list.get(position).levelNumberHeader)
            context.startActivity(intent)
            (context as Activity)
                    .overridePendingTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    internal inner class DashboardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var levelImageView: ImageView = itemView.findViewById(R.id.level_image)
        var levelHeaderTextView: TextView = itemView.findViewById(R.id.level_number)
        var levelNameTextView: TextView = itemView.findViewById(R.id.level_name)
        var levelLine: ImageView = itemView.findViewById(R.id.level_line)

    }
}
