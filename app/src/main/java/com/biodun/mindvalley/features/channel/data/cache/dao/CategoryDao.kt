package com.biodun.mindvalley.features.channel.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.biodun.mindvalley.core.DELETE_CATEGORIES_QUERY
import com.biodun.mindvalley.core.GET_CATEGORIES_QUERY
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedCategoryEntity
import io.reactivex.Single

@Dao
interface CategoryDao {

    @Insert
    fun insertAllCategory(categories: List<CachedCategoryEntity>)

    @Query(GET_CATEGORIES_QUERY)
    fun getCategories(): Single<List<CachedCategoryEntity>>

    @Query(DELETE_CATEGORIES_QUERY)
    fun deleteCategories()
}
