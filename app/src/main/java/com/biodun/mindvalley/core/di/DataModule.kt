package com.biodun.mindvalley.core.di

import com.biodun.mindvalley.features.channel.data.repositories.CategoryRepositoryImpl
import com.biodun.mindvalley.features.channel.data.repositories.ChannelRepositoryImpl
import com.biodun.mindvalley.features.channel.data.repositories.EpisodeRepositoryImpl
import com.biodun.mindvalley.features.channel.domain.repositories.CategoryRepository
import com.biodun.mindvalley.features.channel.domain.repositories.ChannelRepository
import com.biodun.mindvalley.features.channel.domain.repositories.EpisodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    abstract fun bindEpisodeRepository(
        episodeRepositoryImpl: EpisodeRepositoryImpl
    ): EpisodeRepository

    @Binds
    abstract fun bindChannelRepository(
        channelRepositoryImpl: ChannelRepositoryImpl
    ): ChannelRepository
}
