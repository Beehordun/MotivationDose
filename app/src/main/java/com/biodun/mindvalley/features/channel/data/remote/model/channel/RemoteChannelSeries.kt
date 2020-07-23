package com.biodun.mindvalley.features.channel.data.remote.model.channel

import com.google.gson.annotations.SerializedName

data class RemoteChannelSeries(
    @SerializedName("title")
    val seriesTitle: String?,
    @SerializedName("coverAsset")
    val seriesCoverAssetRemote: RemoteChannelCoverAsset?
)
