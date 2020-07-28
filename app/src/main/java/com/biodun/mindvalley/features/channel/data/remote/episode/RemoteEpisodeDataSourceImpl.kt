package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.mapper.EpisodeModelMapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteEpisodeDataSourceImpl @Inject constructor(
    private val channelApi: ChannelApi,
    private val episodeModelMapper: EpisodeModelMapper
) : RemoteEpisodeDataSource {

    override fun getEpisodeData(): Single<List<EpisodeModel>> =
        channelApi.getEpisode().map {
            episodeModelMapper.mapFromRemoteEpisode(it)
        }
}
