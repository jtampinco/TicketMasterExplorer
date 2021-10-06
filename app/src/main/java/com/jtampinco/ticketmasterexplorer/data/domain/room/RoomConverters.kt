package com.jtampinco.ticketmasterexplorer.data.domain.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jtampinco.ticketmasterexplorer.data.domain.model.Attraction
import com.jtampinco.ticketmasterexplorer.data.domain.model.Venue

class RoomConverters {

    @TypeConverter
    fun priceRangeToString(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToPriceRanges(value: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun attractionToString(value: List<Attraction>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToAttractions(value: String): List<Attraction> {
        val type = object : TypeToken<List<Attraction>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun venuesToString(value: List<Venue>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToVenues(value: String): List<Venue> {
        val type = object : TypeToken<List<Venue>>() {}.type
        return Gson().fromJson(value, type)
    }

}