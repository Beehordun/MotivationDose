package com.biodun.mindvalley.features.channel.data.remote.model.channel

import com.google.gson.annotations.SerializedName

data class RemoteChannelIconAsset(
    @SerializedName("thumbnailUrl")
    val channelIconUrl: String?
)
