package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.RemoteDataSource
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategoryData
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelData
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeData
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val channelApi: ChannelApi
) : RemoteDataSource {

    override fun getChannelData(): Single<RemoteChannelData> {
        return channelApi.getChannel()
    }

    override fun getCategoryData(): Single<RemoteCategoryData> {
        return channelApi.getCategory()
    }

    override fun getEpisodeData(): Single<RemoteEpisodeData> {
        return channelApi.getEpisode()
    }
}
