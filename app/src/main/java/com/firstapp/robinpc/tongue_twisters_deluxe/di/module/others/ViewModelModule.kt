package com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others

import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.di.mapkey.ViewModelKey
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

}