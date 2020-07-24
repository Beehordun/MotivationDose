package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.testFakeFactory.ChannelTestFactory
import com.biodun.mindvalley.features.channel.data.remote.mapper.ChannelLatestMediaMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChannelLatestMediaMapperTest {

    lateinit var channelLatestMediaMapper: ChannelLatestMediaMapper

    @Before
    fun setup() {
        channelLatestMediaMapper = ChannelLatestMediaMapper()
    }

    @Test
    fun mapFromRemoteChannelLatestMedia_returnsChannelLatestModelList() {
        val remoteChannelLatestMedia = ChannelTestFactory.getRemoteChannelLatestMedia()
        val expectedChannelLatestMediaModel = ChannelTestFactory.getChannelLatestMediaModel()

        val actualChannelLatestMediaModel =
            channelLatestMediaMapper.mapFromRemoteChannelLatestMedia(remoteChannelLatestMedia)
        Assert.assertEquals(expectedChannelLatestMediaModel, actualChannelLatestMediaModel)
    }

    @Test
    fun mapFromRemoteChannelLatestMedia_returnsEmptyList_whenRemoteChannelLatestMediaIsNull() {

        val returnedChannelLatestMediaModel =
            channelLatestMediaMapper.mapFromRemoteChannelLatestMedia(null)

        Assert.assertEquals(0, returnedChannelLatestMediaModel.size)
    }
}
