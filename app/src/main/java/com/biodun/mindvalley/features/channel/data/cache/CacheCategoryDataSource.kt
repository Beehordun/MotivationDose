package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import io.reactivex.rxjava3.core.Single

interface CacheCategoryDataSource {

    fun getCategoryData(): Single<List<CategoryModel>>
    fun insertCategoryData(categories: List<CategoryModel>)
    fun deleteAllCategoryData()
}
