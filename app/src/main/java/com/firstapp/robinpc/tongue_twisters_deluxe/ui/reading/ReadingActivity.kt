package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.tathastu.popup.SubscribeTathastuDialogFragment
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.MAX_TWISTER_INDEX
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.MIN_TWISTER_INDEX
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DAY_TWISTER
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DIFFICULTY
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_LENGTH
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.UNIT_VALUE_INT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.TwisterPreferences
import kotlinx.android.synthetic.main.activity_reading.*
import java.util.*
import javax.inject.Inject

class ReadingActivity : BaseActivity(), SubscribeTathastuDialogFragment.SubscribeClickListener {

    @Inject
    lateinit var preferences: TwisterPreferences

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var twister: Twister
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var viewModel: ReadingActivityViewModel
    private lateinit var subscribeDialog: SubscribeTathastuDialogFragment

    private var controlsColor: Int = -1
    private var isTwisterPlaying: Boolean = false
    private var launchedFrom: Int = TYPE_DAY_TWISTER
    private var utteranceMap = HashMap<String, String>()

    companion object {

        private const val EMPTY_STRING = ""
        private const val EXTRA_TWISTER = "TWISTER"
        private const val UTTERANCE_ID = "TWISTER_UTTERANCE"
        private const val EXTRA_LAUNCHED_FROM = "LAUNCHED_FROM"
        private const val TAG_SUBSCRIBE_DIALOG = "TAG_SUBSCRIBE_DIALOG"

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
        initVariables()
        setComponent()
        setViews()
        setClickListeners()
    }

    private fun initVariables() {
        utteranceMap[TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID] = UTTERANCE_ID
    }

    private fun getVariables() {
        (intent.getParcelableExtra(EXTRA_TWISTER) as Twister).let {
            twister = it
        }
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
                textToSpeech.language = Locale.ENGLISH
                textToSpeech.setOnUtteranceProgressListener(speechProgressListener)
            }
        })
    }

    private fun isTextToSpeechSuccess(status: Int): Boolean {
        return status != TextToSpeech.ERROR
    }

    private fun render(colorId: Int) {
        controlsColor = getColorFromId(colorId)
        twisterHeaderTv.setTextColor(controlsColor)
        setControlsColors()
        setPlayDrawable()
    }

    private fun setControlsColors() {
        nextButtonIv.setColorFilter(controlsColor)
        playPauseButtonIv.setColorFilter(controlsColor)
        previousButtonIv.setColorFilter(controlsColor)
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
        if(isTwisterPlaying) {
            setPlayDrawable()
            stopTextToSpeech()
        }
        else {
            if(shouldShowSubscribeTathastuDialog())
                showSubscribeTathastuDialog()
            else {
                setPauseDrawable()
                playTextToSpeech()
            }
        }
    }

    private fun shouldShowSubscribeTathastuDialog(): Boolean {
        return !wasSubscribeButtonEverClicked() && isSpokenTwisterLimitReached()
    }

    private fun wasSubscribeButtonEverClicked(): Boolean {
        return preferences.getBoolean(Constants.EXTRA_PREFERENCE_WAS_EVER_SUBSCRIBE_CLICKED)
    }

    private fun isSpokenTwisterLimitReached(): Boolean {
        return preferences.getInt(
                EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0
        ) > Constants.SPOKEN_TWISTER_MAX_PROMPT_COUNT
    }

    private fun showSubscribeTathastuDialog() {
        if(!::subscribeDialog.isInitialized) {
            subscribeDialog = SubscribeTathastuDialogFragment.newInstance()
            subscribeDialog.setSubscribeClickListener(this)
        }

        subscribeDialog.show(supportFragmentManager, TAG_SUBSCRIBE_DIALOG)
    }


    private fun markTwisterAsStopped() {
        setPlayDrawable()
        isTwisterPlaying = false
    }

    private fun markTwisterAsPlaying() {
        setPauseDrawable()
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
            textToSpeech.speak(twister.twister, TextToSpeech.QUEUE_FLUSH, getUtteranceParamsBundle(), UTTERANCE_ID)
            markTwisterAsPlaying()
        }
    }

    private fun getUtteranceParamsBundle(): Bundle {
        val bundle = Bundle()
        bundle.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, EMPTY_STRING)
        return bundle
    }

    private fun setPauseDrawable() {
        playPauseButtonIv.setImageResource(R.drawable.ic_pause_filled)
    }

    private fun setPlayDrawable() {
        playPauseButtonIv.setImageResource(R.drawable.ic_play_filled)
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
            showToast(getStringFromId(R.string.last_item_reached), Toast.LENGTH_SHORT)
    }

    private fun goPrevious(twisterIndex: Int) {

        if(canGoPrevious(twisterIndex))
            setTwisterObserver(viewModel.getTwisterForIndex(twisterIndex))

        else
            showToast(getStringFromId(R.string.first_item_reached), Toast.LENGTH_SHORT)
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

    private fun showToast(text: String, length: Int) {
        Toast.makeText(this, text, length).show()
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

    override fun onSubscribeClicked() {
        showToast(getString(R.string.please_subscribe_toast_text), Toast.LENGTH_LONG)

        val subscribeLink = getString(R.string.tathastu_subscribe_bitly_link)
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(subscribeLink))
        startActivity(webIntent)

        preferences.putBoolean(Constants.EXTRA_PREFERENCE_WAS_EVER_SUBSCRIBE_CLICKED, true)
        preferences.putInt(EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0)
    }

    override fun onSubscribeDismissed() {
        preferences.putInt(EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0)
    }

    private var speechProgressListener: UtteranceProgressListener =

            object: UtteranceProgressListener() {

                override fun onDone(utteranceId: String?) {
                    preferences.putInt(
                            EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT,
                            preferences.getInt(EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0) + 1
                    )
                    markTwisterAsStopped()
                }

                override fun onError(utteranceId: String?) {}

                override fun onStart(utteranceId: String?) {}

            }
}