package com.biodun.mindvalley.features.channel.data.remote.model.episode

import com.google.gson.annotations.SerializedName

data class RemoteEpisodeMedia(
    @SerializedName("type")
    val episodeType: String?,
    @SerializedName("title")
    val episodeTitle: String?,
    @SerializedName("coverAsset")
    val remoteEpisodeCoverAsset: RemoteEpisodeCoverAsset?,
    @SerializedName("channel")
    val remoteEpisodeChannel: RemoteEpisodeChannel?
)
