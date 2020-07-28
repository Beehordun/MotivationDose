package com.biodun.mindvalley.features.channel.data.repositories

import com.biodun.mindvalley.core.NetworkHandler
import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSource
import com.biodun.mindvalley.features.channel.data.mapper.CategoryMapper
import com.biodun.mindvalley.features.channel.data.remote.category.RemoteCategoryDataSource
import com.biodun.mindvalley.features.channel.domain.repositories.CategoryRepository
import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

class CategoryRepositoryTest {

    private lateinit var categoryRepository: CategoryRepository
    private val remoteCategoryDataSource: RemoteCategoryDataSource = mock()
    private val cachedCategoryDataSource: CachedCategoryDataSource = mock()
    private val categoryMapper: CategoryMapper = mock()
    private val networkHandler: NetworkHandler = mock()

    @Before
    fun setUp() {
        categoryRepository =
            CategoryRepositoryImpl(
                remoteCategoryDataSource, cachedCategoryDataSource, categoryMapper, networkHandler
            )
    }

    @Test
    fun getCategory_whenConnection_fetchesRemoteCategoryData() {
        val categoryModelData = FakeCacheTestFactory.getCategoryModel()
        val expectedData = CategoryMapper().mapToDomain(categoryModelData)

        whenever(networkHandler.isConnected()).thenReturn(true)
        whenever(remoteCategoryDataSource.getCategoryData())
            .thenReturn(Single.just(categoryModelData))
        whenever(categoryMapper.mapToDomain(categoryModelData)).thenReturn(expectedData)

        val test = categoryRepository.getCategory().test()

        verify(remoteCategoryDataSource).getCategoryData()
        verify(categoryMapper).mapToDomain(categoryModelData)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }

    @Test
    fun getCategory_whenNoConnection_getsCachedCategoryData() {
        val categoryModelData = FakeCacheTestFactory.getCategoryModel()
        val expectedData = CategoryMapper().mapToDomain(categoryModelData)

        whenever(networkHandler.isConnected()).thenReturn(false)
        whenever(cachedCategoryDataSource.getCategoryData())
            .thenReturn(Single.just(categoryModelData))
        whenever(categoryMapper.mapToDomain(categoryModelData)).thenReturn(expectedData)

        val test = categoryRepository.getCategory().test()

        verify(cachedCategoryDataSource).getCategoryData()
        verify(categoryMapper).mapToDomain(categoryModelData)
        verifyZeroInteractions(remoteCategoryDataSource)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }

    @Test
    fun getCategory_whenConnectionButThrowsError_fetchDataFromDb() {
        val categoryModelData = FakeCacheTestFactory.getCategoryModel()
        val expectedData = CategoryMapper().mapToDomain(categoryModelData)

        whenever(networkHandler.isConnected()).thenReturn(true)
        whenever(remoteCategoryDataSource.getCategoryData())
            .thenReturn(Single.error(Throwable()))
        whenever(cachedCategoryDataSource.getCategoryData())
            .thenReturn(Single.just(categoryModelData))
        whenever(categoryMapper.mapToDomain(categoryModelData)).thenReturn(expectedData)

        val test = categoryRepository.getCategory().test()

        com.nhaarman.mockito_kotlin.verify(cachedCategoryDataSource).getCategoryData()
        com.nhaarman.mockito_kotlin.verify(categoryMapper).mapToDomain(categoryModelData)

        test.run {
            val data = values()[0]
            Assert.assertEquals(expectedData, data)
            dispose()
        }
    }
}
