package com.biodun.mindvalley.features.channel.domain.usecases

import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import com.biodun.mindvalley.features.channel.domain.repositories.ChannelRepository
import io.reactivex.Single
import javax.inject.Inject

class GetChannelUseCase @Inject constructor(
    private val channelRepository: ChannelRepository
) {

    fun getChannelData(): Single<List<ChannelData>> =
        channelRepository.getChannel()
}
