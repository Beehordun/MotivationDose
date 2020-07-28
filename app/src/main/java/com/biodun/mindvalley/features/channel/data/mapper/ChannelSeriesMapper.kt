package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelSeriesDomainModel
import javax.inject.Inject

class ChannelSeriesDomainModelMapper @Inject constructor() {

    fun mapToDomain(channelSeries: List<ChannelSeriesModel>): List<ChannelSeriesDomainModel> =
        channelSeries.map {
            ChannelSeriesDomainModel(
                seriesTitle = it.seriesTitle,
                seriesTitleCoverAssetUrl = it.seriesTitleCoverAssetUrl
            )
        }
}
