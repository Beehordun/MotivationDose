package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategory
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import io.reactivex.Single
import retrofit2.http.GET

interface ChannelApi {

    @GET("raw/z5AExTtw")
    fun getEpisode(): Single<RemoteEpisode>

    @GET("raw/Xt12uVhM")
    fun getChannel(): Single<RemoteChannel>

    @GET("raw/A0CgArX3")
    fun getCategory(): Single<RemoteCategory>
}
