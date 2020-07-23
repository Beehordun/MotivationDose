package com.biodun.mindvalley.features.channel.data.remote.mapper

import com.biodun.mindvalley.core.Constants.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelLatestMedia
import javax.inject.Inject

class ChannelLatestMediaMapper @Inject constructor() {

    fun mapFromRemoteChannelLatestMedia(
        remoteChannelLatestMedia: List<RemoteChannelLatestMedia>?
    ): List<ChannelLatestMediaModel> {
        return remoteChannelLatestMedia?.map {
            ChannelLatestMediaModel(
                channelType = it.channelLatestMediaType ?: EMPTY_STRING,
                channelTitle = it.channelLatestMediaTitle ?: EMPTY_STRING,
                channelCoverAssetUrl =
                it.remoteChannelLatestMediaCoverAsset?.channelCoverAssetUrl ?: EMPTY_STRING
            )
        } ?: emptyList()
    }
}
