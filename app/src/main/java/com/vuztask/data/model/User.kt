package com.vuztask.data.model

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val ID: Int?,
    val APIVersion: String?,
    @SerializedName("data")
    val data: AuthData?,
    val isLogin: Int?,
    val lang: String?,
    val message: String?,
    val status: Int?
)