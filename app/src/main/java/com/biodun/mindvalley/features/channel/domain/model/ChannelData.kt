package com.biodun.mindvalley.features.channel.domain.model

data class Channel(
    val channelTitle: String,
    val channelMediaCount: Int,
    val channelIconAssetUrl: String,
    val channelCoverAssetUrl: String,
    val channelSeries: List<ChannelSeries>,
    val channelLatestMedia: List<ChannelLatestMedia>
)
