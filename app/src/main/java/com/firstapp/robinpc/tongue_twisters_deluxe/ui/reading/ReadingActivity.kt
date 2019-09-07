package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerReadingActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DAY_TWISTER
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DIFFICULTY
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_LENGTH
import kotlinx.android.synthetic.main.activity_reading.*
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    private var launchedFrom: Int = TYPE_DAY_TWISTER

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var twister: Twister
    private lateinit var viewModel: ReadingActivityViewModel

    companion object {

        private const val EXTRA_TWISTER = "TWISTER"
        private const val EXTRA_LAUNCHED_FROM = "LAUNCHED_FROM"

        fun newIntent(context: Context, twister: Twister, launchedFrom: Int): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(EXTRA_TWISTER, twister)
            intent.putExtra(EXTRA_LAUNCHED_FROM, launchedFrom)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_reading
    }

    override fun setup() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
        getVariables()
        setComponent()
        setViews()
        setClickListeners()
    }

    private fun getVariables() {
        twister = intent.getParcelableExtra(EXTRA_TWISTER)
        launchedFrom = intent.getIntExtra(EXTRA_LAUNCHED_FROM, TYPE_DAY_TWISTER)
    }

    private fun setViews() {
        renderForTwisterSource()
        setTwister()
    }

    private fun renderForTwisterSource() {
        when(launchedFrom) {
            TYPE_LENGTH -> render(R.color.length_reading_activity_twister_color)
            TYPE_DIFFICULTY -> render(R.color.difficulty_reading_activity_twister_color)
            TYPE_DAY_TWISTER -> render(R.color.day_twister_reading_activity_twister_color)
        }
    }

    private fun render(colorId: Int) {
        val color = getColorFromId(colorId)
        twisterHeaderTv.setTextColor(color)
        setControlColors(color)
    }

    private fun setControlColors(color: Int) {
        nextButtonIv.setColorFilter(color)
        previousButtonIv.setColorFilter(color)
        playPauseButtonIv.setColorFilter(color)
    }

    private fun setClickListeners() {
        previousHolder.setOnClickListener {
            //TODO - do something
        }
        playPauseHolder.setOnClickListener {
            //TODO - do something
        }
        nextHolder.setOnClickListener {
            //TODO - do something
        }
    }

    private fun getColorFromId(colorId: Int): Int {
        return ContextCompat.getColor(this, colorId)
    }

    private fun setTwister() {
        twisterHeaderTv.text = twister.name
        twisterContentTv.text = twister.twister
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateActivityTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    private fun setComponent() {
        DaggerReadingActivityComponent.builder()
                .appComponent(getAppComponent())
                .build().injectReadingActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ReadingActivityViewModel::class.java)
    }
}
