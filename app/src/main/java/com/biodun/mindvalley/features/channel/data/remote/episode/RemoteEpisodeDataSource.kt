package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import io.reactivex.rxjava3.core.Single

interface RemoteEpisodeDataSource {
    fun getEpisodeData(): Single<List<EpisodeModel>>
}
