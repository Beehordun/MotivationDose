package com.biodun.mindvalley.features.channel.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.biodun.mindvalley.core.DbConstants

@Entity(tableName = DbConstants.CATEGORY_TABLE)
data class CachedCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val categoryName: String
)
