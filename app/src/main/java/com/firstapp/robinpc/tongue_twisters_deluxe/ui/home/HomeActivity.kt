package com.firstapp.robinpc.tongue_twisters_deluxe.ui.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : BaseActivity() {

    private lateinit var fadeInHeader: Animation
    private lateinit var fadeOutHeader: Animation
    private lateinit var fadeInPremium: Animation
    private lateinit var fadeOutPremium: Animation

    private var isAnimatingHeader: Boolean = false
    private var isAnimatingPremium: Boolean = false

    companion object {
        const val DELAY_TWISTER_OF_THE_DAY_LOADING = 1000L
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBarColor(R.color.white)
        loadTwisterOfTheDay()
        setScrollListener()
        loadAnimations()
        applyAnimations()
    }

    private fun loadAnimations() {
        fadeInHeader = AnimationUtils.loadAnimation(this, R.anim.fade_in_header_home)
        fadeOutHeader = AnimationUtils.loadAnimation(this, R.anim.fade_out_header_home)
        fadeInPremium = AnimationUtils.loadAnimation(this, R.anim.fade_in_premium_home)
        fadeOutPremium = AnimationUtils.loadAnimation(this, R.anim.fade_out_premium_home)
    }

    private fun applyAnimations() {
        fadeInHeader.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isAnimatingHeader = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                isAnimatingHeader = false
                homeHeaderTv.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        fadeOutHeader.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isAnimatingHeader = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                isAnimatingHeader = false
                homeHeaderTv.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

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
                    isScrollViewAtBottom(it) -> {
                        hideHeader()
                        hidePremium()
                    }
                    isScrollViewAtTop(it) -> {
                        showPremium()
                        showHeader()
                    }
                    else -> {
                        hidePremium()
                        hideHeader()
                    }
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
        //TODO: do in actual later
        Timer().schedule(object: TimerTask() {
            override fun run() {
                runOnUiThread {
                    showTwisterOfTheDay()
                }
            }
        }, DELAY_TWISTER_OF_THE_DAY_LOADING)
    }

    private fun showTwisterOfTheDay() {
        loadingTwisterOfDayProgress.visibility = View.GONE
        twisterOfTheDayLayoutMain.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        val goHome = Intent(Intent.ACTION_MAIN)
        goHome.addCategory(Intent.CATEGORY_HOME)
        goHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(goHome)
    }

    private fun hideHeader() {
        if(isAnimatingHeader || homeHeaderTv.visibility == View.GONE) return

        homeHeaderTv.startAnimation(fadeOutHeader)
    }

    private fun showHeader() {
        if(isAnimatingHeader || homeHeaderTv.visibility == View.VISIBLE) return

        homeHeaderTv.startAnimation(fadeInHeader)
    }

    private fun hidePremium() {
        if(isAnimatingPremium || goPremiumLayout.visibility == View.GONE) return

        goPremiumLayout.startAnimation(fadeOutPremium)
    }

    private fun showPremium() {
        if(isAnimatingPremium || goPremiumLayout.visibility == View.VISIBLE) return

        goPremiumLayout.startAnimation(fadeInPremium)
    }
}