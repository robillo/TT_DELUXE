package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerHomeActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.activity.HomeActivityModule
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.difficulty_level.DifficultyLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters.DifficultyAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.length_level.LengthLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.tathastu.popup.SubscribeTathastuDialogFragment
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TWISTER_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_DAY_TWISTER
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject
import android.net.Uri
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.EXTRA_PREFERENCE_WAS_EVER_SUBSCRIBE_CLICKED
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.SPOKEN_TWISTER_MAX_PROMPT_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.TwisterPreferences


class HomeActivity : BaseActivity(),
        DifficultyAdapter.DifficultyLevelClickListener,
        SubscribeTathastuDialogFragment.SubscribeClickListener {

    @Inject
    lateinit var preferences: TwisterPreferences

    @Inject
    lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var dayTwister: Twister
    private lateinit var lengthList: List<LengthLevel>
    private lateinit var viewModel: HomeActivityViewModel
    private lateinit var difficultyList: List<DifficultyLevel>
    private lateinit var subscribeDialog: SubscribeTathastuDialogFragment

    companion object {
        private const val SMALL_LENGTH_LEVEL_INDEX = 0
        private const val MEDIUM_LENGTH_LEVEL_INDEX = 1
        private const val LONG_LENGTH_LEVEL_INDEX = 2
        private const val TAG_SUBSCRIBE_DIALOG = "TAG_SUBSCRIBE_DIALOG"
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBar()
        setComponent()
        initLayout()
        setListeners()
    }

    override fun onResume() {
        super.onResume()

        if(shouldShowSubscribeTathastuDialog())
            showSubscribeTathastuDialog()
    }

    private fun shouldShowSubscribeTathastuDialog(): Boolean {
        return !wasSubscribeButtonEverClicked() && isSpokenTwisterLimitReached()
    }

    private fun wasSubscribeButtonEverClicked(): Boolean {
        return preferences.getBoolean(EXTRA_PREFERENCE_WAS_EVER_SUBSCRIBE_CLICKED)
    }

    private fun isSpokenTwisterLimitReached(): Boolean {
        return preferences.getInt(
                EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0
        ) > SPOKEN_TWISTER_MAX_PROMPT_COUNT
    }

    private fun showSubscribeTathastuDialog() {
        if(!::subscribeDialog.isInitialized) {
            subscribeDialog = SubscribeTathastuDialogFragment.newInstance()
            subscribeDialog.setSubscribeClickListener(this)
        }

        subscribeDialog.show(supportFragmentManager, TAG_SUBSCRIBE_DIALOG)
    }

    private fun initLayout() {
        loadData()
    }

    private fun setListeners() {
        setClickListeners()
    }

    private fun setClickListeners() {
        dayTwisterCardLayout.setOnClickListener {
            openDayTwisterButton.callOnClick()
        }
        openDayTwisterButton.setOnClickListener {
            startReadingActivity()
        }
        smallTwistersHolderView.setOnClickListener {
            startLengthLevelActivity(lengthList[SMALL_LENGTH_LEVEL_INDEX])
        }
        mediumTwistersHolderView.setOnClickListener {
            startLengthLevelActivity(lengthList[MEDIUM_LENGTH_LEVEL_INDEX])
        }
        longTwistersHolderView.setOnClickListener {
            startLengthLevelActivity(lengthList[LONG_LENGTH_LEVEL_INDEX])
        }
    }

    private fun loadData() {
        loadLengthList()
        loadDifficultyList()
        loadTwisterOfTheDay()
    }

    private fun loadLengthList() {
        viewModel.getAllLengthLevels().observe(this, androidx.lifecycle.Observer {
            it?.let {
                this.lengthList = it
            }
        })
    }

    private fun loadDifficultyList() {
        viewModel.getAllDifficultyLevels().observe(this, androidx.lifecycle.Observer {
            it?.let {
                this.difficultyList = it
                setDifficultyAdapter()
            }
        })
    }

    private fun setDifficultyAdapter() {
        difficultyRecycler.layoutManager = gridLayoutManager
        val adapter = DifficultyAdapter(difficultyList)
        adapter.setDifficultyClickListener(this)
        difficultyRecycler.adapter = adapter
    }

    private fun loadTwisterOfTheDay() {
        val dayTwisterId = Random().nextInt(TWISTER_COUNT)
        viewModel.getTwisterForIndex(dayTwisterId).observe(this, androidx.lifecycle.Observer {
            it?.let {
                dayTwister = it
                renderForDayTwister()
            }
        })
    }

    private fun renderForDayTwister() {
        dayTwisterNameTv.text = dayTwister.name
    }

    override fun onBackPressed() {
        val goHome = Intent(Intent.ACTION_MAIN)
        goHome.addCategory(Intent.CATEGORY_HOME)
        goHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(goHome)
    }

    private fun setStatusBar() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
    }

    override fun difficultyClicked(difficultyLevel: DifficultyLevel) {
        startDifficultyLevelActivity(difficultyLevel)
    }

    private fun startLengthLevelActivity(lengthLevel: LengthLevel) {
        startActivity(LengthLevelActivity.newIntent(this, lengthLevel))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun startDifficultyLevelActivity(difficultyLevel: DifficultyLevel) {
        startActivity(DifficultyLevelActivity.newIntent(this, difficultyLevel))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun startReadingActivity() {
        if(::dayTwister.isInitialized) {
            startActivity(ReadingActivity.newIntent(this, dayTwister, TYPE_DAY_TWISTER))
            animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
        }
    }

    private fun setComponent() {
        DaggerHomeActivityComponent.builder()
                .appComponent(getAppComponent())
                .homeActivityModule(HomeActivityModule(this))
                .build().injectHomeActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeActivityViewModel::class.java)
    }

    override fun onSubscribeClicked() {
        val subscribeLink = getString(R.string.tathastu_subscribe_bitly_link)
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(subscribeLink))
        startActivity(webIntent)

        preferences.putBoolean(EXTRA_PREFERENCE_WAS_EVER_SUBSCRIBE_CLICKED, true)
        preferences.putInt(EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0)
    }

    override fun onSubscribeDismissed() {
        preferences.putInt(EXTRA_PREFERENCE_TWISTERS_SINCE_LAST_LIMIT, 0)
    }
}