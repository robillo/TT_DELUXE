package com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerSplashActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    companion object {
        private const val STEP_VALUE = 200L
        private const val TIMER_VALUE = 1000L
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun setup() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
        setComponent()
        setObservers()
        fetchJsonFromAssets()
    }

    private fun setObservers() {
        viewModel.loadProgressLiveData.observe(this, Observer { progress ->
            Log.e("myTag", "progress is $progress")

            when(progress) {
                SplashViewModel.Companion.Progress.JSON_LOADED.name -> {
                    viewModel.convertArrays()
                }
                SplashViewModel.Companion.Progress.ARRAYS_CONVERTED.name -> {
                    viewModel.insertListsIntoRoom()
                }
                SplashViewModel.Companion.Progress.DATA_STORED.name -> {
                    //TODO - go to next activity
                    fetchTwisters()
                }
            }
        })
    }

    private fun fetchTwisters() {
        viewModel.getAllTwisters().observe(this, Observer { list ->
            Log.e("myTag", "${list.size}")
        })
    }

    private fun fetchJsonFromAssets() {
        viewModel.fetchJsonFromAssets()
    }

    @Suppress("unused")
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

    private fun setComponent() {
        DaggerSplashActivityComponent.builder()
                .appComponent(getAppComponent())
                .build().injectSplashActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(SplashViewModel::class.java)
    }
}
