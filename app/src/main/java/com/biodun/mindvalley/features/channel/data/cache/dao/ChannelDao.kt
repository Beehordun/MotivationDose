package com.biodun.mindvalley.features.channel.data.cache.dao

import androidx.room.Insert
import androidx.room.Query
import com.biodun.mindvalley.core.DbConstants.DELETE_CHANNELS_QUERY
import com.biodun.mindvalley.core.DbConstants.GET_CHANNELS_QUERY
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import io.reactivex.rxjava3.core.Single

interface ChannelDao {

    @Insert
    fun insertAllChannel(channel: List<CachedChannelEntity>)

    @Query(GET_CHANNELS_QUERY)
    fun getChannels(): Single<List<CachedChannelEntity>>

    @Query(DELETE_CHANNELS_QUERY)
    fun deleteChannels()
}
