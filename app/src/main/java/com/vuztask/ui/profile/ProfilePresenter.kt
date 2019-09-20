package com.vuztask.ui.profile

import androidx.appcompat.app.AppCompatActivity
import com.vuztask.data.RepositorySource
import com.vuztask.data.model.AuthData
import javax.inject.Inject

class ProfilePresenter @Inject constructor(val mRepositorySource: RepositorySource) :
    ProfileContract.Presenter {

    override fun getAuthData(): AuthData {
        return mRepositorySource.getAuthData()!!
    }

    override fun logout() {
        mRepositorySource.clearData()
        mView.restartApp()
    }

    override fun setActivity(activity: AppCompatActivity) {
        this.activity = activity
        if (this.activity is ProfileContract.View)
            this.mView = activity as ProfileContract.View
    }

    private lateinit var activity: AppCompatActivity
    private lateinit var mView: ProfileContract.View
}