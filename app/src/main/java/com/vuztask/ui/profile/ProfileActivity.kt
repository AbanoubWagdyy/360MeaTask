package com.vuztask.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vuzTask.ui.splash.SplashActivity
import com.vuztask.R
import com.vuztask.databinding.ActivityProfileBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class ProfileActivity : DaggerAppCompatActivity(), ProfileContract.View {

    override fun restartApp() {

        val intent = Intent(this, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityProfile = DataBindingUtil.setContentView<ActivityProfileBinding>(
            this,
            R.layout.activity_profile
        )

        mPresenter.setActivity(this)

        activityProfile.authData = mPresenter.getAuthData()

        logout.setOnClickListener {
            mPresenter.logout()
        }
    }

    @Inject
    lateinit var mPresenter: ProfileContract.Presenter
}
