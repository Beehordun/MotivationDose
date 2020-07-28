package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import javax.inject.Inject

class CategoryMapper @Inject constructor() {

    fun mapToDomain(categories: List<CategoryModel>): List<CategoryData> =
        categories.map {
            CategoryData(
                categoryName = it.categoryName
            )
        }
}
