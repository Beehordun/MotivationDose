package com.biodun.mindvalley.features.channel.data.remote.mapper

import com.biodun.mindvalley.core.Constants.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelSeries
import javax.inject.Inject

class ChannelSeriesMapper @Inject constructor() {

    fun mapFromRemoteChannelSeries(
        remoteChannelSeries: List<RemoteChannelSeries>?
    ): List<ChannelSeriesModel> {
        return remoteChannelSeries?.map {
            ChannelSeriesModel(
                seriesTitle = it.seriesTitle ?: EMPTY_STRING,
                seriesTitleCoverAssetUrl =
                it.seriesCoverAssetRemote?.channelCoverAssetUrl ?: EMPTY_STRING
            )
        } ?: emptyList()
    }
}
