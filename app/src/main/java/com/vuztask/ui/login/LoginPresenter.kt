package com.vuztask.ui.login

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vuztask.R
import com.vuztask.data.RepositorySource
import com.vuztask.utils.isEmailValid
import com.vuztask.utils.isPasswordValid
import javax.inject.Inject

class LoginPresenter @Inject constructor(val mRepositorySource: RepositorySource) :
    LoginContract.Presenter {

    private lateinit var activity: AppCompatActivity
    private lateinit var mView: LoginContract.View

    override fun login(email: String, password: String) {
        val isEmailValid = email.isEmailValid()
        val isPasswordValid = password.isPasswordValid()
        if (email.equals("") || password.equals(""))
            mView.showError(mView.getActivityResources().getString(R.string.complete_all_fields))
        else {
            if (!isEmailValid) {
                mView.showError(mView.getActivityResources().getString(R.string.invalid_email))
            } else if (!isPasswordValid) {
                mView.showError(mView.getActivityResources().getString(R.string.invalid_password))
            } else {
                mView.showLoading()
                mRepositorySource.login(email, password)
                    .observe(activity, Observer {
                        mView.dismissLoading()
                        if (it.status == 1) {
                            mView.showProfilePage()
                        } else {
                            mView.showError(it.message!!)
                        }
                    })
            }
        }
    }

    override fun setActivity(activity: AppCompatActivity) {
        this.activity = activity
        if (this.activity is LoginContract.View)
            this.mView = activity as LoginContract.View
    }
}