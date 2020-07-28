package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.domain.model.EpisodeDomainModel
import javax.inject.Inject

class EpisodeDomainModelMapper @Inject constructor() {

    fun mapToDomain(episodes: List<EpisodeModel>): List<EpisodeDomainModel> =
        episodes.map {
            EpisodeDomainModel(
                episodeType = it.episodeType,
                episodeTitle = it.episodeTitle,
                episodeCoverAssetUrl = it.episodeCoverAssetUrl,
                episodeChannelTitle = it.episodeChannelTitle
            )
        }
}
