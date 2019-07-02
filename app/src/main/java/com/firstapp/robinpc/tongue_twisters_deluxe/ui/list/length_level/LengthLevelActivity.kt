package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.length_level

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.adapter.TwisterListAdaper
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import kotlinx.android.synthetic.main.activity_length_level.twisterRecycler

class LengthLevelActivity : BaseActivity(), TwisterListAdaper.TwisterClickListener {

    private lateinit var twisterList: MutableList<Twister>

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LengthLevelActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_length_level
    }

    override fun setup() {
        setStatusBarColor(R.color.black, false)
        loadData()
        setTwisterAdapter()
    }

    private fun loadData() {
        loadTwisterList()
    }

    private fun loadTwisterList() {
        twisterList = ArrayList()
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
    }

    private fun setTwisterAdapter() {
        twisterRecycler.layoutManager = LinearLayoutManager(this)
        val adapter = TwisterListAdaper(twisterList)
        adapter.setTwisterClickListener(this)
        twisterRecycler.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateActivityTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun onTwisterClicked(twister: Twister) {
        startReadingActivity()
    }

    private fun startReadingActivity() {
        startActivity(ReadingActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }
}
