package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.mindvalley.R
import com.biodun.mindvalley.features.channel.domain.model.CategoryData
import kotlinx.android.synthetic.main.category_item_list.view.*

const val TEXT_WIDTH_PERCENT = 0.4
class CategoryAdapter(
    private val context: Context,
    private val categories: MutableList<CategoryData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item_list, parent, false)

        val viewHolderWidth =
            AdapterUtil.getViewHolderWidthAsPercentageOfParent(context, TEXT_WIDTH_PERCENT)
        view.layoutParams.width = viewHolderWidth

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categoryData = categories[position]

        holder.itemView.categoryNameText.text = categoryData.categoryName
    }

    fun updateData(data: List<CategoryData>) {
        categories.clear()
        categories.addAll(data)
        notifyDataSetChanged()
    }

    internal class CategoryViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v)
}
