package com.biodun.mindvalley.features.channel.domain.repositories

import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import io.reactivex.Single

interface EpisodeRepository {
    fun getEpisode(): Single<List<EpisodeData>>
}
