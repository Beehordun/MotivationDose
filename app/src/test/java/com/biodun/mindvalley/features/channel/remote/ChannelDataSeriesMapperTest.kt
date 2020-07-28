package com.biodun.mindvalley.features.channel.remote

import com.biodun.mindvalley.features.channel.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelSeriesMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChannelDataSeriesMapperTest {

    lateinit var channelSeriesMapper: ChannelSeriesMapper

    @Before
    fun setup() {
        channelSeriesMapper = ChannelSeriesMapper()
    }

    @Test
    fun mapFromRemoteChannelSeries_returnsChannelSeriesModelList() {
        val remoteChannelSeries = ChannelTestFactory.getRemoteChannelSeries()
        val expectedChannelSeriesModel = ChannelTestFactory.getChannelSeriesModel()

        val actualChannelSeriesModel = channelSeriesMapper.mapFromRemoteChannelSeries(remoteChannelSeries)
        Assert.assertEquals(expectedChannelSeriesModel, actualChannelSeriesModel)
    }

    @Test
    fun mapFromRemoteChannelSeries_returnsEmptyList_whenRemoteChannelSeriesIsNull() {

        val returnedChannelSeriesModel =
            channelSeriesMapper.mapFromRemoteChannelSeries(null)

        Assert.assertEquals(0, returnedChannelSeriesModel.size)
    }
}
