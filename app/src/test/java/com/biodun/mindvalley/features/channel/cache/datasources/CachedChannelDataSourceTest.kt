package com.biodun.mindvalley.features.channel.data.cache.datasources

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedChannelDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSource
import com.biodun.mindvalley.features.channel.data.cache.CachedEpisodeDataSourceImpl
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import com.biodun.mindvalley.features.channel.data.cache.mapper.ChannelEntityMapper
import com.biodun.mindvalley.features.channel.data.cache.mapper.ChannelLatestMediaMapper
import com.biodun.mindvalley.features.channel.data.cache.mapper.ChannelSeriesMapper
import com.biodun.mindvalley.features.channel.data.cache.mapper.EpisodeEntityMapper
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.data.testFakeFactory.FakeCacheTestFactory
import org.junit.*
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CachedChannelDataSourceTest {

    private lateinit var appDb: AppDatabase
    private lateinit var channelEntityMapper: ChannelEntityMapper
    private lateinit var cacheChannelDataSource: CachedChannelDataSource
    private lateinit var cachedChannelEntity: List<CachedChannelEntity>
    private lateinit var channelModel: List<ChannelModel>

    @get:Rule
    val expectedException: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDb = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).allowMainThreadQueries().build()

        channelEntityMapper = ChannelEntityMapper(ChannelSeriesMapper(), ChannelLatestMediaMapper())
        cacheChannelDataSource = CachedChannelDataSourceImpl(appDb, channelEntityMapper)
        cachedChannelEntity = FakeCacheTestFactory.getChannelList()
        channelModel = FakeCacheTestFactory.getChannelModel()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun getChannelDataTest() {
        cacheChannelDataSource.insertChannelData(channelModel)
        val returnedChannelEntity = cacheChannelDataSource.getChannelData().blockingGet()

        Assert.assertEquals(returnedChannelEntity, channelModel)
    }

    @Test
    fun insertChannelTest()  {
        cacheChannelDataSource.insertChannelData(channelModel)
        val returnedChannelEntity = cacheChannelDataSource.getChannelData().blockingGet()

        Assert.assertEquals(returnedChannelEntity, channelModel)
    }

    @Test
    fun clearChannelTest() {
        cacheChannelDataSource.insertChannelData(channelModel)
        cacheChannelDataSource.deleteAllChannelData()

        val returnedData = cacheChannelDataSource.getChannelData().blockingGet()

        Assert.assertEquals(returnedData.size, 0)
    }
}
