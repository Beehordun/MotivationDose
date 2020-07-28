package com.biodun.mindvalley.features.channel.data.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.biodun.mindvalley.core.ViewState
import com.biodun.mindvalley.core.scheduler.SchedulerWrapper
import com.biodun.mindvalley.features.channel.data.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.EpisodeTestFactory
import com.biodun.mindvalley.features.channel.data.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.domain.usecases.GetCategoryUseCase
import com.biodun.mindvalley.features.channel.domain.usecases.GetChannelUseCase
import com.biodun.mindvalley.features.channel.domain.usecases.GetEpisodeUseCase
import com.biodun.mindvalley.features.channel.presentation.ChannelViewModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import com.biodun.mindvalley.core.scheduler.TestScheduler as LocalTestScheduler

class ChannelViewModelTest {

    private lateinit var channelViewModel: ChannelViewModel
    private val getChannelUseCase: GetChannelUseCase = mock()
    private val getCategoryUseCase: GetCategoryUseCase = mock()
    private val getEpisodeUseCase: GetEpisodeUseCase = mock()
    private val testScheduler: SchedulerWrapper = LocalTestScheduler()
    private val categoryData = CategoryTestFactory.getCategoryData()
    private val channelData = FakeCacheTestFactory.getChannelData()
    private val episodeData = EpisodeTestFactory.getEpisodeData()

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        channelViewModel = ChannelViewModel(getCategoryUseCase, getChannelUseCase, getEpisodeUseCase, testScheduler)
    }

    @Test
    fun categoryDataLiveData_emitsSuccess_whenRequestSucceeds() {
        val response = Single.just(categoryData)

        whenever(getCategoryUseCase.getCategoryData())
            .thenReturn(response)

        channelViewModel.getCategoryData()

        verify(getCategoryUseCase).getCategoryData()
        Assert.assertTrue(channelViewModel.categoryDataLiveData.value is ViewState.Success)
    }

    @Test
    fun categoryDataLiveData_emitsError_whenRequestFails() {
        val exception = Exception()
        whenever(getCategoryUseCase.getCategoryData())
            .thenReturn(Single.error(exception))

        channelViewModel.getCategoryData()

        verify(getCategoryUseCase).getCategoryData()

        Assert.assertTrue(channelViewModel.categoryDataLiveData.value is ViewState.Error)
    }

    @Test
    fun channelDataLiveData_emitsSuccess_whenRequestSucceeds() {
        val response = Single.just(channelData)

        whenever(getChannelUseCase.getChannelData())
            .thenReturn(response)

        channelViewModel.getChannelData()

        verify(getChannelUseCase).getChannelData()
        Assert.assertTrue(channelViewModel.channelLiveData.value is ViewState.Success)
    }

    @Test
    fun channelDataLiveData_emitsError_whenRequestFails() {
        val exception = Exception()
        whenever(getChannelUseCase.getChannelData())
            .thenReturn(Single.error(exception))

        channelViewModel.getChannelData()

        verify(getChannelUseCase).getChannelData()

        Assert.assertTrue(channelViewModel.channelLiveData.value is ViewState.Error)
    }

    @Test
    fun episodeDataLiveData_emitsSuccess_whenRequestSucceeds() {
        val response = Single.just(episodeData)

        whenever(getEpisodeUseCase.getEpisodeData())
            .thenReturn(response)

        channelViewModel.getEpisodeData()

        verify(getEpisodeUseCase).getEpisodeData()
        Assert.assertTrue(channelViewModel.episodeDataLiveData.value is ViewState.Success)
    }

    @Test
    fun episodeDataLiveData_emitsError_whenRequestFails() {
        val exception = Exception()
        whenever(getEpisodeUseCase.getEpisodeData())
            .thenReturn(Single.error(exception))

        channelViewModel.getEpisodeData()

        verify(getEpisodeUseCase).getEpisodeData()

        Assert.assertTrue(channelViewModel.episodeDataLiveData.value is ViewState.Error)
    }
}
