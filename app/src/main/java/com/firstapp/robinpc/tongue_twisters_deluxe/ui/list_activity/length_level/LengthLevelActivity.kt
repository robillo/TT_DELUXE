package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.length_level

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerLengthLevelActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.adapter.TwisterListAdaper
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TYPE_LENGTH
import kotlinx.android.synthetic.main.activity_length_level.*
import javax.inject.Inject

class LengthLevelActivity : BaseActivity(), TwisterListAdaper.TwisterClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var levelHeader: String
    private lateinit var twisterList: MutableList<Twister>
    private lateinit var viewModel: LengthLevelActivityViewModel

    companion object {
        private const val EXTRA_LENGTH_LEVEL = "LENGTH LEVEL"
        fun newIntent(context: Context, lengthLevel: LengthLevel): Intent {
            val intent = Intent(context, LengthLevelActivity::class.java)
            intent.putExtra(EXTRA_LENGTH_LEVEL, lengthLevel.title)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_length_level
    }

    override fun setup() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
        getArguments()
        setComponent()
        loadData()
        setViews()
        setTwisterAdapter()
    }

    private fun setViews() {
        setHeader()
        setBottomOutline()
    }

    private fun setHeader() {
        levelHeaderTv.text = levelHeader
    }

    private fun setBottomOutline() {
        bottomOutlineIv.setBackgroundColor(
                getColorFromId(R.color.length_level_header_bg)
        )
    }

    private fun getColorFromId(@Suppress("SameParameterValue") id: Int): Int {
        return ContextCompat.getColor(this, id)
    }

    private fun getArguments() {
        levelHeader = intent.getStringExtra(EXTRA_LENGTH_LEVEL)
    }

    private fun loadData() {
        loadTwisterList()
    }

    private fun setTwisterAdapter() {
        twisterRecycler.layoutManager = LinearLayoutManager(this)
        val adapter = TwisterListAdaper(twisterList, TYPE_LENGTH)
        adapter.setTwisterClickListener(this)
        twisterRecycler.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateActivityTransition(R.anim.slide_in_left_activity, R.anim.slide_out_right_activity)
    }

    override fun onUnlockedTwisterClicked(twister: Twister) {
        startReadingActivity(twister)
    }

    override fun onLockedTwisterClicked(twister: Twister) {
        //TODO: show dialog to unlock
    }

    private fun startReadingActivity(twister: Twister) {
        startActivity(ReadingActivity.newIntent(this, twister, TYPE_LENGTH))
        animateActivityTransition(R.anim.slide_in_right_activity, R.anim.slide_out_left_activity)
    }

    private fun setComponent() {
        DaggerLengthLevelActivityComponent.builder()
                .appComponent(getAppComponent())
                .build().injectLengthLevelActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(LengthLevelActivityViewModel::class.java)
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
}
