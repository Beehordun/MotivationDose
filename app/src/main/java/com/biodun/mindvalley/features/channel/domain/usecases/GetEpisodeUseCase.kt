package com.biodun.mindvalley.features.channel.domain.usecases

import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import com.biodun.mindvalley.features.channel.domain.repositories.EpisodeRepository
import io.reactivex.Single
import javax.inject.Inject

class GetEpisodeUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository
) {
    fun getEpisodeData(): Single<List<EpisodeData>> =
        episodeRepository.getEpisode()
}
