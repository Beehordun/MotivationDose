package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.GlideApp
import com.biodun.mindvalley.features.channel.domain.model.ChannelData
import kotlinx.android.synthetic.main.channel_item_outer_layout.view.*

class ChannelAdapter(
    private val channels: MutableList<ChannelData>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return channels.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_item_outer_layout, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val channelData = channels[position]
        GlideApp.with(context)
            .load(channelData.channelIconAssetUrl)
            .placeholder(R.drawable.channel_icon_placeholder)
            .circleCrop()
            .into(holder.itemView.channelIconImageView)

        with(holder.itemView) {
            channelTitleText.text = channelData.channelTitle

            channelMediaCountText.text =
                AdapterUtil.getMediaCountText(channelData.channelMediaCount, channelData)

            innerRecyclerView.adapter = AdapterUtil.getAdapter(context, channelData)
        }
    }

    fun updateData(data: List<ChannelData>) {
        channels.clear()
        channels.addAll(data)
        notifyDataSetChanged()
    }

    internal class ChannelViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)
}
