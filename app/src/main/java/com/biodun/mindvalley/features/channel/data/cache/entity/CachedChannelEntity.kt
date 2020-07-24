package com.biodun.mindvalley.features.channel.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.biodun.mindvalley.core.DbConstants
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel

@Entity(tableName = DbConstants.CHANNEL_TABLE)
data class CachedChannelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val channelTitle: String,
    val channelMediaCount: Int,
    val channelIconAssetUrl: String,
    val channelCoverAssetUrl: String,
    val channelSeries: List<CachedChannelSeriesEntity>,
    val channelLatestMedia: List<CachedChannelLatestMediaEntity>
)
