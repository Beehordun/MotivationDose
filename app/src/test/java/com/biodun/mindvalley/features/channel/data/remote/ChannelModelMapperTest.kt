package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelLatestMediaMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelModelMapper
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelSeriesMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChannelModelMapperTest {

    lateinit var channelModelMapper: ChannelModelMapper
    lateinit var channelSeriesMapper: ChannelSeriesMapper
    lateinit var channelLatestMediaMapper: ChannelLatestMediaMapper

    @Before
    fun setup() {
        channelSeriesMapper = ChannelSeriesMapper()
        channelLatestMediaMapper = ChannelLatestMediaMapper()
        channelModelMapper = ChannelModelMapper(channelSeriesMapper, channelLatestMediaMapper)
    }

    @Test
    fun mapFromRemoteChannel_returnsChannelModelList() {
        val remoteChannel = ChannelTestFactory.getRemoteChannel()
        val expectedChannelModel = ChannelTestFactory.getChannelModel()

        val actualChannelModel = channelModelMapper.mapFromRemoteChannel(remoteChannel)
        Assert.assertEquals(expectedChannelModel, actualChannelModel)
    }

    @Test
    fun mapFromRemoteChannel_returnsEmptyList_whenRemoteChannelDataIsNull() {
        val remoteChannelWithNullData = ChannelTestFactory.getRemoteChannelWithNullData()

        val returnedChannelModel =
            channelModelMapper.mapFromRemoteChannel(remoteChannelWithNullData)

        Assert.assertEquals(0, returnedChannelModel.size)
    }
}
