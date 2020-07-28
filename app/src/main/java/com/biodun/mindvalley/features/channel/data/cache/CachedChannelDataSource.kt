package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import io.reactivex.Single

interface CachedChannelDataSource {

    fun getChannelData(): Single<List<ChannelModel>>
    fun insertChannelData(channels: List<ChannelModel>)
    fun deleteAllChannelData()
}
