package com.biodun.mindvalley.features.channel.data.cache

import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.mapper.CategoryEntityMapper
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import io.reactivex.Single
import javax.inject.Inject

class CachedCategoryDataSourceImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val categoryEntityMapper: CategoryEntityMapper
) : CachedCategoryDataSource {

    override fun getCategoryData(): Single<List<CategoryModel>> =
        appDatabase.categoryDao().getCategories().map {
            categoryEntityMapper.fromCached(it)
        }

    override fun insertCategoryData(categories: List<CategoryModel>) =
        appDatabase.categoryDao().insertAllCategory(categoryEntityMapper.toCached(categories))

    override fun deleteAllCategoryData() {
        appDatabase.categoryDao().deleteCategories()
    }
}
