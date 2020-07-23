package com.biodun.mindvalley.features.channel.data.remote.mapper

import com.biodun.mindvalley.core.Constants.DEFAULT_INT
import com.biodun.mindvalley.core.Constants.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannel
import javax.inject.Inject

class ChannelModelMapper @Inject constructor(
    private val channelSeriesMapper: ChannelSeriesMapper,
    private val channelLatestMediaMapper: ChannelLatestMediaMapper
) {

    fun mapFromRemoteChannelData(remoteChannel: RemoteChannel): List<ChannelModel> {
        return remoteChannel.remoteChannelData?.channels?.map {
            ChannelModel(
                channelTitle = it.channelTitle ?: EMPTY_STRING,
                channelMediaCount = it.channelMediaCount ?: DEFAULT_INT,
                channelCoverAssetUrl =
                it.remoteChannelCoverAsset?.channelCoverAssetUrl ?: EMPTY_STRING,
                channelIconAssetUrl =
                it.remoteChannelIconAsset?.channelIconUrl ?: EMPTY_STRING,
                channelSeries = channelSeriesMapper.mapFromRemoteChannelSeries(it.channelSeries),
                channelLatestMedia =
                channelLatestMediaMapper.mapFromRemoteChannelLatestMedia(it.remoteChannelLatestMedia)
            )
        } ?: emptyList()
    }
}
