package com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash

import android.os.CountDownTimer
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    companion object {
        private const val STEP_VALUE = 200L
        private const val TIMER_VALUE = 1000L
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun setup() {
        setStatusBarColor(R.color.white, true)
        startTimer()
    }

    private fun startTimer() {
        val timer = object: CountDownTimer(TIMER_VALUE, STEP_VALUE) {
            override fun onFinish() {
                startHomeActivity()
            }

            override fun onTick(millisUntilFinished: Long) {
                loadingProgressBar.progress = getCompletionPercentage(millisUntilFinished)
            }
        }
        timer.start()
    }

    private fun getCompletionPercentage(remainingTime: Long): Int {
        val timeElapsed = TIMER_VALUE - remainingTime
        return timeElapsed.toInt() * 100 / TIMER_VALUE.toInt()
    }

    private fun startHomeActivity() {
        startActivity(HomeActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }
}
