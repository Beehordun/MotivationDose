package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getChannelData(): Single<List<ChannelModel>>
    fun getCategoryData(): Single<List<CategoryModel>>
    fun getEpisodeData(): Single<List<EpisodeModel>>
}
