package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.activity

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.PerFragmentScope
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(private val context: Context) {

    companion object {
        const val GRID_SPAN_COUNT = 2
        const val SHOULD_REVERSE_GRID = false
    }

    @Provides
    @PerFragmentScope
    fun gridLayoutManager(): GridLayoutManager {
        return GridLayoutManager(context, GRID_SPAN_COUNT, RecyclerView.VERTICAL, SHOULD_REVERSE_GRID)
    }
}