package com.firstapp.robinpc.tongue_twisters_deluxe.utils.view_pager_transformers

import android.view.View

open class StackTransformer : ABaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.translationX = if (position < 0) 0f else -page.width * position
    }

}