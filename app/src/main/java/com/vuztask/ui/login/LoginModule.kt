package com.vuztask.ui.login

import com.vuztask.di.scopes.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @ActivityScope
    @Binds
    abstract fun loginPresenter(presenter: LoginPresenter): LoginContract.Presenter
}