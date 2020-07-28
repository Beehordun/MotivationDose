package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelDomainModel
import javax.inject.Inject

class ChannelDomainModelMapper @Inject constructor(
    private val channelSeriesDomainModelMapper: ChannelSeriesDomainModelMapper,
    private val channelLatestMediaDomainModelMapper: ChannelLatestMediaDomainModelMapper
) {

    fun mapToDomain(channels: List<ChannelModel>): List<ChannelDomainModel> =
        channels.map {
            ChannelDomainModel(
                channelTitle = it.channelTitle,
                channelMediaCount = it.channelMediaCount,
                channelCoverAssetUrl = it.channelCoverAssetUrl,
                channelIconAssetUrl = it.channelIconAssetUrl,
                channelSeries = channelSeriesDomainModelMapper.mapToDomain(it.channelSeries),
                channelLatestMedia =
                channelLatestMediaDomainModelMapper.mapToDomain(it.channelLatestMedia)
            )
        }
}
