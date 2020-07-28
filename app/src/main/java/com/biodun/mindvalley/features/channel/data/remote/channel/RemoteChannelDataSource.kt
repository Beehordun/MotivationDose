package com.biodun.mindvalley.features.channel.data.remote.channel

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import io.reactivex.Single

interface RemoteChannelDataSource {
    fun getChannelData(): Single<List<ChannelModel>>
}
