package com.biodun.mindvalley.features.channel.data.remote.model.category

import com.google.gson.annotations.SerializedName

data class RemoteCategoryData(
    @SerializedName("categories")
    val categories: List<RemoteCategories>?
)
