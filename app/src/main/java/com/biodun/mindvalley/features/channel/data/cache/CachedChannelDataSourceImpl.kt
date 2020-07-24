package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.mapper.ChannelEntityMapper
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CachedChannelDataSourceImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val channelEntityMapper: ChannelEntityMapper
): CacheChannelDataSource {

    override fun getChannelData(): Single<List<ChannelModel>> =
        appDatabase.channelDao().getChannels().map {
            channelEntityMapper.fromCached(it)
        }

    override fun insertChannelData(channels: List<ChannelModel>) =
        appDatabase.channelDao().insertAllChannel(channelEntityMapper.toCached(channels))

    override fun deleteAllChannelData() {
        appDatabase.channelDao().deleteChannels()
    }
}
