package com.biodun.mindvalley.core

import android.view.View
import android.view.View.VISIBLE
import android.view.View.INVISIBLE
import android.view.View.GONE
import com.facebook.shimmer.ShimmerFrameLayout

fun View.visible() {
    this.visibility = VISIBLE
}

fun View.inVisible() {
    this.visibility = INVISIBLE
}

fun View.gone() {
    this.visibility = GONE
}

fun ShimmerFrameLayout.displayShimmer() {
    this.visible()
    this.startShimmer()
}

fun ShimmerFrameLayout.clearShimmer() {
    this.gone()
    this.stopShimmer()
}
