package com.biodun.mindvalley.features.channel.data.remote.model.channel

import com.google.gson.annotations.SerializedName

data class RemoteChannelLatestMedia(
    @SerializedName("type")
    val channelLatestMediaType: String?,
    @SerializedName("title")
    val channelLatestMediaTitle: String?,
    @SerializedName("coverAsset")
    val remoteChannelLatestMediaCoverAsset: RemoteChannelCoverAsset?
)
