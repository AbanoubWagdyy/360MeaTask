package com.vuztask.di.modules

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.vuztask.data.db.AppDatabase
import com.vuztask.data.db.QueryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "vueztask.db")
            .allowMainThreadQueries().build()
    }
}