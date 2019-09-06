package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity.DaggerReadingActivityComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseActivity
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ReadingActivityViewModel

    companion object {
        private const val EXTRA_TWISTER = "TWISTER"
        fun newIntent(context: Context, twister: Twister): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(EXTRA_TWISTER, twister)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_reading
    }

    override fun setup() {
        setStatusBarColor(R.color.white, LIGHT_STATUS_BAR)
        setComponent()
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
