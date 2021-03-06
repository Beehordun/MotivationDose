package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import io.reactivex.Single

interface CachedEpisodeDataSource {
    fun getEpisodeData(): Single<List<EpisodeModel>>
    fun insertEpisodeData(episodes: List<EpisodeModel>)
    fun deleteAllEpisodeData()
}
