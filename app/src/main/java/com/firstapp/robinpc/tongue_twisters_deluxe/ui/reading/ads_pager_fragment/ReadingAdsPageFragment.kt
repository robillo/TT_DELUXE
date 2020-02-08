package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ads_pager_fragment

import android.view.View
import com.bumptech.glide.Glide

import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.base.BaseFragment
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.cell_view_pager_ad.*
import kotlinx.android.synthetic.main.cell_view_pager_ad.view.*

class ReadingAdsPageFragment : BaseFragment() {

    private lateinit var unifiedNativeAd: UnifiedNativeAd

    companion object {
        fun newInstance(): ReadingAdsPageFragment {
            return ReadingAdsPageFragment()
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_reading_ads_page
    }

    override fun setup() {
        if(::unifiedNativeAd.isInitialized)
            loadUnifiedAd(unifiedNativeAd)
    }

    fun setUnifiedAd(unifiedNativeAd: UnifiedNativeAd): ReadingAdsPageFragment {
        this.unifiedNativeAd = unifiedNativeAd
        return this
    }

    private fun loadUnifiedAd(unifiedNativeAd: UnifiedNativeAd) {
        unifiedAdViewHolder.visibility = View.VISIBLE

        unifiedAdViewHolder.installAppTitleTv.text = unifiedNativeAd.headline
        unifiedAdViewHolder.headlineView = unifiedAdViewHolder.installAppTitleTv

        unifiedNativeAd.body?.let {
            unifiedAdViewHolder.installAppDescriptionTv.text = it
            unifiedAdViewHolder.bodyView = unifiedAdViewHolder.installAppDescriptionTv
        }
        unifiedNativeAd.starRating?.let {
            unifiedAdViewHolder.installAppNumericRatingTv.text = it.toString()
            unifiedAdViewHolder.appNumbersHolder.visibility = View.VISIBLE
            unifiedAdViewHolder.starRatingView = unifiedAdViewHolder.installAppNumericRatingTv
        } ?: run {
            unifiedAdViewHolder.appNumbersHolder.visibility = View.GONE
        }
        unifiedNativeAd.icon?.uri?.let {
            unifiedAdViewHolder.installAppIconIv.clipToOutline = true
            Glide.with(this).load(it).into(unifiedAdViewHolder.installAppIconIv)
            unifiedAdViewHolder.iconView = unifiedAdViewHolder.installAppIconIv
        }
        unifiedNativeAd.callToAction?.let {
            unifiedAdViewHolder.callToActionTv.text = it
            unifiedAdViewHolder.callToActionView = unifiedAdViewHolder.callToActionTv
        }
        unifiedAdViewHolder.setNativeAd(unifiedNativeAd)
    }
}
