package com.biodun.mindvalley.features.channel.data.testFakeFactory

import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategory
import com.biodun.mindvalley.features.channel.data.remote.model.channel.RemoteChannel
import com.biodun.mindvalley.features.channel.data.remote.model.episode.RemoteEpisode
import com.biodun.mindvalley.features.channel.data.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.EpisodeTestFactory
import io.reactivex.rxjava3.core.Single

class TestChannelApi : ChannelApi {

    override fun getEpisode(): Single<RemoteEpisode> =
        Single.just(EpisodeTestFactory.getRemoteEpisode())

    override fun getChannel(): Single<RemoteChannel> =
        Single.just(ChannelTestFactory.getRemoteChannel())


    override fun getCategory(): Single<RemoteCategory> =
        Single.just(CategoryTestFactory.getRemoteCategory())
}
