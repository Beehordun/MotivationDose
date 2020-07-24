package com.biodun.mindvalley.features.channel.data.cache.mapper

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import javax.inject.Inject

class ChannelEntityMapper @Inject constructor(
    private val channelSeriesMapper: ChannelSeriesMapper,
    private val channelLatestMediaMapper: ChannelLatestMediaMapper
) {

    fun fromCached(channels: List<CachedChannelEntity>): List<ChannelModel> =
        channels.map {
            ChannelModel(
                channelTitle = it.channelTitle,
                channelMediaCount = it.channelMediaCount,
                channelIconAssetUrl = it.channelIconAssetUrl,
                channelCoverAssetUrl = it.channelCoverAssetUrl,
                channelSeries = channelSeriesMapper.mapFromCached(it.channelSeries),
                channelLatestMedia = channelLatestMediaMapper.mapFromCached(it.channelLatestMedia)
            )
        }

    fun toCached(channels: List<ChannelModel>): List<CachedChannelEntity> =
        channels.map {
            CachedChannelEntity(
                channelTitle = it.channelTitle,
                channelMediaCount = it.channelMediaCount,
                channelIconAssetUrl = it.channelIconAssetUrl,
                channelCoverAssetUrl = it.channelCoverAssetUrl,
                channelSeries = channelSeriesMapper.mapToCached(it.channelSeries),
                channelLatestMedia = channelLatestMediaMapper.mapToCached(it.channelLatestMedia)
            )
        }
}
