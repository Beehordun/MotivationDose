package com.biodun.mindvalley.features.channel.data.remote.mapper

import com.biodun.mindvalley.core.EMPTY_STRING
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.remote.model.category.RemoteCategory
import javax.inject.Inject

class CategoryModelMapper @Inject constructor() {

    fun mapFromRemoteCategory(remoteCategory: RemoteCategory): List<CategoryModel> {
        return remoteCategory.remoteCategoryData?.categories?.map {
            CategoryModel(categoryName = it.categoryName ?: EMPTY_STRING)
        } ?: emptyList()
    }
}
