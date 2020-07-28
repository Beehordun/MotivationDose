package com.biodun.mindvalley.features.channel.ui.adapters

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import com.biodun.mindvalley.features.channel.domain.model.ChannelData

object AdapterUtil {

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

    fun getViewHolderWidthAsPercentageOfParent(context: Context, percent: Double): Int {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return (displayMetrics.widthPixels * percent).toInt()
    }

    private fun isSeries(channelData: ChannelData): Boolean =
        channelData.channelSeries.isNotEmpty()
}
