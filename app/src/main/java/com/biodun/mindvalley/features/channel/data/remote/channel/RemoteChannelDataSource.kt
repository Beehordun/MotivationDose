package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import io.reactivex.rxjava3.core.Single

interface RemoteChannelDataSource {
    fun getChannelData(): Single<List<ChannelModel>>
}
