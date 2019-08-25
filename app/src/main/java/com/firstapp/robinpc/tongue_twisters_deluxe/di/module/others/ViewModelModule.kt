package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others

import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.di.mapkey.ViewModelKey
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.HomeActivityViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.difficulty_level.DifficultyLevelActivityViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.length_level.LengthLevelActivityViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading.ReadingActivityViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(homeActivityViewModel: HomeActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DifficultyLevelActivityViewModel::class)
    abstract fun bindDifficultyLevelActivityViewModel(difficultyLevelActivityViewModel: DifficultyLevelActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LengthLevelActivityViewModel::class)
    abstract fun bindLengthLevelActivityViewModel(lengthLevelActivityViewModel: LengthLevelActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReadingActivityViewModel::class)
    abstract fun bindReadingActivityViewModel(readingActivityViewModel: ReadingActivityViewModel): ViewModel

}