package com.biodun.mindvalley.features.channel.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.biodun.mindvalley.core.BaseViewModel
import com.biodun.mindvalley.core.ViewState
import com.biodun.mindvalley.core.scheduler.SchedulerWrapper
import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import com.biodun.mindvalley.features.channel.domain.usecases.GetCategoryUseCase
import com.biodun.mindvalley.features.channel.domain.usecases.GetChannelUseCase
import com.biodun.mindvalley.features.channel.domain.usecases.GetEpisodeUseCase

class ChannelViewModel @ViewModelInject constructor(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getChannelUseCase: GetChannelUseCase,
    private val getEpisodeUseCase: GetEpisodeUseCase,
    private val appScheduler: SchedulerWrapper
) : BaseViewModel() {

    var hasFetchedData = false

    private var _categoryLiveData = MutableLiveData<ViewState<List<CategoryData>>>()
    var categoryDataLiveData: LiveData<ViewState<List<CategoryData>>> = _categoryLiveData

    private var _channelLiveData = MutableLiveData<ViewState<List<ChannelData>>>()
    var channelLiveData: LiveData<ViewState<List<ChannelData>>> = _channelLiveData

    private var _episodeLiveData = MutableLiveData<ViewState<List<EpisodeData>>>()
    var episodeDataLiveData: LiveData<ViewState<List<EpisodeData>>> = _episodeLiveData

   /* init {
        getChannelData()
        getEpisodeData()
        getCategoryData()
    }*/

    fun getCategoryData() {
        addDisposable(
            getCategoryUseCase.getCategoryData()
                .doOnSubscribe { _categoryLiveData.postValue(ViewState.Loading()) }
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribe(
                    {
                        _categoryLiveData.postValue(ViewState.Success(it))
                    },
                    {
                        _categoryLiveData.postValue(ViewState.Error())
                    }
                )
        )
    }

    fun getChannelData() {
        addDisposable(
            getChannelUseCase.getChannelData()
                .doOnSubscribe { _channelLiveData.postValue(ViewState.Loading()) }
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribe(
                    {
                        _channelLiveData.postValue(ViewState.Success(it))
                    },
                    {
                        _channelLiveData.postValue(ViewState.Error())
                    }
                )
        )
    }

    fun getEpisodeData() {
        addDisposable(
            getEpisodeUseCase.getEpisodeData()
                .doOnSubscribe { _episodeLiveData.postValue(ViewState.Loading()) }
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribe(
                    {
                        _episodeLiveData.postValue(ViewState.Success(it))
                    },
                    {
                        _episodeLiveData.postValue(ViewState.Error())
                    }
                )
        )
    }
}
