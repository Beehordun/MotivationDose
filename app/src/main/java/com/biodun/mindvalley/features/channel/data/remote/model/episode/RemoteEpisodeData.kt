package com.biodun.mindvalley.features.channel.data.remote.model.episode

import com.google.gson.annotations.SerializedName

data class RemoteEpisodeData(
    @SerializedName("media") val remoteEpisodeMedia: List<RemoteEpisodeMedia>?
)
