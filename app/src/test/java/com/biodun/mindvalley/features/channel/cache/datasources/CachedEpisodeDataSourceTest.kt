package com.biodun.mindvalley.features.channel.data.cache.datasources

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import com.biodun.mindvalley.features.channel.data.testFakeFactory.FakeCacheTestFactory
import com.biodun.mindvalley.features.channel.data.cache.mapper.EpisodeEntityMapper
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import org.junit.*
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CachedEpisodeDataSourceTest {

    private lateinit var appDb: AppDatabase
    private lateinit var episodeEntityMapper: EpisodeEntityMapper
    private lateinit var cacheEpisodeDataSource: CachedEpisodeDataSource
    private lateinit var cachedEpisodeEntity: List<CachedEpisodeEntity>
    private lateinit var episodeModel: List<EpisodeModel>

    @get:Rule
    val expectedException: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).allowMainThreadQueries().build()

        episodeEntityMapper = EpisodeEntityMapper()
        cacheEpisodeDataSource = CachedEpisodeDataSourceImpl(appDb, episodeEntityMapper)
        cachedEpisodeEntity = FakeCacheTestFactory.getEpisodeList()
        episodeModel = FakeCacheTestFactory.getEpisodeModel()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun getEpisodeDataTest() {
        cacheEpisodeDataSource.insertEpisodeData(episodeModel)
        val returnedEpisodeEntity = cacheEpisodeDataSource.getEpisodeData().blockingGet()

        Assert.assertEquals(returnedEpisodeEntity, episodeModel)
    }

    @Test
    fun insertEpisodeTest()  {
        cacheEpisodeDataSource.insertEpisodeData(episodeModel)
        val returnedEpisodeEntity = cacheEpisodeDataSource.getEpisodeData().blockingGet()

        Assert.assertEquals(returnedEpisodeEntity, episodeModel)
    }

    @Test
    fun clearEpisodeTest() {
        cacheEpisodeDataSource.insertEpisodeData(episodeModel)
        cacheEpisodeDataSource.deleteAllEpisodeData()

        val returnedData = cacheEpisodeDataSource.getEpisodeData().blockingGet()

        Assert.assertEquals(returnedData.size, 0)
    }
}
