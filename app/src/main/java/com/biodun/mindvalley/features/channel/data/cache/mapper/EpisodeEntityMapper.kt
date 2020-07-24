package com.biodun.mindvalley.features.channel.data.cache.mapper

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import javax.inject.Inject

class EpisodeEntityMapper @Inject constructor() {

    fun fromCached(episodes: List<CachedEpisodeEntity>): List<EpisodeModel> =
        episodes.map {
            EpisodeModel(
                episodeType = it.episodeType,
                episodeTitle = it.episodeTitle,
                episodeCoverAssetUrl = it.episodeCoverAssetUrl,
                episodeChannelTitle = it.episodeChannelTitle
            )
        }

    fun toCached(episodes: List<EpisodeModel>): List<CachedEpisodeEntity> =
        episodes.map {
            CachedEpisodeEntity(
                episodeType = it.episodeType,
                episodeTitle = it.episodeTitle,
                episodeChannelTitle = it.episodeChannelTitle,
                episodeCoverAssetUrl = it.episodeCoverAssetUrl
            )
        }
}
