package com.biodun.mindvalley.features.channel.data.cache.mapper

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedCategoryEntity
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import javax.inject.Inject

class CategoryEntityMapper @Inject constructor() {

    fun fromCached(categories: List<CachedCategoryEntity>): List<CategoryModel> =
        categories.map {
            CategoryModel(
                categoryName = it.categoryName
            )
        }

    fun toCached(categories: List<CategoryModel>): List<CachedCategoryEntity> =
        categories.map {
            CachedCategoryEntity(
                categoryName = it.categoryName
            )
        }
}
