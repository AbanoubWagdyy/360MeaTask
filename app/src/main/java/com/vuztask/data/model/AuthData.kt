package com.vuztask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

data class AuthData(
    @ColumnInfo(name = "app_version_android")
    val app_version_android: String,
    @ColumnInfo(name = "app_version_ios")
    val app_version_ios: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "first_name")
    val first_name: String,
    @ColumnInfo(name = "full_name")
    val full_name: String,
    @ColumnInfo(name = "last_name")
    val last_name: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "display_name")
    var display_name: String = "",
    @ColumnInfo(name = "profile_photo")
    var profile_photo: String = "",
    @ColumnInfo(name = "token")
    val token: String,
    @ColumnInfo(name = "Password")
    var Password: String = ""
)