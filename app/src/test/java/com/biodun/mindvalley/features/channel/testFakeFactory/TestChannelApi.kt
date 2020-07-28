package com.biodun.mindvalley.features.channel.testFakeFactory

import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategory
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import io.reactivex.Single

class TestChannelApi : ChannelApi {

    override fun getEpisode(): Single<RemoteEpisode> =
        Single.just(EpisodeTestFactory.getRemoteEpisode())

    override fun getChannel(): Single<RemoteChannel> =
        Single.just(ChannelTestFactory.getRemoteChannel())

    override fun getCategory(): Single<RemoteCategory> =
        Single.just(CategoryTestFactory.getRemoteCategory())
}
