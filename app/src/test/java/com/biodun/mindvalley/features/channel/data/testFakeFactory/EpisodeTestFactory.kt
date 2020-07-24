package com.biodun.mindvalley.features.channel.data.testFakeFactory

import com.biodun.mindvalley.core.Constants.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeData
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeMedia
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeChannel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeCoverAsset
import java.util.UUID

object EpisodeTestFactory {

    private val episodeCoverAssetUrl = UUID.randomUUID().toString()
    private val episodeChannelTitle = UUID.randomUUID().toString()
    private val episodeTitle = UUID.randomUUID().toString()
    private val episodeType = UUID.randomUUID().toString()

    fun getRemoteEpisode(): RemoteEpisode {
        return RemoteEpisode(getRemoteEpisodeData())
    }

    fun getEpisodeModel(): List<EpisodeModel> {
        val episodeModels: MutableList<EpisodeModel> = mutableListOf()
        return getRemoteEpisodeMedia()
            .map {
            EpisodeModel(
                episodeType = it.episodeType ?: EMPTY_STRING,
                episodeTitle = it.episodeTitle ?: EMPTY_STRING,
                episodeCoverAssetUrl = it.remoteEpisodeCoverAsset?.episodeCoverAssetUrl ?: EMPTY_STRING,
                episodeChannelTitle = it.remoteEpisodeChannel?.episodeTitle ?: EMPTY_STRING
            )
        }
    }

    fun getRemoteEpisodeWithNullData(): RemoteEpisode {
        return RemoteEpisode(null)
    }

    fun getRemoteCategoryWithNullMedia(): RemoteEpisode {
        val remoteEpisodeData = RemoteEpisodeData(null)
        return RemoteEpisode(remoteEpisodeData)
    }

    private fun getRemoteEpisodeData(): RemoteEpisodeData {
        return RemoteEpisodeData(getRemoteEpisodeMedia())
    }

    private fun getRemoteEpisodeMedia(): List<RemoteEpisodeMedia> =
        listOf(
            RemoteEpisodeMedia(
                episodeType = episodeType,
                episodeTitle = episodeTitle,
                remoteEpisodeCoverAsset = getRemoteEpisodeCoverAsset(),
                remoteEpisodeChannel = getRemoteEpisodeChannel()
            )
        )

    private fun getRemoteEpisodeCoverAsset(): RemoteEpisodeCoverAsset =
         RemoteEpisodeCoverAsset(episodeCoverAssetUrl = episodeCoverAssetUrl)

    private fun getRemoteEpisodeChannel(): RemoteEpisodeChannel =
        RemoteEpisodeChannel(episodeTitle = episodeChannelTitle)
}
