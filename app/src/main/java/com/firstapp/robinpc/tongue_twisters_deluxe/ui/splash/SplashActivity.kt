package com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash

import android.os.CountDownTimer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerSplashActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.HomeActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DIFFICULTY_LEVEL_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.LENGTH_LEVEL_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TWISTER_COUNT
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var currentProgress: String
    private lateinit var viewModel: SplashViewModel

    companion object {
        private const val STEP_VALUE = 200L
        private const val TIMER_VALUE = 2000L
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun setup() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
        setDefaultValues()
        setComponent()
        setObservers()
        checkForDatabaseCompletion()
    }

    private fun setDefaultValues() {
        currentProgress = SplashViewModel.Companion.Progress.APP_STARTED.name
    }

    private fun checkForDatabaseCompletion() {
        viewModel.getDatabaseElementsCount().observe(this, Observer { totalCount ->
            if(totalCount == getExpectedElementsCount())
                startTimer()
            else fetchJsonFromAssets()
        })
    }

    private fun setObservers() {
        viewModel.loadProgressLiveData.observe(this, Observer { progress ->

            currentProgress = progress

            when(currentProgress) {
                SplashViewModel.Companion.Progress.JSON_LOADED.name -> {
                    viewModel.convertArrays()
                }
                SplashViewModel.Companion.Progress.ARRAYS_CONVERTED.name -> {
                    viewModel.insertListsIntoRoom()
                }
                SplashViewModel.Companion.Progress.DATA_STORED.name -> {
                    startTimer()
                }
            }
        })
    }

    private fun getExpectedElementsCount(): Int {
        return TWISTER_COUNT + LENGTH_LEVEL_COUNT + DIFFICULTY_LEVEL_COUNT
    }

    private fun fetchJsonFromAssets() {
        if(currentProgress == SplashViewModel.Companion.Progress.APP_STARTED.name)
            viewModel.fetchJsonFromAssets()
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
        val timeElapsed = TIMER_VALUE - remainingTime + STEP_VALUE
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
