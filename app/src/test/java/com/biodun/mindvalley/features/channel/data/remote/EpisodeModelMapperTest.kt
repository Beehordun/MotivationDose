package com.biodun.mindvalley.features.channel.data.remote

import com.biodun.mindvalley.features.channel.data.testFakeFactory.EpisodeTestFactory
import com.biodun.mindvalley.features.channel.data.remote.mapper.EpisodeModelMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class EpisodeModelMapperTest {

    lateinit var episodeModelMapper: EpisodeModelMapper

    @Before
    fun setup() {
        episodeModelMapper = EpisodeModelMapper()
    }

    @Test
    fun mapFromRemoteEpisode_returnsEpisodeModelList() {
        val remoteEpisode = EpisodeTestFactory.getRemoteEpisode()
        val expectedEpisodeModel = EpisodeTestFactory.getEpisodeModel()

        val actualEpisodeModel = episodeModelMapper.mapFromRemoteEpisode(remoteEpisode)
        Assert.assertEquals(expectedEpisodeModel, actualEpisodeModel)
    }

    @Test
    fun mapFromRemoteEpisode_returnsEmptyList_whenRemoteEpisodeDataIsNull() {
        val remoteEpisodeWithNullData = EpisodeTestFactory.getRemoteEpisodeWithNullData()

        val returnedEpisodeModel =
            episodeModelMapper.mapFromRemoteEpisode(remoteEpisodeWithNullData)

        Assert.assertEquals(0, returnedEpisodeModel.size)
    }

    @Test
    fun mapFromRemoteCategory_returnsEmptyList_whenRemoteCategoriesIsNull() {
        val remoteEpisodeWithNullMedia =
            EpisodeTestFactory.getRemoteCategoryWithNullMedia()

        val returnedEpisodeModel =
            episodeModelMapper.mapFromRemoteEpisode(remoteEpisodeWithNullMedia)

        Assert.assertEquals(0, returnedEpisodeModel.size)
    }
}
