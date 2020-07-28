package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.data.remote.mapper.CategoryModelMapper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CategoryDataModelMapperTest {

    lateinit var categoryModelMapper: CategoryModelMapper

    @Before
    fun setup() {
        categoryModelMapper = CategoryModelMapper()
    }

    @Test
    fun mapFromRemoteCategory_returnsCategoryModelList() {
        val remoteCategory = CategoryTestFactory.getRemoteCategory()
        val expectedCategoryModel = CategoryTestFactory.getCategoryModel()

        val actualCategoryModel = categoryModelMapper.mapFromRemoteCategory(remoteCategory)
        assertEquals(expectedCategoryModel, actualCategoryModel)
    }

    @Test
    fun mapFromRemoteCategory_returnsEmptyList_whenRemoteCategoryDataIsNull() {
        val remoteCategoryWithNullData = CategoryTestFactory.getRemoteCategoryWithNullData()

        val returnedCategoryModel =
            categoryModelMapper.mapFromRemoteCategory(remoteCategoryWithNullData)

        assertEquals(0, returnedCategoryModel.size)
    }

    @Test
    fun mapFromRemoteCategory_returnsEmptyList_whenRemoteCategoriesIsNull() {
        val remoteCategoryWithNullCategories = CategoryTestFactory.getRemoteCategoryWithNullCategories()

        val returnedCategoryModel =
            categoryModelMapper.mapFromRemoteCategory(remoteCategoryWithNullCategories)

        assertEquals(0, returnedCategoryModel.size)
    }
}
