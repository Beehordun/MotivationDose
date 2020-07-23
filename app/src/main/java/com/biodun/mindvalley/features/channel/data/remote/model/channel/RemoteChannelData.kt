package com.biodun.mindvalley.features.channel.data.remote.model.channel

import com.google.gson.annotations.SerializedName

data class RemoteChannelData(
    @SerializedName("channels")
    val channels: List<RemoteChannels>?
)
