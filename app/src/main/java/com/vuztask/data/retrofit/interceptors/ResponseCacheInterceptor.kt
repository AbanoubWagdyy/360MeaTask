package com.vuzTask.data.retrofit.interceptors

import com.vuzTask.data.retrofit.API_KEY
import com.vuzTask.data.retrofit.DEVICE_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class ResponseCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        return originalResponse.newBuilder()
            .header("Cache-Control", "public, max-age=0")
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("APIKEY", API_KEY)
            .header("LANG", "en")
            .header("DEVICEKEY", DEVICE_TOKEN)
            .build()
    }
}