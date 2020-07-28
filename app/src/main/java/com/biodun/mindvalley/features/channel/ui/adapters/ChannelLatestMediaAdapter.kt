package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.GlideApp
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import com.biodun.mindvalley.features.channel.domain.model.ChannelLatestMedia
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.channel_item_outer_layout.view.*

const val MAX_SIZE_PER_ROW = 6
class ChannelLatestMediaAdapter(
    private val channels: List<ChannelLatestMedia>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return MAX_SIZE_PER_ROW
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_item_latest_media_layout, parent, false)
        return ChannelLatestMediaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val channelData = channels[position]

        GlideApp.with(context)
            .load(channelData.channelIconAssetUrl)
            .transform(RoundedCorners(50))
            .centerCrop()
            .into(holder.itemView.channelIconImageView)

        holder.itemView.channelTitleText.text = channelData.channelTitle
        holder.itemView.channelMediaCountText.text = channelData.channelMediaCount.toString()
    }

    internal class ChannelLatestMediaViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)

}
