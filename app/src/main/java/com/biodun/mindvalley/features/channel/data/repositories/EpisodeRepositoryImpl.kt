package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.mapper.EpisodeMapper
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSource
import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import com.biodun.mindvalley.features.channel.domain.repositories.EpisodeRepository
import io.reactivex.Single
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource,
    private val cachedEpisodeDataSource: CachedEpisodeDataSource,
    private val episodeMapper: EpisodeMapper,
    private val networkHandler: NetworkHandler
) : EpisodeRepository {

    override fun getEpisode(): Single<List<EpisodeData>> {
        return if (networkHandler.isConnected()) {
            remoteEpisodeDataSource.getEpisodeData().map { list ->
                addFetchedEpisodeDataToDb(list)
                episodeMapper.mapToDomain(list)
            }.onErrorResumeNext {
                cachedEpisodeDataSource.getEpisodeData().map {
                    episodeMapper.mapToDomain(it)
                }
            }
        } else
            cachedEpisodeDataSource.getEpisodeData().map {
                episodeMapper.mapToDomain(it)
            }
    }

    private fun addFetchedEpisodeDataToDb(data: List<EpisodeModel>) {
        cachedEpisodeDataSource.deleteAllEpisodeData()
        cachedEpisodeDataSource.insertEpisodeData(data)
    }
}
