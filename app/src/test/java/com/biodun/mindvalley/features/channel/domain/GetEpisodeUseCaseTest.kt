package com.biodun.mindvalley.features.channel.domain

import com.biodun.mindvalley.features.channel.testFakeFactory.EpisodeTestFactory
import com.biodun.mindvalley.features.channel.domain.repositories.EpisodeRepository
import com.biodun.mindvalley.features.channel.domain.usecases.GetEpisodeUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetEpisodeUseCaseTest {
    private lateinit var episodeUseCase: GetEpisodeUseCase
    private val episodeRepository: EpisodeRepository = mock()
    private val episodeData = EpisodeTestFactory.getEpisodeData()

    @Before
    fun setUp() {
        episodeUseCase = GetEpisodeUseCase(episodeRepository)
    }

    @Test
    fun getEpisodeData_returnsEpisodeData() {
        whenever(episodeRepository.getEpisode())
            .thenReturn(Single.just(episodeData))

        val test = episodeUseCase.getEpisodeData().test()

        verify(episodeRepository).getEpisode()

        test.run {
            assertNoErrors()
            assertComplete()
            assertValueCount(1)
            val response = test.values()[0]
            Assert.assertNotNull(response)
            Assert.assertEquals(response, episodeData)
            dispose()
        }
    }
}
