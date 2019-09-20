package com.vuztask.di.modules

import androidx.annotation.NonNull
import com.vuzTask.data.retrofit.RetrofitService
import com.vuztask.data.DataRepository
import com.vuztask.data.RepositorySource
import com.vuztask.data.db.AppDatabase
import com.vuztask.data.db.QueryDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        DatabaseModule::class
    ]
)
class DataRepositoryModule {

    @Provides
    @Singleton
    fun provideQueryDao(@NonNull appDatabase: AppDatabase): QueryDao {
        return appDatabase.queryDao()
    }

    @Provides
    @Singleton
    fun provideRetrofitApiService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun mainRepoSource(queryDao: QueryDao, retrofitService: RetrofitService): RepositorySource {
        return DataRepository(queryDao, retrofitService)
    }
}