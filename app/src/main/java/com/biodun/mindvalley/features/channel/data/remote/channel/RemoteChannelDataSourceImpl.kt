package com.biodun.mindvalley.features.channel.data.remote.channel

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelModelMapper
import io.reactivex.Single
import javax.inject.Inject

class RemoteChannelDataSourceImpl @Inject constructor(
    private val channelApi: ChannelApi,
    private val channelModelMapper: ChannelModelMapper
) : RemoteChannelDataSource {

    override fun getChannelData(): Single<List<ChannelModel>> =
        channelApi.getChannel().map {
            channelModelMapper.mapFromRemoteChannel(it)
        }
}
