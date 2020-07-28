package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import com.biodun.mindvalley.features.channel.domain.model.ChannelData

object ChannelAdapterUtil {

    fun getAdapter(context: Context, channelData: ChannelData): ChannelBaseAdapter {
        return if (isSeries(channelData)) {
            ChannelSeriesAdapter(channelData.channelSeries, context)

        } else {
            ChannelLatestMediaAdapter(channelData.channelLatestMedia, context)
        }
    }

    fun getMediaCountText(count: Int, channelData: ChannelData): String {
        return if (isSeries(channelData)) {
            "$count Series"
        } else {
            "$count Episodes"
        }
    }

    private fun isSeries(channelData: ChannelData): Boolean =
        channelData.channelSeries.isNotEmpty()
}
