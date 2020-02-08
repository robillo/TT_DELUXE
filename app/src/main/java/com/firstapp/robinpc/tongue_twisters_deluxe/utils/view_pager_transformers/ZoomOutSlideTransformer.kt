package com.firstapp.robinpc.tongue_twisters_deluxe.utils.view_pager_transformers

import android.view.View

open class ZoomOutSlideTransformer : ABaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        if (position >= -1 || position <= 1) {
            // Modify the default slide transition to shrink the page as well
            val height = page.height.toFloat()
            val width = page.width.toFloat()
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
            val vertMargin = height * (1 - scaleFactor) / 2
            val horzMargin = width * (1 - scaleFactor) / 2

            // Center vertically
            page.pivotY = 0.5f * height
            page.pivotX = 0.5f * width

            page.translationX =
                    if (position < 0) horzMargin - vertMargin / 2
                    else -horzMargin + vertMargin / 2

            // Scale the page down (between MIN_SCALE and 1)
            page.scaleX = scaleFactor
            page.scaleY = scaleFactor

            // Fade the page relative to its size.
            page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
        }
    }

    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }

}