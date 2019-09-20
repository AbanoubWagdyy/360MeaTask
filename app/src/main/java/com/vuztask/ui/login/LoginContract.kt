package com.vuztask.ui.login

import android.app.Activity
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity


interface LoginContract {

    interface View {
        fun showError(message: String)
        fun getActivityResources(): Resources
        fun showLoading()
        fun dismissLoading()
        fun showProfilePage()
    }

    interface Presenter {
        fun setActivity(activity: AppCompatActivity)
        fun login(email: String, password: String)
    }
}