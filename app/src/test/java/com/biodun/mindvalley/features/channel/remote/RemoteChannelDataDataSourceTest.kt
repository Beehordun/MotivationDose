package com.biodun.mindvalley.features.channel.remote

import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSource
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSourceImpl
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelLatestMediaMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelModelMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelSeriesMapper
import com.biodun.mindvalley.features.channel.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.testFakeFactory.TestChannelApi
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemoteChannelDataDataSourceTest {

    lateinit var remoteChannelDataSourceImpl: RemoteChannelDataSource
    lateinit var channelModelMapper: ChannelModelMapper
    lateinit var channelSeriesMapper: ChannelSeriesMapper
    lateinit var channelLatestMediaMapper: ChannelLatestMediaMapper
    lateinit var channelApi: ChannelApi

    @Before
    fun setup() {
        channelApi =
            TestChannelApi()
        channelSeriesMapper = ChannelSeriesMapper()
        channelLatestMediaMapper = ChannelLatestMediaMapper()
        channelModelMapper = ChannelModelMapper(channelSeriesMapper, channelLatestMediaMapper)

        remoteChannelDataSourceImpl =
            RemoteChannelDataSourceImpl(
                channelApi,
                channelModelMapper
            )
    }

    @Test
    fun getChannelData_returnsSingleChannelModelList() {
        val expectedResult = Single.just(ChannelTestFactory.getChannelModel())

        val returnedResult = remoteChannelDataSourceImpl.getChannelData()

        Assert.assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }
}
