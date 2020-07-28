package com.biodun.mindvalley.features.channel.data.remote.category

import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.mapper.CategoryModelMapper
import io.reactivex.Single
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
