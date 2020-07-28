package com.biodun.mindvalley.features.channel.domain.repositories

import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import io.reactivex.Single

interface CategoryRepository {
    fun getCategory(): Single<List<CategoryData>>
}
