package com.biodun.mindvalley.features.channel.data.mapper

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.domain.model.CategoryDomainModel
import javax.inject.Inject

class CategoryDomainModelMapper @Inject constructor() {

    fun mapToDomain(categories: List<CategoryModel>): List<CategoryDomainModel> =
        categories.map {
            CategoryDomainModel(
                categoryName = it.categoryName
            )
        }
}
