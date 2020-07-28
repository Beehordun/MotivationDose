package com.biodun.mindvalley.features.channel.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.biodun.mindvalley.core.DELETE_EPISODES_QUERY
import com.biodun.mindvalley.core.GET_EPISODES_QUERY
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import io.reactivex.Single

@Dao
interface EpisodeDao {

    @Insert
    fun insertAllEpisode(channel: List<CachedEpisodeEntity>)

    @Query(GET_EPISODES_QUERY)
    fun getEpisodes(): Single<List<CachedEpisodeEntity>>

    @Query(DELETE_EPISODES_QUERY)
    fun deleteEpisodes()
}
