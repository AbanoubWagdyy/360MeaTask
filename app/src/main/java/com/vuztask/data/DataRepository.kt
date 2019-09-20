package com.vuztask.data

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vuzTask.data.retrofit.RetrofitService
import com.vuztask.data.db.QueryDao
import com.vuztask.data.model.AuthData
import com.vuztask.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataRepository @Inject constructor(
    val mQueryDao: QueryDao,
    val mRetrofitService: RetrofitService
) : RepositorySource {

    override fun clearData() {
        mQueryDao.deleteAllUsers()
    }

    override fun getAuthData(): AuthData? {
        val loggedInUser = mQueryDao.getLoggedInUser
        if (loggedInUser.isNotEmpty())
            return mQueryDao.getLoggedInUser[0].data
        else
            return null
    }

    @SuppressLint("CheckResult")
    override fun login(email: String, password: String): MutableLiveData<User> {
        val liveData = MutableLiveData<User>()
        mRetrofitService.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .doOnTerminate { }
            .subscribe({ user ->
                if (user.status == 1)
                    mQueryDao.insertUser(user)
                liveData.value = user
            }, {
                Log.d("", it.toString())
            })

        return liveData
    }
}