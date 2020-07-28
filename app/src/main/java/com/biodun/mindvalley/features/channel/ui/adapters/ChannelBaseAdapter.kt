package com.biodun.mindvalley.features.channel.ui.adapters

import androidx.recyclerview.widget.RecyclerView

const val MAX_SIZE_PER_ROW = 6
abstract class ChannelInnerAdapter (): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = MAX_SIZE_PER_ROW
}