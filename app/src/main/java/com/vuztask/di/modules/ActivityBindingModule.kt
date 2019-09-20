package com.vuztask.di.modules

import com.vuzTask.ui.splash.SplashActivity
import com.vuztask.di.scopes.ActivityScope
import com.vuztask.ui.login.LoginActivity
import com.vuztask.ui.login.LoginModule
import com.vuztask.ui.profile.ProfileActivity
import com.vuztask.ui.profile.ProfileModule
import com.vuztask.ui.splash.SplashModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    internal abstract fun profileActivity(): ProfileActivity
}
