package com.firstapp.robinpc.tongue_twisters_deluxe.new_app.level_screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.WindowManager
import android.widget.ScrollView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils.IntentExtras
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_level.*
import kotlinx.android.synthetic.main.activity_your.*

class LevelActivity : AppCompatActivity() {

    private var LEVEL_NUMBER: Int = -1
    private var currentTwisterIndex = 0
    private lateinit var LEVEL_NAME: String
    private lateinit var levelTwistersHeadersArray: Array<String>
    private lateinit var levelTwistersArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        setup()
    }

    private fun setup() {
        setStatusBarColor()
        setLevelNumberAndNameFromIntent()
        setLevelTwistersFromIntent()
        setLevelNumberAndNameToViews()
        showTwisterForCurrentTwisterIndex()
        setClickListeners()
    }

    private fun setClickListeners() {
        previous_twister_button_card.setOnClickListener {
            currentTwisterIndex--
            showTwisterForCurrentTwisterIndex()
        }
        next_twister_button_card.setOnClickListener {
            currentTwisterIndex++
            showTwisterForCurrentTwisterIndex()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showTwisterForCurrentTwisterIndex() {
        twister_number_text_view.text = "twister ".plus(currentTwisterIndex + 1)
        twister_name_text_view.text = levelTwistersHeadersArray[currentTwisterIndex]
        twister_scroll_view.fullScroll(ScrollView.FOCUS_UP)
        twister_text_view.text = levelTwistersArray[currentTwisterIndex]
        setCursorsVisibilityAccordingToIndex()
    }

    private fun setCursorsVisibilityAccordingToIndex() {
        if(currentTwisterIndex == 0)
            hidePreviousButtonAndHint()
        else if(currentTwisterIndex == levelTwistersHeadersArray.size - 1)
            hideNextButtonAndHint()
        else {
            showPreviousButtonAndHint()
            showNextButtonAndHint()
        }
    }

    private fun hidePreviousButtonAndHint() {
        previous_twister_button_card.visibility = View.INVISIBLE
        previous_hint_text_view.visibility = View.INVISIBLE
        previous_twister_button_card.isClickable = false
    }

    private fun showPreviousButtonAndHint() {
        previous_twister_button_card.visibility = View.VISIBLE
        previous_hint_text_view.visibility = View.VISIBLE
        previous_twister_button_card.isClickable = true
    }

    private fun hideNextButtonAndHint() {
        next_twister_button_card.visibility = View.INVISIBLE
        next_hint_text_view.visibility = View.INVISIBLE
        next_twister_button_card.isClickable = false
    }

    private fun showNextButtonAndHint() {
        next_twister_button_card.visibility = View.VISIBLE
        next_hint_text_view.visibility = View.VISIBLE
        next_twister_button_card.isClickable = true
    }

    private fun setLevelNumberAndNameFromIntent() {
        val levelNumberString = intent.getStringExtra(IntentExtras.EXTRA_LEVEL_NUMBER)
        val levelNumberHeadersArray = resources.getStringArray(R.array.level_number_headers)
        val levelNamesArray = resources.getStringArray(R.array.level_names)
        when(levelNumberString) {
            levelNumberHeadersArray[1] -> LEVEL_NUMBER = 1
            levelNumberHeadersArray[2] -> LEVEL_NUMBER = 2
            levelNumberHeadersArray[3] -> LEVEL_NUMBER = 3
            levelNumberHeadersArray[4] -> LEVEL_NUMBER = 4
            levelNumberHeadersArray[5] -> LEVEL_NUMBER = 5
            levelNumberHeadersArray[6] -> LEVEL_NUMBER = 6
            levelNumberHeadersArray[7] -> LEVEL_NUMBER = 7
            levelNumberHeadersArray[8] -> LEVEL_NUMBER = 8
            levelNumberHeadersArray[9] -> LEVEL_NUMBER = 9
            levelNumberHeadersArray[10] -> LEVEL_NUMBER = 10
        }
        LEVEL_NAME = levelNamesArray[LEVEL_NUMBER]
    }

    private fun setLevelTwistersFromIntent() {
        when(LEVEL_NUMBER) {
            1 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.one_headers)
                levelTwistersArray = resources.getStringArray(R.array.one)
            }
            2 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.two_headers)
                levelTwistersArray = resources.getStringArray(R.array.two)
            }
            3 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.three_headers)
                levelTwistersArray = resources.getStringArray(R.array.three)
            }
            4 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.four_headers)
                levelTwistersArray = resources.getStringArray(R.array.four)
            }
            5 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.five_headers)
                levelTwistersArray = resources.getStringArray(R.array.five)
            }
            6 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.six_headers)
                levelTwistersArray = resources.getStringArray(R.array.six)
            }
            7 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.seven_headers)
                levelTwistersArray = resources.getStringArray(R.array.seven)
            }
            8 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.eight_headers)
                levelTwistersArray = resources.getStringArray(R.array.eight)
            }
            9 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.nine_headers)
                levelTwistersArray = resources.getStringArray(R.array.nine)
            }
            10 -> {
                levelTwistersHeadersArray = resources.getStringArray(R.array.ten_headers)
                levelTwistersArray = resources.getStringArray(R.array.ten)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setLevelNumberAndNameToViews() {
        level_number_header_text_view.text = "level $LEVEL_NUMBER"
        level_name_text_view.text = LEVEL_NAME
    }

    private fun setStatusBarColor() {
        var flags = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorWhiteShade)
        setWindowFlags(flags)
    }

    private fun setWindowFlags(flags: Int) {
        window.decorView.systemUiVisibility = flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity);
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}