package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import javax.inject.Inject

class ChannelMapper @Inject constructor(
    private val channelSeriesMapper: ChannelSeriesMapper,
    private val channelLatestMediaMapper: ChannelLatestMediaMapper
) {

    fun mapToDomain(channels: List<ChannelModel>): List<ChannelData> =
        channels.map {
            ChannelData(
                channelTitle = it.channelTitle,
                channelMediaCount = it.channelMediaCount,
                channelCoverAssetUrl = it.channelCoverAssetUrl,
                channelIconAssetUrl = it.channelIconAssetUrl,
                channelSeries = channelSeriesMapper.mapToDomain(it.channelSeries),
                channelLatestMedia =
                channelLatestMediaMapper.mapToDomain(it.channelLatestMedia)
            )
        }
}
