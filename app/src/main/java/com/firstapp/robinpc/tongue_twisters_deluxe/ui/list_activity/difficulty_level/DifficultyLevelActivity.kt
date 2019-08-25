package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.difficulty_level

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerDifficultyLevelActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.adapter.TwisterListAdaper
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import kotlinx.android.synthetic.main.activity_difficulty_level.*
import javax.inject.Inject

class DifficultyLevelActivity : BaseActivity(), TwisterListAdaper.TwisterClickListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: DifficultyLevelActivityViewModel
    private lateinit var twisterList: MutableList<Twister>

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DifficultyLevelActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_difficulty_level
    }

    override fun setup() {
        setStatusBarColor(R.color.color_bg_twister_by_difficulty, LIGHT_STATUS_BAR)
        setComponent()
        loadData()
        setTwisterAdapter()
    }

    private fun loadData() {
        loadTwisterList()
    }

    private fun loadTwisterList() {
        twisterList = ArrayList()
        twisterList.add(Twister(
                0,
                "Denise and Fleas",
                "Denise sees the fleece, Denise sees the fleas.\nAt least Denise could sneeze and feed and freeze the fleas.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Santa's Suit",
                "Santa's short suit shrunk.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Ice Cream",
                "I scream, you scream, we all scream for ice-cream.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Slimy Snails",
                "Six slimy snails sailed silently.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Sammy",
                "Singing Sammy sung songs on sinking sands.",
                0,
                1,
                "",
                "",
                false
        ))
        twisterList.add(Twister(
                0,
                "Bad Bug",
                "A big black bug bit a big black dog on his big black nose.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Tom and Tim",
                "Tom threw Tim three thumbtacks.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Peter Piper",
                "Peter Piper picked a peck of pickled pepper.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Yeti",
                "Yelling yellow yelping Yeti.",
                0,
                1,
                "",
                "",
                true
        ))
        twisterList.add(Twister(
                0,
                "Hippo",
                "A happy hippo hopped and hicupped.",
                0,
                1,
                "",
                "",
                true
        ))
    }

    private fun setTwisterAdapter() {
        twisterRecycler.layoutManager = LinearLayoutManager(this)
        val adapter = TwisterListAdaper(twisterList)
        adapter.setTwisterClickListener(this)
        twisterRecycler.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateActivityTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun onUnlockedTwisterClicked(twister: Twister) {
        startReadingActivity()
    }

    override fun onLockedTwisterClicked(twister: Twister) {
        //TODO: show dialog to unlock
    }

    private fun startReadingActivity() {
        startActivity(ReadingActivity.newIntent(this))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun setComponent() {
        DaggerDifficultyLevelActivityComponent.builder()
                .appComponent(getAppComponent())
                .build().injectDifficultyLevelActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(DifficultyLevelActivityViewModel::class.java)
    }
}
