package com.biodun.mindvalley.features.channel.ui.adapters

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class ItemOffsetDecoration(context: Context, @DimenRes itemOffSetId: Int) : ItemDecoration() {

    private val mItemOffset:Int = context.resources.getDimensionPixelSize(itemOffSetId)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }
}
