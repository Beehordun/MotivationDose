package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import javax.inject.Inject

class EpisodeMapper @Inject constructor() {

    fun mapToDomain(episodes: List<EpisodeModel>): List<EpisodeData> =
        episodes.map {
            EpisodeData(
                episodeType = it.episodeType,
                episodeTitle = it.episodeTitle,
                episodeCoverAssetUrl = it.episodeCoverAssetUrl,
                episodeChannelTitle = it.episodeChannelTitle
            )
        }
}
