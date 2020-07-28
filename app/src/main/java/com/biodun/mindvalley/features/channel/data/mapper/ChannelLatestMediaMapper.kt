package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelLatestMedia
import javax.inject.Inject

class ChannelLatestMediaMapper @Inject constructor() {

    fun mapToDomain(
        channelLatestMedia: List<ChannelLatestMediaModel>
    ): List<ChannelLatestMedia> =
        channelLatestMedia.map {
            ChannelLatestMedia(
                channelType = it.channelType,
                channelTitle = it.channelTitle,
                channelCoverAssetUrl = it.channelCoverAssetUrl
            )
        }
}
