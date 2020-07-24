package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.EpisodeTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.TestChannelApi
import com.biodun.mindvalley.features.channel.data.remote.mapper.*
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest {

    lateinit var remoteDataSourceImpl: RemoteDataSource
    lateinit var channelModelMapper: ChannelModelMapper
    lateinit var channelSeriesMapper: ChannelSeriesMapper
    lateinit var channelLatestMediaMapper: ChannelLatestMediaMapper
    lateinit var episodeModelMapper: EpisodeModelMapper
    lateinit var categoryModelMapper: CategoryModelMapper
    lateinit var channelApi: ChannelApi

    @Before
    fun setup() {
        channelApi =
            TestChannelApi()
        channelSeriesMapper = ChannelSeriesMapper()
        channelLatestMediaMapper = ChannelLatestMediaMapper()
        channelModelMapper = ChannelModelMapper(channelSeriesMapper, channelLatestMediaMapper)
        episodeModelMapper = EpisodeModelMapper()
        categoryModelMapper = CategoryModelMapper()
        remoteDataSourceImpl =
            RemoteDataSourceImpl(
                channelApi,
                channelModelMapper,
                categoryModelMapper,
                episodeModelMapper
            )
    }

    @Test
    fun getChannelData_returnsSingleChannelModelList() {
        val expectedResult = Single.just(ChannelTestFactory.getChannelModel())

        val returnedResult = remoteDataSourceImpl.getChannelData()

        assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }

    @Test
    fun getEpisodeData_returnsSingleEpisodeModelList() {
        val expectedResult = Single.just(EpisodeTestFactory.getEpisodeModel())

        val returnedResult = remoteDataSourceImpl.getEpisodeData()

        assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }

    @Test
    fun getCategoryData_returnsSingleCategoryModelList() {
        val expectedResult = Single.just(CategoryTestFactory.getCategoryModel())

        val returnedResult = remoteDataSourceImpl.getCategoryData()

        assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }
}
