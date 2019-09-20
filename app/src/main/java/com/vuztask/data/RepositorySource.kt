package com.vuztask.data

import androidx.lifecycle.MutableLiveData
import com.vuztask.data.model.AuthData
import com.vuztask.data.model.User

interface RepositorySource {
    fun login(email: String, password: String): MutableLiveData<User>
    fun getAuthData(): AuthData?
    fun clearData()
}