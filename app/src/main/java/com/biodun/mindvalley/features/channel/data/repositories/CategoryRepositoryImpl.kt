package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSource
import com.biodun.mindvalley.features.channel.data.mapper.CategoryMapper
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSource
import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import com.biodun.mindvalley.features.channel.domain.repositories.CategoryRepository
import io.reactivex.Single
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteCategoryDataSource: RemoteCategoryDataSource,
    private val cachedCategoryDataSource: CachedCategoryDataSource,
    private val categoryMapper: CategoryMapper,
    private val networkHandler: NetworkHandler
) : CategoryRepository {

    override fun getCategory(): Single<List<CategoryData>> {
        return if (networkHandler.isConnected()) {
            remoteCategoryDataSource.getCategoryData().map { list ->
                addFetchedCategoryDataToDb(list)
                categoryMapper.mapToDomain(list)
            }.onErrorResumeNext {
                cachedCategoryDataSource.getCategoryData().map {
                    categoryMapper.mapToDomain(it)
                }
            }
        } else
            cachedCategoryDataSource.getCategoryData().map {
                categoryMapper.mapToDomain(it)
            }
    }

    private fun addFetchedCategoryDataToDb(data: List<CategoryModel>) {
        cachedCategoryDataSource.deleteAllCategoryData()
        cachedCategoryDataSource.insertCategoryData(data)
    }
}
