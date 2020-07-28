package com.biodun.mindvalley.features.channel.data.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class EpisodeDaoTest {

    private lateinit var appDb: AppDatabase
    private lateinit var episodeDao: EpisodeDao
    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries().build()

        episodeDao = appDb.episodeDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun insertAllEpisode_shouldAddDataIntoDb() {
        val episodeData = FakeCacheTestFactory.getEpisodeList()

        episodeDao.insertAllEpisode(episodeData)
        val returnedInsertedData = episodeDao.getEpisodes().blockingGet()

        Assert.assertEquals(returnedInsertedData.size, episodeData.size)
    }

    @Test
    fun getAllEpisodeData_shouldReturnAllInsertedData() {
        val episodeData = FakeCacheTestFactory.getEpisodeList()

        episodeDao.insertAllEpisode(episodeData)
        val returnedEpisodeData = episodeDao.getEpisodes().blockingGet()

        Assert.assertEquals(returnedEpisodeData.size, episodeData.size)
    }

    @Test
    fun deleteEpisode_shouldDeleteAllEpisodeData() {
        val episodeData = FakeCacheTestFactory.getEpisodeList()

        episodeDao.insertAllEpisode(episodeData)
        episodeDao.deleteEpisodes()

        val returnedEpisodeData = episodeDao.getEpisodes().blockingGet()

        Assert.assertEquals(returnedEpisodeData.size, 0)
    }
}
