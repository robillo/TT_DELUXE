package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerHomeActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.difficulty_level.DifficultyLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters.DifficultyAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters.LengthAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.length_level.LengthLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class HomeActivity : BaseActivity(),
        LengthAdapter.LengthLevelClickListener,
        DifficultyAdapter.DifficultyLevelClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeActivityViewModel
    private lateinit var lengthList: MutableList<LengthLevel>
    private lateinit var difficultyList: MutableList<DifficultyLevel>

    companion object {
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

    private fun initLayout() {
        loadTwisterOfTheDay()
        loadData()
        setAdapters()
    }

    private fun setListeners() {
        setClickListeners()
    }

    private fun setClickListeners() {
        openDayTwisterButton.setOnClickListener {
            startReadingActivity()
        }
    }

    private fun loadData() {
        loadLengthList()
        loadDifficultyList()
    }

    private fun loadLengthList() {
        lengthList = ArrayList()
        lengthList.add(LengthLevel("SMALL", "", "", 1, 140, 100))
        lengthList.add(LengthLevel("MEDIUM", "", "", 141, 300, 100))
        lengthList.add(LengthLevel("LONG", "", "", 301, 450, 100))
    }

    private fun loadDifficultyList() {
        difficultyList = ArrayList()
        difficultyList.add(DifficultyLevel("LEVEL 1", "Beginner's Luck", "", 1, 140, 100))
        difficultyList.add(DifficultyLevel("LEVEL 2", "Lit Up", "", 141, 300, 100))
        difficultyList.add(DifficultyLevel("LEVEL 3", "Speeding Up", "", 301, 450, 100))
    }

    private fun setAdapters() {
        setLengthAdapter()
        setDifficultyAdapter()
    }

    private fun setLengthAdapter() {
//        lengthRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//        val adapter = LengthAdapter(lengthList)
//        adapter.setLengthLevelClickListener(this)
//        lengthRecycler.adapter = adapter
    }

    private fun setDifficultyAdapter() {
//        difficultyRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//        val adapter = DifficultyAdapter(difficultyList)
//        adapter.setDifficultyClickListener(this)
//        difficultyRecycler.adapter = adapter
    }

    private fun loadTwisterOfTheDay() {
        //TODO: load from ROOM DB in real
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

    override fun lengthLevelClicked(lengthLevel: LengthLevel) {
        startLengthLevelActivity()
    }

    override fun difficultyClicked(difficultyLevel: DifficultyLevel) {
        startDifficultyLevelActivity()
    }

    private fun startLengthLevelActivity() {
        startActivity(LengthLevelActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun startDifficultyLevelActivity() {
        startActivity(DifficultyLevelActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    @Suppress("unused")
    private fun startReadingActivity() {
        startActivity(ReadingActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun setComponent() {
        DaggerHomeActivityComponent.builder()
                .appComponent(getAppComponent())
                .build().injectHomeActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeActivityViewModel::class.java)
    }
}