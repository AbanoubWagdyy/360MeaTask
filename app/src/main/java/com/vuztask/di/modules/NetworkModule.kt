package com.vuztask.di.modules

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vuzTask.data.retrofit.API_KEY
import com.vuzTask.data.retrofit.BaseURL
import com.vuzTask.data.retrofit.DEVICE_TOKEN
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideCache(application: Application): Cache {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        val httpCacheDirectory = File(application.cacheDir, "http-cache")
        return Cache(httpCacheDirectory, cacheSize)
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(MyOkHttpInterceptor(API_KEY, "en", DEVICE_TOKEN))

        return httpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BaseURL)
            .client(okHttpClient)
            .build()
    }

    class MyOkHttpInterceptor : Interceptor {

        internal var api_key: String
        internal var lang: String
        internal var device_key: String
        internal var token: String? = null

        constructor(api_key: String, lang: String, device_key: String) {
            this.api_key = api_key
            this.lang = lang
            this.device_key = device_key
        }

        constructor(token: String, api_key: String, lang: String, device_key: String) {
            this.api_key = api_key
            this.lang = lang
            this.device_key = device_key
            this.token = token
        }

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val newRequest: Request
            if (token == null) {
                newRequest = originalRequest.newBuilder()
                    .header("APIKEY", api_key)
                    .header("LANG", lang)
                    .header("DEVICEKEY", device_key)
                    .build()
            } else {
                newRequest = originalRequest.newBuilder()
                    .header("AUTHORIZATION", token!!)
                    .header("APIKEY", api_key)
                    .header("LANG", lang)
                    .header("DEVICEKEY", device_key)
                    .build()
            }

            return chain.proceed(newRequest)
        }
    }
}