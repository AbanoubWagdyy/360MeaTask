package com.vuztask.ui.login

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import com.vuztask.R
import com.vuztask.ui.profile.ProfileActivity
import com.vuztask.utils.DialogUtils
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

    override fun showError(message: String) {
        tvError.visibility = View.VISIBLE
        tvError.text = message
    }

    override fun getActivityResources(): Resources {
        return resources
    }

    override fun showLoading() {
        DialogUtils.showLoadingDialog(this)
    }

    override fun dismissLoading() {
        DialogUtils.dismissProgressDialog()
    }

    override fun showProfilePage() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

    @Inject
    lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mPresenter.setActivity(this)

        login.setOnClickListener {
            tvError.visibility = View.GONE
            mPresenter.login(email.text.toString(), password.text.toString())
        }
    }
}