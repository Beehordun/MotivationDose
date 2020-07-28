package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.GlideApp
import com.biodun.mindvalley.features.channel.domain.model.ChannelLatestMedia
import kotlinx.android.synthetic.main.channel_item_latest_media_layout.view.*

class ChannelLatestMediaAdapter(
    private val channels: List<ChannelLatestMedia>,
    private val context: Context
) : ChannelBaseAdapter(channels.size) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_item_latest_media_layout, parent, false)
        val viewHolderWidth =
            AdapterUtil.getViewHolderWidthAsPercentageOfParent(context, WIDTH_PERCENT)
        view.layoutParams.width = viewHolderWidth
        return ChannelLatestMediaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val channelData = channels[position]

        GlideApp.with(context)
            .load(channelData.channelCoverAssetUrl)
            .into(holder.itemView.channelLatestMediaImageView)

        holder.itemView.channelLatestMediaTitleText.text = channelData.channelTitle
    }

    internal class ChannelLatestMediaViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)
}
