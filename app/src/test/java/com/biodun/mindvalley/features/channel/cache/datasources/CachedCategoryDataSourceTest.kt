package com.biodun.mindvalley.features.channel.cache.datasources

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedCategoryDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedCategoryEntity
import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.data.cache.mapper.CategoryEntityMapper
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import org.junit.Rule
import org.junit.Before
import org.junit.Test
import org.junit.After
import org.junit.Assert
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CachedCategoryDataSourceTest {

    private lateinit var appDb: AppDatabase
    private lateinit var categoryEntityMapper: CategoryEntityMapper
    private lateinit var cacheCategoryDataSource: CachedCategoryDataSource
    private lateinit var cachedCategoryEntity: List<CachedCategoryEntity>
    private lateinit var categoryModel: List<CategoryModel>

    @get:Rule
    val expectedException: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries().build()

        categoryEntityMapper = CategoryEntityMapper()
        cacheCategoryDataSource = CachedCategoryDataSourceImpl(appDb, categoryEntityMapper)
        cachedCategoryEntity = FakeCacheTestFactory.getCategoryList()
        categoryModel = FakeCacheTestFactory.getCategoryModel()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun getCategoryDataTest() {
        cacheCategoryDataSource.insertCategoryData(categoryModel)
        val returnedCategoryEntity = cacheCategoryDataSource.getCategoryData().blockingGet()

        Assert.assertEquals(returnedCategoryEntity, categoryModel)
    }

    @Test
    fun insertCategoryTest() {
        cacheCategoryDataSource.insertCategoryData(categoryModel)
        val returnedCategoryEntity = cacheCategoryDataSource.getCategoryData().blockingGet()

        Assert.assertEquals(returnedCategoryEntity, categoryModel)
    }

    @Test
    fun clearCategoryTest() {
        cacheCategoryDataSource.insertCategoryData(categoryModel)
        cacheCategoryDataSource.deleteAllCategoryData()

        val returnedData = cacheCategoryDataSource.getCategoryData().blockingGet()

        Assert.assertEquals(returnedData.size, 0)
    }
}
