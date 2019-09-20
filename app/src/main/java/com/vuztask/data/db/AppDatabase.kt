package com.vuztask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vuztask.data.model.AuthDataConverter
import com.vuztask.data.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(AuthDataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queryDao(): QueryDao
}