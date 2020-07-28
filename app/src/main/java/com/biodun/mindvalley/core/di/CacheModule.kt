package com.biodun.mindvalley.core.di

import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindCachedChannelDataSource(
        cacheChannelDataSourceImpl: CachedChannelDataSourceImpl
    ): CachedChannelDataSource

    @Binds
    abstract fun bindCachedCategoryDataSource(
        cachedCategoryDataSourceImpl: CachedCategoryDataSourceImpl
    ): CachedCategoryDataSource

    @Binds
    abstract fun bindCachedEpisodeDataSource(
        cachedEpisodeDataSourceImpl: CachedEpisodeDataSourceImpl
    ): CachedEpisodeDataSource
}
