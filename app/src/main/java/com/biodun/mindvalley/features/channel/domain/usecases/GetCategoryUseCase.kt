package com.biodun.mindvalley.features.channel.domain.usecases

import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import com.biodun.mindvalley.features.channel.domain.repositories.CategoryRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {

    fun getCategoryData(): Single<List<CategoryData>> =
        categoryRepository.getCategory()
}
