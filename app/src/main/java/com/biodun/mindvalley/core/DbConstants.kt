package com.biodun.mindvalley.core

object DbConstants {
    const val DB_NAME = "MindValley Db"
    const val CATEGORY_TABLE = "Category Table"
    const val EPISODE_TABLE = "Episode Table"
    const val CHANNEL_TABLE = "Channel Table"
    const val DB_VERSION = ONE
    const val GET_CATEGORIES_QUERY = "SELECT * from $CATEGORY_TABLE"
    const val DELETE_CATEGORIES_QUERY = "DELETE FROM $CATEGORY_TABLE"
    const val GET_CHANNELS_QUERY = "SELECT * from $CHANNEL_TABLE"
    const val DELETE_CHANNELS_QUERY = "DELETE FROM $CHANNEL_TABLE"
    const val GET_EPISODES_QUERY = "SELECT * from $EPISODE_TABLE"
    const val DELETE_EPISODES_QUERY = "DELETE FROM $EPISODE_TABLE"
}
