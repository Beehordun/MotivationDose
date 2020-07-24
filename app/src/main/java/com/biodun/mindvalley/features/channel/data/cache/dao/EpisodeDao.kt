package com.biodun.mindvalley.features.channel.data.cache.dao

import androidx.room.Insert
import androidx.room.Query
import com.biodun.mindvalley.core.DbConstants
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import io.reactivex.rxjava3.core.Single

interface EpisodeDao {

    @Insert
    fun insertAllEpisode(channel: List<CachedEpisodeEntity>)

    @Query(DbConstants.GET_EPISODES_QUERY)
    fun getEpisodes(): Single<List<CachedEpisodeEntity>>

    @Query(DbConstants.DELETE_EPISODES_QUERY)
    fun deleteEpisodes()
}
