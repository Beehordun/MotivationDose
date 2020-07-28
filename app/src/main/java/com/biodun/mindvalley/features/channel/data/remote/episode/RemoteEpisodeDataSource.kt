package com.biodun.mindvalley.features.channel.data.remote.episode

import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import io.reactivex.Single

interface RemoteEpisodeDataSource {
    fun getEpisodeData(): Single<List<EpisodeModel>>
}
