package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSourceImpl
import com.biodun.mindvalley.features.channel.data.remote.mapper.EpisodeModelMapper
import com.biodun.mindvalley.features.channel.data.testFakeFactory.EpisodeTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.TestChannelApi
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemoteEpisodeDataDataSourceTest {

    lateinit var remoteEpisodeDataSourceImpl: RemoteEpisodeDataSource
    lateinit var episodeModelMapper: EpisodeModelMapper
    lateinit var channelApi: ChannelApi

    @Before
    fun setup() {
        channelApi =
            TestChannelApi()
        episodeModelMapper = EpisodeModelMapper()
        remoteEpisodeDataSourceImpl =
            RemoteEpisodeDataSourceImpl(
                channelApi,
                episodeModelMapper
            )
    }

    @Test
    fun getEpisodeData_returnsSingleEpisodeModelList() {
        val expectedResult = Single.just(EpisodeTestFactory.getEpisodeModel())

        val returnedResult = remoteEpisodeDataSourceImpl.getEpisodeData()

        assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }
}
