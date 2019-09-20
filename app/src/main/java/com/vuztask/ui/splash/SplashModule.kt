package com.vuztask.ui.splash

import com.vuztask.di.scopes.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class SplashModule {

    @ActivityScope
    @Binds
    abstract fun splashPresenter(presenter: SplashPresenter): SplashContract.Presenter
}