package com.biodun.mindvalley.features.channel.remote

import com.biodun.mindvalley.features.channel.data.remote.ChannelApi
import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSource
import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSourceImpl
import com.biodun.mindvalley.features.channel.data.remote.mapper.CategoryModelMapper
import com.biodun.mindvalley.features.channel.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.testFakeFactory.TestChannelApi
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemoteCategoryDataDataSourceTest {

    lateinit var remoteCategoryDataSourceImpl: RemoteCategoryDataSource
    lateinit var categoryModelMapper: CategoryModelMapper
    lateinit var channelApi: ChannelApi

    @Before
    fun setup() {
        channelApi =
            TestChannelApi()
        categoryModelMapper = CategoryModelMapper()
        remoteCategoryDataSourceImpl =
            RemoteCategoryDataSourceImpl(
                channelApi,
                categoryModelMapper
            )
    }

    @Test
    fun getCategoryData_returnsSingleCategoryModelList() {
        val expectedResult = Single.just(CategoryTestFactory.getCategoryModel())

        val returnedResult = remoteCategoryDataSourceImpl.getCategoryData()

        Assert.assertEquals(expectedResult.blockingGet(), returnedResult.blockingGet())
    }
}
