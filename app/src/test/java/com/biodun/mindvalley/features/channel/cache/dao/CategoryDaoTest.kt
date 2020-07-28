package com.biodun.mindvalley.features.channel.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.cache.dao.CategoryDao
import com.biodun.mindvalley.features.channel.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CategoryDaoTest {

    private lateinit var appDb: AppDatabase
    private lateinit var categoryDao: CategoryDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries().build()

        categoryDao = appDb.categoryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun insertAllCategory_shouldAddCategoryDataIntoDb() {
        val categoryData = FakeCacheTestFactory.getCategoryList()

        categoryDao.insertAllCategory(categoryData)
        val returnedInsertedData = categoryDao.getCategories().blockingGet()

        assertEquals(returnedInsertedData.size, categoryData.size)
    }

    @Test
    fun getAllCategoryData_shouldReturnAllInsertedData() {
        val categoryData = FakeCacheTestFactory.getCategoryList()

        categoryDao.insertAllCategory(categoryData)
        val returnedCategoryData = categoryDao.getCategories().blockingGet()

        assertEquals(returnedCategoryData.size, categoryData.size)
    }

    @Test
    fun deleteCategories_shouldDeleteAllCategoryData() {
        val categoryData = FakeCacheTestFactory.getCategoryList()

        categoryDao.insertAllCategory(categoryData)
        categoryDao.deleteCategories()

        val returnedCategoryData = categoryDao.getCategories().blockingGet()

        assertEquals(returnedCategoryData.size, 0)
    }
}
