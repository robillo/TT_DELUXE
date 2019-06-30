package com.firstapp.robinpc.tongue_twisters_deluxe.ui.difficulty_level

import android.content.Context
import android.content.Intent
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.length_level.LengthLevelActivity

class DifficultyLevelActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LengthLevelActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_difficulty_level
    }

    override fun setup() {
        setStatusBarColor(R.color.white)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateActivityTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }
}
