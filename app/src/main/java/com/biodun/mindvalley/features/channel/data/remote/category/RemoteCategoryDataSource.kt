package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import io.reactivex.rxjava3.core.Single

interface RemoteCategoryDataSource {
    fun getCategoryData(): Single<List<CategoryModel>>
}
