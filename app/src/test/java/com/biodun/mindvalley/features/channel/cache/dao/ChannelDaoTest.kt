package com.biodun.mindvalley.features.channel.data.cache.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.testFakeFactory.FakeCacheTestFactory
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class ChannelDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDb: AppDatabase
    private lateinit var channelDao: ChannelDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).allowMainThreadQueries().build()

        channelDao = appDb.channelDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun insertAllChannel_shouldAddAllCategoryDataIntoDb() {
        val channelData = FakeCacheTestFactory.getChannelList()

        channelDao.insertAllChannel(channelData)
        channelDao.getChannels().test().run {
            assertNoErrors()
            val data = values()[0]
            Assert.assertEquals(data.size, channelData.size)
            dispose()
        }
    }

    @Test
    fun getAllChannelData_shouldReturnAllInsertedData() {
        val channelData = FakeCacheTestFactory.getChannelList()

        channelDao.insertAllChannel(channelData)
        val returnedChannelData = channelDao.getChannels().blockingGet()

        Assert.assertEquals(returnedChannelData.size, channelData.size)
    }

    @Test
    fun deleteChannels_shouldDeleteAllChannelData() {
        val channelData = FakeCacheTestFactory.getChannelList()

        channelDao.insertAllChannel(channelData)
        channelDao.deleteChannels()

        val returnedChannelData = channelDao.getChannels().blockingGet()

        Assert.assertEquals(returnedChannelData.size, 0)
    }
}
