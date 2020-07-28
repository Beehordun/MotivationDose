package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.mapper.EpisodeEntityMapper
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import io.reactivex.Single
import javax.inject.Inject

class CachedEpisodeDataSourceImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val episodeEntityMapper: EpisodeEntityMapper
) : CachedEpisodeDataSource {

    override fun getEpisodeData(): Single<List<EpisodeModel>> =
        appDatabase.episodeDao().getEpisodes().map {
            episodeEntityMapper.fromCached(it)
        }

    override fun insertEpisodeData(episodes: List<EpisodeModel>) =
        appDatabase.episodeDao().insertAllEpisode(episodeEntityMapper.toCached(episodes))

    override fun deleteAllEpisodeData() {
        appDatabase.episodeDao().deleteEpisodes()
    }
}
