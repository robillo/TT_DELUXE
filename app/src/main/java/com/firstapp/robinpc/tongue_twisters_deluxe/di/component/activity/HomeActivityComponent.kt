package com.firstapp.robinpc.tongue_twisters_deluxe.di.component.activity

import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.AppComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.ViewModelFactoryModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.module.others.ViewModelModule
import com.firstapp.robinpc.tongue_twisters_deluxe.di.scope.PerFragmentScope
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.home.HomeActivity
import dagger.Component

@PerFragmentScope
@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface HomeActivityComponent {
    fun injectHomeActivity(homeActivity: HomeActivity)
}