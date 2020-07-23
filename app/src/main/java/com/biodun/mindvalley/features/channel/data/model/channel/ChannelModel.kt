package com.biodun.mindvalley.features.channel.data.model.channel

data class ChannelModel(
    val channelTitle: String,
    val channelMediaCount: Int,
    val channelIconAssetUrl: String,
    val channelCoverAssetUrl: String,
    val channelSeries: List<ChannelSeriesModel>,
    val channelLatestMedia: List<ChannelLatestMediaModel>
)
