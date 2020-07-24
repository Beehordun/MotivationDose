package com.biodun.mindvalley.features.channel.data.testFakeFactory

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategories
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategory
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategoryData
import java.util.UUID

object CategoryTestFactory {

    private val remoteCategoriesNames = listOf(
        UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
        UUID.randomUUID().toString()
    )

    fun getRemoteCategory(): RemoteCategory {
        return RemoteCategory(getRemoteCategoryData())
    }

    fun getRemoteCategoryWithNullData(): RemoteCategory {
        return RemoteCategory(null)
    }

    fun getRemoteCategoryWithNullCategories(): RemoteCategory {
        val remoteCategoryData = RemoteCategoryData(null)
        return RemoteCategory(remoteCategoryData)
    }

    fun getCategoryModel(): List<CategoryModel> {
        val categoryModels: MutableList<CategoryModel> = mutableListOf()
        remoteCategoriesNames.map {
            categoryModels.add(CategoryModel(it))
        }
        return categoryModels
    }

    private fun getRemoteCategoryData(): RemoteCategoryData {
        return RemoteCategoryData(getRemoteCategories())
    }

    private fun getRemoteCategories(): List<RemoteCategories> {
        val remoteCategories: MutableList<RemoteCategories> = mutableListOf()
        remoteCategoriesNames.forEach {
            remoteCategories.add(RemoteCategories(it))
        }
        return remoteCategories
    }
}
