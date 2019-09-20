package com.vuztask.ui.splash

import androidx.appcompat.app.AppCompatActivity
import com.vuztask.data.RepositorySource
import javax.inject.Inject

class SplashPresenter @Inject constructor(val mRepositorySource: RepositorySource) :
    SplashContract.Presenter {

    override fun start() {
        val loggedUser = mRepositorySource.getAuthData()
        if (loggedUser == null) {
            mView.showLoginScreen()
        } else {
            mView.showProfileScreen()
        }
    }

    override fun setActivity(activity: AppCompatActivity) {
        this.activity = activity
        if (this.activity is SplashContract.View)
            this.mView = activity as SplashContract.View
    }

    private lateinit var activity: AppCompatActivity
    private lateinit var mView: SplashContract.View
}