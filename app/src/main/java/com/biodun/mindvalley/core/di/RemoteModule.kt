package com.biodun.mindvalley.core.di

import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSource
import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSourceImpl
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSource
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSourceImpl
import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.remote.episode.RemoteEpisodeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindChannelRemoteDataSource(
        remoteChannelDataSourceImpl: RemoteChannelDataSourceImpl
    ): RemoteChannelDataSource

    @Binds
    abstract fun bindCategoryRemoteDataSource(
        remoteCategoryDataSourceImpl: RemoteCategoryDataSourceImpl
    ): RemoteCategoryDataSource

    @Binds
    abstract fun bindEpisodeRemoteDataSource(
        remoteEpisodeDataSourceImpl: RemoteEpisodeDataSourceImpl
    ): RemoteEpisodeDataSource
}
