package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSource
import com.biodun.mindvalley.features.channel.data.mapper.ChannelMapper
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.remote.channel.RemoteChannelDataSource
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import com.biodun.mindvalley.features.channel.domain.repositories.ChannelRepository
import io.reactivex.Single
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val remoteChannelDataSource: RemoteChannelDataSource,
    private val cachedChannelDataSource: CachedChannelDataSource,
    private val channelMapper: ChannelMapper,
    private val networkHandler: NetworkHandler
) : ChannelRepository {

    override fun getChannel(): Single<List<ChannelData>> {
        return if (networkHandler.isConnected()) {
            remoteChannelDataSource.getChannelData().map { list ->
                addFetchedChannelDataToDb(list)
                channelMapper.mapToDomain(list)
            }.onErrorResumeNext {
                cachedChannelDataSource.getChannelData().map {
                    channelMapper.mapToDomain(it)
                }
            }
        } else
            cachedChannelDataSource.getChannelData().map {
                channelMapper.mapToDomain(it)
            }
    }

    private fun addFetchedChannelDataToDb(data: List<ChannelModel>) {
        cachedChannelDataSource.deleteAllChannelData()
        cachedChannelDataSource.insertChannelData(data)
    }
}
