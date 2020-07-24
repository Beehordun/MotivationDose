package com.biodun.mindvalley.features.channel.data.cache.db

import androidx.room.TypeConverter
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelLatestMediaEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.Collections

class ChannelLatestMediaTypeConverter {

    private val gson =
        GsonWrapper.getGson()

    @TypeConverter
    fun fromChannelLatestMediaToString(data: List<CachedChannelLatestMediaEntity>): String =
        gson.toJson(data)

    @TypeConverter
    fun stringToChannelLatestMedia(data: String?): List<CachedChannelLatestMediaEntity> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType: Type = object : TypeToken<List<CachedChannelLatestMediaEntity>>() {}.type
        return gson.fromJson(data, listType)
    }

    companion object {
        object GsonWrapper {
            fun getGson() = Gson()
        }
    }
}
