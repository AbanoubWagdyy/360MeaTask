package com.vuzTask.data.retrofit

import com.vuztask.data.model.User
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import io.reactivex.Observable

interface RetrofitService {

    @Headers("Accept: application/json", "Content-type: application/json")
    @POST("login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Observable<User>
}