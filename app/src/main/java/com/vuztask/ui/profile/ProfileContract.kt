package com.vuztask.ui.profile

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import com.vuztask.data.model.AuthData


interface ProfileContract {

    interface View {
        fun restartApp()
    }

    interface Presenter {
        fun setActivity(activity: AppCompatActivity)
        fun logout()
        fun getAuthData() : AuthData
    }
}