package com.biodun.mindvalley.features.channel.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

const val MAX_SIZE_PER_ROW = 6
abstract class ChannelBaseAdapter(
    private val dataSize: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = min(MAX_SIZE_PER_ROW, dataSize)
}
