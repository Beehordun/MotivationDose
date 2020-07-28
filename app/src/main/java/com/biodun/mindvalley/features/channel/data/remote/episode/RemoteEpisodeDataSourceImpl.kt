package com.biodun.mindvalley.features.channel.data.remote.episode

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.mapper.EpisodeModelMapper
import io.reactivex.Single
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
