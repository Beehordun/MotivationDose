package com.biodun.mindvalley.core

const val DB_NAME = "mindValley_db"
const val CATEGORY_TABLE = "category_table"
const val EPISODE_TABLE = "episode_table"
const val CHANNEL_TABLE = "channel_table"
const val DB_VERSION = 1
const val GET_CATEGORIES_QUERY = "SELECT * from $CATEGORY_TABLE"
const val DELETE_CATEGORIES_QUERY = "DELETE FROM $CATEGORY_TABLE"
const val GET_CHANNELS_QUERY = "SELECT * from $CHANNEL_TABLE"
const val DELETE_CHANNELS_QUERY = "DELETE FROM $CHANNEL_TABLE"
const val GET_EPISODES_QUERY = "SELECT * from $EPISODE_TABLE"
const val DELETE_EPISODES_QUERY = "DELETE FROM $EPISODE_TABLE"
