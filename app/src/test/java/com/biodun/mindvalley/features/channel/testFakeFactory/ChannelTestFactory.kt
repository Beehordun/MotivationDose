package com.biodun.mindvalley.features.channel.testFakeFactory

import com.biodun.mindvalley.core.DEFAULT_INT
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannel
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelIconAsset
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelLatestMedia
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelSeries
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelCoverAsset
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelData
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannels
import java.util.UUID

object ChannelTestFactory {

    private const val channelMediaCount = DEFAULT_INT
    private val channelTitle = UUID.randomUUID().toString()
    private val seriesTitle = UUID.randomUUID().toString()
    private val channelCoverAssetUrl = UUID.randomUUID().toString()
    private val channelLatestMediaType = UUID.randomUUID().toString()
    private val channelLatestMediaTitle = UUID.randomUUID().toString()
    private val channelIconUrl = UUID.randomUUID().toString()

    fun getRemoteChannel(): RemoteChannel {
        return RemoteChannel(getRemoteChannelData())
    }

    fun getChannelModel(): List<ChannelModel> =
        listOf(
            ChannelModel(
                channelTitle = channelTitle,
                channelMediaCount = channelMediaCount,
                channelCoverAssetUrl = channelCoverAssetUrl,
                channelIconAssetUrl = channelIconUrl,
                channelSeries = getChannelSeriesModel(),
                channelLatestMedia = getChannelLatestMediaModel()
            )
        )

    fun getRemoteChannelWithNullData(): RemoteChannel = RemoteChannel(null)

    private fun getRemoteChannelData(): RemoteChannelData {
        return RemoteChannelData(getRemoteChannels())
    }

    private fun getRemoteChannels(): List<RemoteChannels> =
        listOf(
            RemoteChannels(
                channelTitle = channelTitle,
                channelMediaCount = channelMediaCount,
                channelSeries = getRemoteChannelSeries(),
                remoteChannelLatestMedia = getRemoteChannelLatestMedia(),
                remoteChannelCoverAsset = getRemoteChannelCoverAsset(),
                remoteChannelIconAsset = getChannelIconAsset()
            )
        )

    private fun getChannelIconAsset(): RemoteChannelIconAsset =
        RemoteChannelIconAsset(
            channelIconUrl = channelIconUrl
        )

    fun getRemoteChannelLatestMedia(): List<RemoteChannelLatestMedia> =
        listOf(
            RemoteChannelLatestMedia(
                channelLatestMediaType = channelLatestMediaType,
                channelLatestMediaTitle = channelLatestMediaTitle,
                remoteChannelLatestMediaCoverAsset = getRemoteChannelCoverAsset()
            )
        )

    fun getChannelLatestMediaModel(): List<ChannelLatestMediaModel> =
        listOf(
            ChannelLatestMediaModel(
                channelType = channelLatestMediaType,
                channelTitle = channelLatestMediaTitle,
                channelCoverAssetUrl = channelCoverAssetUrl
            )
        )

    fun getRemoteChannelSeries(): List<RemoteChannelSeries> =
        listOf(
            RemoteChannelSeries(
                seriesTitle = seriesTitle,
                seriesCoverAssetRemote = getRemoteChannelCoverAsset()
            )
        )

    fun getChannelSeriesModel(): List<ChannelSeriesModel> =
        listOf(
            ChannelSeriesModel(
                seriesTitle = seriesTitle,
                seriesTitleCoverAssetUrl = channelCoverAssetUrl
            )
        )

    private fun getRemoteChannelCoverAsset(): RemoteChannelCoverAsset {
        return RemoteChannelCoverAsset(channelCoverAssetUrl = channelCoverAssetUrl)
    }
}
