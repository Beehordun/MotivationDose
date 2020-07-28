package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.core.GlideApp
import com.biodun.mindvalley.features.channel.domain.model.EpisodeData
import kotlinx.android.synthetic.main.episode_item_layout.view.*

const val WIDTH_PERCENT = 0.35
class EpisodeAdapter(
    private val episodes: MutableList<EpisodeData>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.episode_item_layout, parent, false)

        val viewHolderWidth =
            AdapterUtil.getViewHolderWidthAsPercentageOfParent(context, WIDTH_PERCENT)
        view.layoutParams.width = viewHolderWidth
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val episodeData = episodes[position]

        GlideApp.with(context)
            .load(episodeData.episodeCoverAssetUrl)
            .into(holder.itemView.episodeImageView)

        holder.itemView.episodeTitleText.text = episodeData.episodeTitle
        holder.itemView.episodeChannelTitleText.text = episodeData.episodeChannelTitle
    }

    fun updateData(data: List<EpisodeData>) {
        episodes.clear()
        episodes.addAll(data)
        notifyDataSetChanged()
    }

    internal class EpisodeViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)
}
