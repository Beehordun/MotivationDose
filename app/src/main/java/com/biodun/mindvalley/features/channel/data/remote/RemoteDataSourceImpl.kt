package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.remote.mapper.CategoryModelMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelModelMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.EpisodeModelMapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val channelApi: ChannelApi,
    private val channelModelMapper: ChannelModelMapper,
    private val categoryModelMapper: CategoryModelMapper,
    private val episodeModelMapper: EpisodeModelMapper
) : RemoteDataSource {

    override fun getChannelData(): Single<List<ChannelModel>> =
      channelApi.getChannel().map {
          channelModelMapper.mapFromRemoteChannel(it)
      }

    override fun getCategoryData(): Single<List<CategoryModel>> =
        channelApi.getCategory().map {
            categoryModelMapper.mapFromRemoteCategory(it)
        }


    override fun getEpisodeData(): Single<List<EpisodeModel>> =
        channelApi.getEpisode().map {
            episodeModelMapper.mapFromRemoteEpisode(it)
        }
}
