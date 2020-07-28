package com.biodun.mindvalley.features.channel.ui

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.ViewState
import com.biodun.mindvalley.core.displayShimmer
import com.biodun.mindvalley.core.clearShimmer
import com.biodun.mindvalley.core.PULL_TO_REFRESH_DELAY_TIME_MS
import com.biodun.mindvalley.core.idlingresources.EspressoIdlingResource
import com.biodun.mindvalley.core.visible
import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import com.biodun.mindvalley.features.channel.presentation.ChannelViewModel
import com.biodun.mindvalley.features.channel.ui.adapters.CategoryAdapter
import com.biodun.mindvalley.features.channel.ui.adapters.ChannelAdapter
import com.biodun.mindvalley.features.channel.ui.adapters.EpisodeAdapter
import com.biodun.mindvalley.features.channel.ui.adapters.ItemOffsetDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_channel.*

@AndroidEntryPoint
class ChannelActivity : AppCompatActivity() {

    @VisibleForTesting
    val categoryRecyclerViewIdlingResource: EspressoIdlingResource by lazy {
        EspressoIdlingResource("CATEGORY_IDLING_RESOURCE")
    }

    @VisibleForTesting
    val episodeRecyclerViewIdlingResource: EspressoIdlingResource by lazy {
        EspressoIdlingResource("EPISODE_IDLING_RESOURCE")
    }

    @VisibleForTesting
    val channelRecyclerViewIdlingResource: EspressoIdlingResource by lazy {
        EspressoIdlingResource("CHANNEL_IDLING_RESOURCE")
    }

    private val channelViewModel: ChannelViewModel by viewModels()
    private val owner = { lifecycle }

    private lateinit var episodeAdapter: EpisodeAdapter
    private val episodeData: MutableList<EpisodeData> = mutableListOf()

    private lateinit var channelAdapter: ChannelAdapter
    private val channelData: MutableList<ChannelData> = mutableListOf()

    private lateinit var categoryAdapter: CategoryAdapter
    private val categoryData: MutableList<CategoryData> = mutableListOf()

    private var hasLoadedBefore = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)
        incrementIdlingResources()
        setUpView()
    }

    private fun setUpView() {
        if(!channelViewModel.hasFetchedData) {
            getData()
            channelViewModel.hasFetchedData = true
        }

        setSupportActionBar(channelTitle)
        setupPullToRefreshData()
        setupRecyclerview()
        observeChannelLiveData()
        observeCategoryLiveData()
        observeEpisodeLiveData()
    }

    private fun setupPullToRefreshData() {
        pullToRefresh.setOnRefreshListener {
            incrementIdlingResources()
            Handler().postDelayed({
                pullToRefresh.isRefreshing = false
                getData()
            }, PULL_TO_REFRESH_DELAY_TIME_MS)
        }
    }

    private fun getData() {
        with(channelViewModel) {
            getEpisodeData()
            getChannelData()
            getCategoryData()
        }
    }

    private fun setupRecyclerview() {
        episodeAdapter = EpisodeAdapter(episodeData, this)
        episodeRecyclerView.adapter = episodeAdapter

        channelAdapter = ChannelAdapter(channelData, this)

        with(channelRecyclerView) {
            adapter = channelAdapter
            isNestedScrollingEnabled = false
        }

        categoryAdapter = CategoryAdapter(this, categoryData)
        with(categoryRecyclerView) {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@ChannelActivity, 2)
            isNestedScrollingEnabled = false
            val itemDecoration =
                ItemOffsetDecoration(context, R.dimen.category_margin)
            addItemDecoration(itemDecoration)
        }
    }

    private fun observeChannelLiveData() {
        channelViewModel.channelLiveData.observe(owner) { viewState ->
            when (viewState) {
                is ViewState.Loading -> {
                }
                is ViewState.Success -> {
                    channelRecyclerViewIdlingResource.decrement()
                    channelAdapter.updateData(viewState.data)
                }
                is ViewState.Error -> {
                    Toast.makeText(this, "Error loading data", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun observeCategoryLiveData() {
        channelViewModel.categoryDataLiveData.observe(owner) { viewState ->
            when (viewState) {
                is ViewState.Loading -> {
                }
                is ViewState.Success -> {
                    categoryRecyclerViewIdlingResource.decrement()
                    categoryAdapter.updateData(viewState.data)
                    categoryHeader.visible()
                }
                is ViewState.Error -> {
                    Toast.makeText(this, "Error loading data", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun observeEpisodeLiveData() {
        channelViewModel.episodeDataLiveData.observe(owner) { viewState ->
            when (viewState) {
                is ViewState.Loading -> {
                    if (hasLoadedBefore) {
                        loadingEpisodeView.displayShimmer()
                        hasLoadedBefore = true
                    }
                }
                is ViewState.Success -> {
                    episodeRecyclerViewIdlingResource.decrement()
                    episodeAdapter.updateData(viewState.data)
                    loadingEpisodeView.clearShimmer()
                    episodeText.visible()
                    episodeRecyclerViewDivider.visible()
                }
                is ViewState.Error -> {
                    Toast.makeText(this, "Error loading data", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun incrementIdlingResources() {
        categoryRecyclerViewIdlingResource.increment()
        episodeRecyclerViewIdlingResource.increment()
        channelRecyclerViewIdlingResource.increment()
    }
}
