package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelLatestMediaDomainModel
import javax.inject.Inject

class ChannelLatestMediaDomainModelMapper @Inject constructor() {

    fun mapToDomain(
        channelLatestMedia: List<ChannelLatestMediaModel>
    ): List<ChannelLatestMediaDomainModel> =
        channelLatestMedia.map {
            ChannelLatestMediaDomainModel(
               channelType = it.channelType,
                channelTitle = it.channelTitle,
                channelCoverAssetUrl = it.channelCoverAssetUrl
            )
        }
}
