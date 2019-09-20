package com.vuztask.ui.profile

import com.vuztask.di.scopes.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class ProfileModule {

    @ActivityScope
    @Binds
    abstract fun profilePresenter(presenter: ProfilePresenter): ProfileContract.Presenter
}