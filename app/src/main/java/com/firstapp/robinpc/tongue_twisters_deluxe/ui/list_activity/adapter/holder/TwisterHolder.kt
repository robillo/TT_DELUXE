package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DIFFICULTY
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_LENGTH
import kotlinx.android.synthetic.main.cell_twister_level.view.*

class TwisterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var twisterClickListener: TwisterClickListener

    fun setTwister(twister: Twister, levelType: Int, position: Int) {
        inflateViews(twister, levelType, position)
        setClickListeners(twister)
    }

    private fun inflateViews(twister: Twister, levelType: Int, position: Int) {
        setTwisterTitle(twister.name, levelType)
        setTwisterType(twister.isLocked)
        setOutlineDecoration(levelType)
        setTwisterBackground(position)
    }

    private fun setTwisterBackground(position: Int) {
        if(position % 2 == 0)
            itemView.cellParent.setBackgroundColor(getColorForId(R.color.twister_cell_color_even))
        else
            itemView.cellParent.setBackgroundColor(getColorForId(R.color.twister_cell_color_odd))
    }

    private fun setOutlineDecoration(levelType: Int) {
        when(levelType) {
            TYPE_LENGTH -> setOutlinesBgColor(R.color.length_level_header_bg)
            TYPE_DIFFICULTY -> setOutlinesBgColor(R.color.difficulty_level_header_bg)
        }
    }

    private fun setOutlinesBgColor(bgColor: Int) {
        itemView.startOutlineIv.setBackgroundColor(getColorForId(bgColor))
        itemView.endOutlineIv.setBackgroundColor(getColorForId(bgColor))
    }

    private fun getColorForId(id: Int): Int {
        return ContextCompat.getColor(itemView.context, id)
    }

    private fun setTwisterTitle(twisterName: String, levelType: Int) {
        itemView.twisterNameTv.text = twisterName

        when(levelType) {
            TYPE_LENGTH -> itemView.twisterNameTv.setTextColor(
                    getColorForId(R.color.length_level_header_bg)
            )
            TYPE_DIFFICULTY -> itemView.twisterNameTv.setTextColor(
                    getColorForId(R.color.difficulty_level_header_bg)
            )
        }
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


    private fun setTwisterType(@Suppress("UNUSED_PARAMETER") istwisterLocked: Boolean) {
//        if(istwisterLocked)
//            setTwisterType(
//                    R.string.twister_type_paid,
//                    R.drawable.bg_paid_twister_type,
//                    R.color.free_twister_type
//            )
//        else
//            setTwisterType(
//                    R.string.twister_type_free,
//                    R.drawable.bg_free_twister_type,
//                    R.color.white
//            )
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    private fun setTwisterType(stringId: Int, drawableId: Int, textColor: Int) {
//        itemView.twisterTypeTv.text = getStringForId(stringId)
//        itemView.twisterTypeTv.setTextColor(getColorForId(textColor))
//        itemView.twisterTypeTv.setBackgroundResource(drawableId)
    }

    @Suppress("unused")
    private fun getStringForId(id: Int): String {
        return itemView.context.getString(id)
    }
}