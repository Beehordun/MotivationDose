package com.biodun.mindvalley.features.channel.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.biodun.mindvalley.core.DB_VERSION
import com.biodun.mindvalley.features.channel.data.cache.dao.CategoryDao
import com.biodun.mindvalley.features.channel.data.cache.dao.ChannelDao
import com.biodun.mindvalley.features.channel.data.cache.dao.EpisodeDao
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedCategoryEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity

@TypeConverters(ChannelLatestMediaTypeConverter::class, ChannelSeriesTypeConverter::class)
@Database(
    entities =
    [CachedCategoryEntity::class, CachedChannelEntity::class, CachedEpisodeEntity::class],
    version = DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun channelDao(): ChannelDao
    abstract fun episodeDao(): EpisodeDao
}
