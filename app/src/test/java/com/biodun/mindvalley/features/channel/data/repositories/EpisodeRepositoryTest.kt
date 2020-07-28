package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.mapper.EpisodeMapper
import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSource
import com.biodun.mindvalley.features.channel.domain.repositories.EpisodeRepository
import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class EpisodeRepositoryTest {

    private lateinit var episodeRepository: EpisodeRepository
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource = mock()
    private val cachedEpisodeDataSource: CachedEpisodeDataSource = mock()
    private val episodeMapper: EpisodeMapper = mock()
    private val networkHandler: NetworkHandler = mock()

    @Before
    fun setUp() {
        episodeRepository =
            EpisodeRepositoryImpl(
                remoteEpisodeDataSource,
                cachedEpisodeDataSource,
                episodeMapper,
                networkHandler
            )
    }

    @Test
    fun getEpisode_whenConnection_fetchesRemoteEpisodeData() {
        val episodeModelData = FakeCacheTestFactory.getEpisodeModel()
        val expectedData = EpisodeMapper().mapToDomain(episodeModelData)

        whenever(networkHandler.isConnected()).thenReturn(true)
        whenever(remoteEpisodeDataSource.getEpisodeData())
            .thenReturn(Single.just(episodeModelData))
        whenever(episodeMapper.mapToDomain(episodeModelData)).thenReturn(expectedData)

        val test = episodeRepository.getEpisode().test()

        verify(remoteEpisodeDataSource).getEpisodeData()
        verify(episodeMapper).mapToDomain(episodeModelData)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }

    @Test
    fun getEpisode_whenNoConnection_getsCachedEpisodeData() {
        val episodeModelData = FakeCacheTestFactory.getEpisodeModel()
        val expectedData = EpisodeMapper().mapToDomain(episodeModelData)

        whenever(networkHandler.isConnected()).thenReturn(false)
        whenever(cachedEpisodeDataSource.getEpisodeData())
            .thenReturn(Single.just(episodeModelData))
        whenever(episodeMapper.mapToDomain(episodeModelData)).thenReturn(expectedData)

        val test = episodeRepository.getEpisode().test()

        verify(cachedEpisodeDataSource).getEpisodeData()
        verify(episodeMapper).mapToDomain(episodeModelData)
        verifyZeroInteractions(remoteEpisodeDataSource)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }

    @Test
    fun getEpisode_whenConnectionButThrowsError_fetchDataFromDb() {
        val episodeModelData = FakeCacheTestFactory.getEpisodeModel()
        val expectedData = EpisodeMapper().mapToDomain(episodeModelData)

        whenever(networkHandler.isConnected()).thenReturn(true)
        whenever(remoteEpisodeDataSource.getEpisodeData())
            .thenReturn(Single.error(Throwable()))
        whenever(cachedEpisodeDataSource.getEpisodeData())
            .thenReturn(Single.just(episodeModelData))
        whenever(episodeMapper.mapToDomain(episodeModelData)).thenReturn(expectedData)

        val test = episodeRepository.getEpisode().test()

        verify(cachedEpisodeDataSource).getEpisodeData()
        verify(episodeMapper).mapToDomain(episodeModelData)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }
}
