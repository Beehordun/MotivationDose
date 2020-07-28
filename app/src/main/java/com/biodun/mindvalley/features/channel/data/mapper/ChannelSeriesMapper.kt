package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelSeries
import javax.inject.Inject

class ChannelSeriesMapper @Inject constructor() {

    fun mapToDomain(channelSeries: List<ChannelSeriesModel>): List<ChannelSeries> =
        channelSeries.map {
            ChannelSeries(
                seriesTitle = it.seriesTitle,
                seriesTitleCoverAssetUrl = it.seriesTitleCoverAssetUrl
            )
        }
}
