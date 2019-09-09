package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerReadingActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.MAX_TWISTER_INDEX
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.MIN_TWISTER_INDEX
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DAY_TWISTER
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DIFFICULTY
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_LENGTH
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.UNIT_VALUE_INT
import kotlinx.android.synthetic.main.activity_reading.*
import java.util.*
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    private var isTwisterPlaying: Boolean = false
    private var launchedFrom: Int = TYPE_DAY_TWISTER

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var twister: Twister
    private lateinit var textToSpeech: TextToSpeech
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

    private fun initTextToSpeech() {
        textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->

            if(isTextToSpeechSuccess(status)) {
                textToSpeech.language = Locale.UK
                textToSpeech.setOnUtteranceProgressListener(speechProgressListener)
            }
        })
    }

    private fun isTextToSpeechSuccess(status: Int): Boolean {
        return status != TextToSpeech.ERROR
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
            goPrevious((twister.id - UNIT_VALUE_INT))
        }
        playPauseHolder.setOnClickListener {
            playPauseTwister()
        }
        nextHolder.setOnClickListener {
            goNext((twister.id + UNIT_VALUE_INT))
        }
    }

    private fun playPauseTwister() {
        if(isTwisterPlaying)
            stopTextToSpeech()
        else
            playTextToSpeech()
    }

    private fun markTwisterAsStopped() {
        isTwisterPlaying = false
    }

    private fun markTwisterAsPlaying() {
        isTwisterPlaying = true
    }

    private fun stopTextToSpeech() {
        if(textToSpeech.isSpeaking) {
            markTwisterAsStopped()
            textToSpeech.stop()
        }
    }

    private fun playTextToSpeech() {
        if(!textToSpeech.isSpeaking) {
            textToSpeech.speak(twister.twister, TextToSpeech.QUEUE_FLUSH, null, null)
            markTwisterAsPlaying()
        }
    }

    override fun onStart() {
        initTextToSpeech()
        super.onStart()
    }

    override fun onStop() {
        killTextToSpeech()
        super.onStop()
    }

    private fun killTextToSpeech() {
        if(::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    private fun goNext(twisterIndex: Int) {

        if(canGoNext(twisterIndex))
            setTwisterObserver(viewModel.getTwisterForIndex(twisterIndex))

        else
            showToast(getStringFromId(R.string.last_item_reached))
    }

    private fun goPrevious(twisterIndex: Int) {

        if(canGoPrevious(twisterIndex))
            setTwisterObserver(viewModel.getTwisterForIndex(twisterIndex))

        else
            showToast(getStringFromId(R.string.first_item_reached))
    }

    private fun setTwisterObserver(twister: LiveData<Twister>) {
        stopTextToSpeech()
        markTwisterAsStopped()

        twister.observe(this, Observer {
            it?.let {
                this.twister = it
                setTwister()
            }
        })
    }

    private fun canGoNext(twisterIndex: Int): Boolean {
        return twisterIndex < MAX_TWISTER_INDEX
    }

    private fun canGoPrevious(twisterIndex: Int): Boolean {
        return twisterIndex > MIN_TWISTER_INDEX
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun getColorFromId(colorId: Int): Int {
        return ContextCompat.getColor(this, colorId)
    }

    private fun getStringFromId(stringId: Int): String {
        return resources.getString(stringId)
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

    private var speechProgressListener: UtteranceProgressListener =

            object: UtteranceProgressListener() {

                override fun onDone(utteranceId: String?) {
                    markTwisterAsStopped()
                }

                override fun onError(utteranceId: String?) {}

                override fun onStart(utteranceId: String?) {}

            }
}
