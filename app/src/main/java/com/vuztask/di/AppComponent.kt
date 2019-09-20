package com.vuztask.di

import android.app.Application
import com.vuztask.App
import com.vuztask.di.modules.ActivityBindingModule
import com.vuztask.di.modules.ApplicationModule
import com.vuztask.di.modules.DataRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataRepositoryModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}