package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategoryData
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannelData
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ChannelApi {

    @GET("/raw/z5AExTtw")
    fun getEpisode(): Single<RemoteEpisode>

    @GET("/raw/zXt12uVhM")
    fun getChannel(): Single<RemoteChannelData>

    @GET("/raw/A0CgArX3")
    fun getCategory(): Single<RemoteCategoryData>
}
