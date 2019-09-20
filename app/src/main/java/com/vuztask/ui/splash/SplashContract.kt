package com.vuztask.ui.splash

import androidx.appcompat.app.AppCompatActivity

interface SplashContract {

    interface Presenter {
        fun start()
        fun setActivity(activity: AppCompatActivity)
    }

    interface View {
        fun showLoginScreen()
        fun showProfileScreen()
    }
}