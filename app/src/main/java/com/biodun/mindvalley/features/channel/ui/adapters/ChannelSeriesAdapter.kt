package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.GlideApp
import com.biodun.mindvalley.features.channel.domain.model.ChannelSeries
import kotlinx.android.synthetic.main.channel_item_series_layout.view.*

const val SERIES_WIDTH_PERCENT = 0.8
class ChannelSeriesAdapter(
    private val channels: List<ChannelSeries>,
    private val context: Context
) : ChannelBaseAdapter(channels.size) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_item_series_layout, parent, false)

        val viewHolderWidth =
            AdapterUtil.getViewHolderWidthAsPercentageOfParent(context, SERIES_WIDTH_PERCENT)
        view.layoutParams.width = viewHolderWidth
        return ChannelSeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val channelData = channels[position]

        GlideApp.with(context)
            .load(channelData.seriesTitleCoverAssetUrl)
            .into(holder.itemView.channelSeriesImageView)

        holder.itemView.channelLSeriesTitleText.text = channelData.seriesTitle
    }

    internal class ChannelSeriesViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)
}
