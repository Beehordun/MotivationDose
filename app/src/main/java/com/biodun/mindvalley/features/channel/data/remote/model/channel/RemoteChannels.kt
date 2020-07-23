package com.biodun.mindvalley.features.channel.data.remote.model.channel

import com.google.gson.annotations.SerializedName

data class RemoteChannels(
    @SerializedName("title")
    val channelTitle: String?,
    @SerializedName("mediaCount")
    val channelMediaCount: Int?,
    @SerializedName("series")
    val channelSeries: List<RemoteChannelSeries>?,
    @SerializedName("latestMedia")
    val remoteChannelLatestMedia: List<RemoteChannelLatestMedia>?,
    @SerializedName("iconAsset")
    val remoteChannelIconAsset: RemoteChannelIconAsset?,
    @SerializedName("coverAsset")
    val remoteChannelCoverAsset: RemoteChannelCoverAsset?
)
