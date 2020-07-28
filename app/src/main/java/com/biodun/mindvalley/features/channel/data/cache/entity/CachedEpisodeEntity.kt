package com.biodun.mindvalley.features.channel.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.biodun.mindvalley.core.EPISODE_TABLE

@Entity(tableName = EPISODE_TABLE)
data class CachedEpisodeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val episodeType: String,
    val episodeTitle: String,
    val episodeCoverAssetUrl: String,
    val episodeChannelTitle: String
)
