package com.vuztask.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AuthDataConverter {

    @TypeConverter
    fun fromAuthDataJson(stat: AuthData): String {
        return Gson().toJson(stat)
    }

    @TypeConverter
    fun toAuthDataObject(data: String): AuthData {
        val notesType = object : TypeToken<AuthData>() {}.type
        return Gson().fromJson<AuthData>(data, notesType)
    }
}