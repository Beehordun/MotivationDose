package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSource
import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.data.mapper.ChannelLatestMediaMapper
import com.biodun.mindvalley.features.channel.data.mapper.ChannelMapper
import com.biodun.mindvalley.features.channel.data.mapper.ChannelSeriesMapper
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSource
import com.biodun.mindvalley.features.channel.domain.repositories.ChannelRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChannelRepositoryTest {

    private lateinit var channelRepository: ChannelRepository
    private val remoteChannelDataSource: RemoteChannelDataSource = mock()
    private val cachedChannelDataSource: CachedChannelDataSource = mock()
    private val channelMapper: ChannelMapper = mock()
    private val networkHandler: NetworkHandler = mock()

    @Before
    fun setUp() {
        channelRepository =
            ChannelRepositoryImpl(
                remoteChannelDataSource, cachedChannelDataSource, channelMapper, networkHandler
            )
    }

    @Test
    fun getChannel_whenConnection_fetchesRemoteChannelData() {
        val channelModelData = FakeCacheTestFactory.getChannelModel()
        val channelSeriesMapper = ChannelSeriesMapper()
        val channelLatestMediaMapper = ChannelLatestMediaMapper()
        val expectedData =
            ChannelMapper(channelSeriesMapper, channelLatestMediaMapper).mapToDomain(
                channelModelData
            )

        whenever(networkHandler.isConnected()).thenReturn(true)
        whenever(remoteChannelDataSource.getChannelData())
            .thenReturn(Single.just(channelModelData))
        whenever(channelMapper.mapToDomain(channelModelData)).thenReturn(expectedData)

        val test = channelRepository.getChannel().test()

        verify(remoteChannelDataSource).getChannelData()
        verify(channelMapper).mapToDomain(channelModelData)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }

    @Test
    fun getChannel_whenNoConnection_getsCachedChannelData() {
        val channelModelData = FakeCacheTestFactory.getChannelModel()
        val channelSeriesMapper = ChannelSeriesMapper()
        val channelLatestMediaMapper = ChannelLatestMediaMapper()
        val expectedData =
            ChannelMapper(channelSeriesMapper, channelLatestMediaMapper).mapToDomain(
                channelModelData
            )

        whenever(networkHandler.isConnected()).thenReturn(false)
        whenever(cachedChannelDataSource.getChannelData())
            .thenReturn(Single.just(channelModelData))
        whenever(channelMapper.mapToDomain(channelModelData)).thenReturn(expectedData)

        val test = channelRepository.getChannel().test()

        verify(cachedChannelDataSource).getChannelData()
        verify(channelMapper).mapToDomain(channelModelData)
        verifyZeroInteractions(remoteChannelDataSource)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }
}
