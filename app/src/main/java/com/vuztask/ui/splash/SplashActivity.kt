package com.vuzTask.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.vuztask.R
import com.vuztask.ui.login.LoginActivity
import com.vuztask.ui.login.LoginContract
import com.vuztask.ui.profile.ProfileActivity
import com.vuztask.ui.splash.SplashContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), SplashContract.View {
    override fun showLoginScreen() {
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    override fun showProfileScreen() {
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, ProfileActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    @Inject
    lateinit var mPresenter: SplashContract.Presenter

    private val SPLASH_DISPLAY_LENGTH = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mPresenter.setActivity(this)
        mPresenter.start()
    }
}
