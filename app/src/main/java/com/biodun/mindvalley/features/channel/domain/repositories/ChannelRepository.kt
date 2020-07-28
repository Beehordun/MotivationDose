package com.biodun.mindvalley.features.channel.domain.repositories

import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import io.reactivex.Single

interface ChannelRepository {
    fun getChannel(): Single<List<ChannelData>>
}
