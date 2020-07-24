package com.biodun.mindvalley.features.channel.data.cache.mapper

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelLatestMediaEntity
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import javax.inject.Inject

class ChannelLatestMediaMapper @Inject constructor() {

    fun mapFromCached(
        channelLatestMedia: List<CachedChannelLatestMediaEntity>
    ): List<ChannelLatestMediaModel> =
        channelLatestMedia.map {
            ChannelLatestMediaModel(
                channelTitle = it.channelTitle,
                channelType = it.channelType,
                channelCoverAssetUrl = it.channelCoverAssetUrl
            )
        }

    fun mapToCached(
        channelLatestMedia: List<ChannelLatestMediaModel>
    ): List<CachedChannelLatestMediaEntity> =
        channelLatestMedia.map {
            CachedChannelLatestMediaEntity(
                channelType = it.channelType,
                channelTitle = it.channelTitle,
                channelCoverAssetUrl = it.channelCoverAssetUrl
            )
        }
}
