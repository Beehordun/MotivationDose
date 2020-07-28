package com.biodun.mindvalley.features.channel.domain

import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.domain.repositories.ChannelRepository
import com.biodun.mindvalley.features.channel.domain.usecases.GetChannelUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetChannelUseCaseTest {

    private lateinit var channelUseCase: GetChannelUseCase
    private val channelRepository: ChannelRepository = mock()
    private val channelData = FakeCacheTestFactory.getChannelData()

    @Before
    fun setUp() {
        channelUseCase = GetChannelUseCase(channelRepository)
    }

    @Test
    fun getChannelData_returnsChannelData() {
        whenever(channelRepository.getChannel())
            .thenReturn(Single.just(channelData))

        val test = channelUseCase.getChannelData().test()

        verify(channelRepository).getChannel()

        test.run {
            assertNoErrors()
            assertComplete()
            assertValueCount(1)
            val response = test.values()[0]
            Assert.assertNotNull(response)
            Assert.assertEquals(response, channelData)
            dispose()
        }
    }
}
