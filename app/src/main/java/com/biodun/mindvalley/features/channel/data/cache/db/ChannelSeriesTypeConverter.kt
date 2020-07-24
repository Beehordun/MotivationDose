package com.biodun.mindvalley.features.channel.data.cache.db

import androidx.room.TypeConverter
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelSeriesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.Collections

class ChannelSeriesTypeConverter {

    private val gson =
        GsonWrapper.getGson()

    @TypeConverter
    fun fromChannelSeriesToString(data: List<CachedChannelSeriesEntity>): String =
        gson.toJson(data)

    @TypeConverter
    fun stringToChannelSeries(data: String?): List<CachedChannelSeriesEntity> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType: Type = object : TypeToken<List<CachedChannelSeriesEntity>>() {}.type
        return gson.fromJson(data, listType)
    }

    companion object {
        object GsonWrapper {
            fun getGson() = Gson()
        }
    }
}