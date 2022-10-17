package com.logical.cryptocurrencyinfo.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.logical.cryptocurrencyinfo.data.remote.dto.TeamMember
import java.lang.reflect.Type
import java.util.*

class CoinsTypeConverter {

    private val gson = Gson()

   /* @TypeConverter
    fun responseToString(response: CoinDetail): String =
        gson.toJson(response)

    @TypeConverter
    fun stringToResponse(data: String): CoinDetail {
        val listType = object : TypeToken<CoinDetail>() {}.type
        return gson.fromJson(data, listType)
    }
*/

    @TypeConverter
    fun fromString(value: String?): List<String?>? {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list:List<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }


    @TypeConverter
    fun fromCountryLangList(countryLang: List<TeamMember?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<TeamMember?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<TeamMember>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<TeamMember?>?>() {}.type
        return gson.fromJson<List<TeamMember>>(countryLangString, type)
    }


}