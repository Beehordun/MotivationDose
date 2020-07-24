package com.biodun.mindvalley.features.channel.data.cache.mapper

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelSeriesEntity
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import javax.inject.Inject

class ChannelSeriesMapper @Inject constructor() {

    fun mapFromCached(channelSeries: List<CachedChannelSeriesEntity>): List<ChannelSeriesModel> =
        channelSeries.map {
            ChannelSeriesModel(
                seriesTitle = it.seriesTitle,
                seriesTitleCoverAssetUrl = it.seriesTitleCoverAssetUrl
            )
        }

    fun mapToCached(channelSeries: List<ChannelSeriesModel>): List<CachedChannelSeriesEntity> =
        channelSeries.map {
            CachedChannelSeriesEntity(
                seriesTitle = it.seriesTitle,
                seriesTitleCoverAssetUrl = it.seriesTitleCoverAssetUrl
            )
        }
}
