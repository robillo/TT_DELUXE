package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home

import android.content.Context
import android.content.Intent
import android.view.View
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : BaseActivity() {

    companion object {
        const val DELAY_TWISTER_OF_THE_DAY_LOADING = 1000L
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBarColor(R.color.white)
        loadTwisterOfTheDay()
        setScrollListener()
    }

    private fun setScrollListener() {
        scrollView?.let {

            it.viewTreeObserver.addOnScrollChangedListener {
                if (!scrollView.canScrollVertically(1)) {
                    // Bottom of scroll view.
                    homeHeaderTv.visibility = View.GONE
                    goPremiumLayout.visibility = View.GONE
                }
                else if (!scrollView.canScrollVertically(-1)) {
                    // Top of scroll view.
                    goPremiumLayout.visibility = View.VISIBLE
                    homeHeaderTv.visibility = View.VISIBLE
                }
                else {
                    goPremiumLayout.visibility = View.GONE
                    homeHeaderTv.visibility = View.GONE
                }
            }
        }
    }

    private fun loadTwisterOfTheDay() {
        //TODO: do in actual later
        Timer().schedule(object: TimerTask() {
            override fun run() {
                runOnUiThread {
                    showTwisterOfTheDay()
                }
            }
        }, DELAY_TWISTER_OF_THE_DAY_LOADING)
    }

    private fun showTwisterOfTheDay() {
        loadingTwisterOfDayProgress.visibility = View.GONE
        twisterOfTheDayLayoutMain.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        val goHome = Intent(Intent.ACTION_MAIN)
        goHome.addCategory(Intent.CATEGORY_HOME)
        goHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(goHome)
    }
}