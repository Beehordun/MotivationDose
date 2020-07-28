package com.biodun.mindvalley.features.channel.data.remote.category

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import io.reactivex.Single

interface RemoteCategoryDataSource {
    fun getCategoryData(): Single<List<CategoryModel>>
}
