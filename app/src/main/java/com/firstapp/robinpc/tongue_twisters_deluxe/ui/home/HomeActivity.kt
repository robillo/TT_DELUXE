package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.difficulty_level.DifficultyLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters.DifficultyAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.adapters.LengthAdapter
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list.length_level.LengthLevelActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.collections.ArrayList

class HomeActivity : BaseActivity(),
        LengthAdapter.LengthLevelClickListener,
        DifficultyAdapter.DifficultyLevelClickListener {

    private lateinit var lengthList: MutableList<LengthLevel>
    private lateinit var difficultyList: MutableList<DifficultyLevel>

    private lateinit var fadeInPremium: Animation
    private lateinit var fadeOutPremium: Animation

    private var isAnimatingPremium: Boolean = false

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBarColor(R.color.white, true)
        initLayout()
        setListeners()
    }

    private fun initLayout() {
        loadTwisterOfTheDay()
        loadAnimations()
        applyAnimations()
        loadData()
        setAdapters()
    }

    private fun setListeners() {
        setClickListeners()
        setScrollListener()
    }

    private fun setClickListeners() {

        twisterOfTheDayLayout.setOnClickListener {
            playTv.performClick()
        }

        playTv.setOnClickListener {
            startReadingActivity()
        }
    }

    private fun loadData() {
        loadLengthList()
        loadDifficultyList()
    }

    private fun loadLengthList() {
        lengthList = ArrayList()
        lengthList.add(LengthLevel("SMALL", "", "", 1, 140))
        lengthList.add(LengthLevel("MEDIUM", "", "", 141, 300))
        lengthList.add(LengthLevel("LONG", "", "", 301, 450))
    }

    private fun loadDifficultyList() {
        difficultyList = ArrayList()
        difficultyList.add(DifficultyLevel("LEVEL 1", "Beginner's Luck", "", 1, 140))
        difficultyList.add(DifficultyLevel("LEVEL 2", "Lit Up", "", 141, 300))
        difficultyList.add(DifficultyLevel("LEVEL 3", "Speeding Up", "", 301, 450))
    }

    private fun setAdapters() {
        setLengthAdapter()
        setDifficultyAdapter()
    }

    private fun setLengthAdapter() {
        lengthRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val adapter = LengthAdapter(lengthList)
        adapter.setLengthLevelClickListener(this)
        lengthRecycler.adapter = adapter
    }

    private fun setDifficultyAdapter() {
        difficultyRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val adapter = DifficultyAdapter(difficultyList)
        adapter.setDifficultyClickListener(this)
        difficultyRecycler.adapter = adapter
    }

    private fun loadAnimations() {
        fadeInPremium = AnimationUtils.loadAnimation(this, R.anim.fade_in_premium_home)
        fadeOutPremium = AnimationUtils.loadAnimation(this, R.anim.fade_out_premium_home)
    }

    private fun applyAnimations() {
        fadeInPremium.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isAnimatingPremium = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                isAnimatingPremium = false
                goPremiumLayout.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        fadeOutPremium.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isAnimatingPremium = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                isAnimatingPremium = false
                goPremiumLayout.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }

    private fun setScrollListener() {
        scrollView?.let {
            it.viewTreeObserver.addOnScrollChangedListener {
                when {
                    isScrollViewAtBottom(it) -> hidePremium()
                    isScrollViewAtTop(it) -> showPremium()
                    else -> hidePremium()
                }
            }
        }
    }

    private fun isScrollViewAtBottom(scrollView: ScrollView): Boolean {
        return !scrollView.canScrollVertically(1)
    }

    private fun isScrollViewAtTop(scrollView: ScrollView): Boolean {
        return !scrollView.canScrollVertically(-1)
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

    private fun hidePremium() {
        if(isAnimatingPremium || goPremiumLayout.visibility == View.GONE) return

        goPremiumLayout.startAnimation(fadeOutPremium)
    }

    private fun showPremium() {
        if(isAnimatingPremium || goPremiumLayout.visibility == View.VISIBLE) return

        goPremiumLayout.startAnimation(fadeInPremium)
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

    private fun startReadingActivity() {
        startActivity(ReadingActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }
}