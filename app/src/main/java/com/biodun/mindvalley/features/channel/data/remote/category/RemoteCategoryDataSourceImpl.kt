package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.remote.mapper.CategoryModelMapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteCategoryDataSourceImpl @Inject constructor(
    private val channelApi: ChannelApi,
    private val categoryModelMapper: CategoryModelMapper
) : RemoteCategoryDataSource {

    override fun getCategoryData(): Single<List<CategoryModel>> =
        channelApi.getCategory().map {
            categoryModelMapper.mapFromRemoteCategory(it)
        }
}
