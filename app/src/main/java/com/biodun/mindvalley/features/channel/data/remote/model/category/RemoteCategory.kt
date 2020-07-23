package com.biodun.mindvalley.features.channel.data.remote.model.category

import com.google.gson.annotations.SerializedName

data class RemoteCategory(
    @SerializedName("data")
    val remoteCategoryData: RemoteCategoryData?
)
