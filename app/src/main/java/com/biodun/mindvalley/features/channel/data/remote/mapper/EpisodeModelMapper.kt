package com.biodun.mindvalley.features.channel.data.remote.mapper

import com.biodun.mindvalley.core.Constants.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import javax.inject.Inject

class EpisodeModelMapper @Inject constructor() {

    fun mapFromRemoteEpisode(remoteEpisodeModel: RemoteEpisode): List<EpisodeModel> {
        return remoteEpisodeModel.episodeData?.remoteEpisodeMedia?.map {
            EpisodeModel(
                episodeType = it.episodeType ?: EMPTY_STRING,
                episodeTitle = it.episodeTitle ?: EMPTY_STRING,
                episodeCoverAssetUrl =
                it.remoteEpisodeCoverAsset?.episodeCoverAssetUrl ?: EMPTY_STRING,
                episodeChannelTitle =
                it.remoteEpisodeChannel?.episodeTitle ?: EMPTY_STRING
            )
        } ?: emptyList()
    }
}
