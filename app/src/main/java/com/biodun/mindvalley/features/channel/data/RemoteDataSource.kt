package com.biodun.mindvalley.features.channel.data

import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategoryData
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelData
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisodeData
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getChannelData(): Single<RemoteChannelData>
    fun getCategoryData(): Single<RemoteCategoryData>
    fun getEpisodeData(): Single<RemoteEpisodeData>
}
