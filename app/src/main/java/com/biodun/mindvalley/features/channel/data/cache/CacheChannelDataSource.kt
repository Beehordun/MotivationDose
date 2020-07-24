package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import io.reactivex.rxjava3.core.Single

interface CacheChannelDataSource {

    fun getChannelData(): Single<List<ChannelModel>>
    fun insertChannelData(channels: List<ChannelModel>)
    fun deleteAllChannelData()
}
