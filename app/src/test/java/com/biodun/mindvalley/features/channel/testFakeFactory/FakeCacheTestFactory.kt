package com.biodun.mindvalley.features.channel.testFakeFactory

import com.biodun.mindvalley.features.channel.data.cache.entity.CachedCategoryEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelSeriesEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedChannelLatestMediaEntity
import com.biodun.mindvalley.features.channel.data.cache.entity.CachedEpisodeEntity
import com.biodun.mindvalley.features.channel.data.mapper.ChannelLatestMediaMapper
import com.biodun.mindvalley.features.channel.data.mapper.ChannelMapper
import com.biodun.mindvalley.features.channel.data.mapper.ChannelSeriesMapper
import com.biodun.mindvalley.features.channel.data.model.category.CategoryModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelLatestMediaModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelModel
import com.biodun.mindvalley.features.channel.data.model.channel.ChannelSeriesModel
import com.biodun.mindvalley.features.channel.data.model.episode.EpisodeModel
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import java.util.UUID

object FakeCacheTestFactory {

    private val categoryNames = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val episodeType = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val episodeTitle = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val episodeCoverAssetUrl =
        listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val episodeChannelTitle =
        listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())

    private val channelTitle = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val channelMediaCount = listOf(1, 2)
    private val channelIconAssetUrl =
        listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val channelCoverAssetUrl =
        listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val channelType = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())

    private val seriesTitle = listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())
    private val seriesTitleCoverAssetUrl =
        listOf(UUID.randomUUID().toString(), UUID.randomUUID().toString())

    fun getCategoryList(): List<CachedCategoryEntity> {
        return listOf(
            CachedCategoryEntity(
                categoryName = categoryNames[0]
            ),
            CachedCategoryEntity(
                categoryName = categoryNames[1]
            )
        )
    }

    fun getCategoryModel(): List<CategoryModel> {
        return listOf(
            CategoryModel(
                categoryName = categoryNames[0]
            ),
            CategoryModel(
                categoryName = categoryNames[1]
            )
        )
    }

    fun getEpisodeList(): List<CachedEpisodeEntity> {
        return listOf(
            CachedEpisodeEntity(
                episodeType = episodeType[0],
                episodeTitle = episodeTitle[0],
                episodeCoverAssetUrl = episodeCoverAssetUrl[0],
                episodeChannelTitle = episodeChannelTitle[0]
            ),

            CachedEpisodeEntity(
                episodeType = episodeType[1],
                episodeTitle = episodeTitle[1],
                episodeCoverAssetUrl = episodeCoverAssetUrl[1],
                episodeChannelTitle = episodeChannelTitle[1]
            )
        )
    }

    fun getEpisodeModel(): List<EpisodeModel> {
        return listOf(
            EpisodeModel(
                episodeType = episodeType[0],
                episodeTitle = episodeTitle[0],
                episodeCoverAssetUrl = episodeCoverAssetUrl[0],
                episodeChannelTitle = episodeChannelTitle[0]
            ),

            EpisodeModel(
                episodeType = episodeType[1],
                episodeTitle = episodeTitle[1],
                episodeCoverAssetUrl = episodeCoverAssetUrl[1],
                episodeChannelTitle = episodeChannelTitle[1]
            )
        )
    }

    fun getChannelList(): List<CachedChannelEntity> {
        return listOf(
            CachedChannelEntity(
                channelTitle = channelTitle[0],
                channelMediaCount = channelMediaCount[0],
                channelIconAssetUrl = channelIconAssetUrl[0],
                channelCoverAssetUrl = channelCoverAssetUrl[0],
                channelSeries = getCachedChannelSeriesEntityList(),
                channelLatestMedia = getCachedChannelLatestMediaEntityList()
            )
        )
    }

    fun getChannelModel(): List<ChannelModel> {
        return listOf(
            ChannelModel(
                channelTitle = channelTitle[0],
                channelMediaCount = channelMediaCount[0],
                channelIconAssetUrl = channelIconAssetUrl[0],
                channelCoverAssetUrl = channelCoverAssetUrl[0],
                channelSeries = getChannelSeriesModelList(),
                channelLatestMedia = getChannelLatestMediaModelList()
            )
        )
    }

    fun getChannelData(): List<ChannelData> {
        val channelSeriesMapper = ChannelSeriesMapper()
        val channelLatestMediaMapper = ChannelLatestMediaMapper()
        val channelMapper = ChannelMapper(channelSeriesMapper, channelLatestMediaMapper)

        return channelMapper.mapToDomain(getChannelModel())
    }

    private fun getChannelSeriesModelList(): List<ChannelSeriesModel> {
        return listOf(
            ChannelSeriesModel(
                seriesTitle = seriesTitle[0],
                seriesTitleCoverAssetUrl = seriesTitleCoverAssetUrl[0]
            ),

            ChannelSeriesModel(
                seriesTitle = seriesTitle[1],
                seriesTitleCoverAssetUrl = seriesTitleCoverAssetUrl[1]
            )
        )
    }

    private fun getChannelLatestMediaModelList(): List<ChannelLatestMediaModel> {
        return listOf(
            ChannelLatestMediaModel(
                channelType = channelType[0],
                channelTitle = channelTitle[0],
                channelCoverAssetUrl = channelCoverAssetUrl[0]
            ),

            ChannelLatestMediaModel(
                channelType = channelType[1],
                channelTitle = channelTitle[1],
                channelCoverAssetUrl = channelCoverAssetUrl[1]
            )
        )
    }

    private fun getCachedChannelSeriesEntityList(): List<CachedChannelSeriesEntity> {
        return listOf(
            CachedChannelSeriesEntity(
                seriesTitle = seriesTitle[0],
                seriesTitleCoverAssetUrl = seriesTitleCoverAssetUrl[0]
            ),

            CachedChannelSeriesEntity(
                seriesTitle = seriesTitle[1],
                seriesTitleCoverAssetUrl = seriesTitleCoverAssetUrl[1]
            )
        )
    }

    private fun getCachedChannelLatestMediaEntityList(): List<CachedChannelLatestMediaEntity> {
        return listOf(
            CachedChannelLatestMediaEntity(
                channelTitle = channelTitle[0],
                channelType = channelType[0],
                channelCoverAssetUrl = channelCoverAssetUrl[0]
            ),

            CachedChannelLatestMediaEntity(
                channelTitle = channelTitle[0],
                channelType = channelType[0],
                channelCoverAssetUrl = channelCoverAssetUrl[0]
            )
        )
    }
}