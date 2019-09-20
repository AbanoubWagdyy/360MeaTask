package com.vuztask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vuztask.data.model.User

@Dao
interface QueryDao {

    @get:Query("SELECT * FROM User Limit 1")
    val getLoggedInUser: List<User>

    @Insert
    fun insertUser(user: User)

    @Query("DELETE FROM User")
    fun deleteAllUsers()
}