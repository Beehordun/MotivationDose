package com.biodun.mindvalley.screens

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.biodun.mindvalley.R
import org.hamcrest.Matcher

class ChannelActivityScreen : Screen<ChannelActivityScreen>() {

    val categoryRecycler = KRecyclerView({
        withId(R.id.categoryRecyclerView)
    }, itemTypeBuilder = {
        itemType(::CategoryItem)
    })

    val categoriesTitle = KTextView {
        withId(R.id.categoryHeader)
    }

    val channelRecycler = KRecyclerView({
        withId(R.id.channelRecyclerView)
    }, itemTypeBuilder = {
        itemType(::ChannelItem)
    })

    val episodeRecycler = KRecyclerView({
        withId(R.id.episodeRecyclerView)
    }, itemTypeBuilder = {
        itemType(::EpisodeItem)
    })

    class CategoryItem(parent: Matcher<View>) : KRecyclerItem<CategoryItem>(parent) {
        val categoryName = KTextView(parent) { withId(R.id.categoryNameText) }
    }

    class ChannelItem(parent: Matcher<View>) : KRecyclerItem<ChannelItem>(parent) {
        val channelIconImage = KImageView(parent) { withId(R.id.channelIconImageView) }
        val channelIconTitleText = KTextView(parent) { withId(R.id.channelTitleText) }
        val channelMediaCountText = KTextView(parent) { withId(R.id.channelMediaCountText) }
    }

    class EpisodeItem(parent: Matcher<View>) : KRecyclerItem<EpisodeItem>(parent) {
        val episodeImage = KImageView(parent) { withId(R.id.episodeImageView) }
        val episodeTitleText = KTextView(parent) { withId(R.id.episodeTitleText) }
        val episodeChannelTitleText = KTextView(parent) { withId(R.id.episodeChannelTitleText) }
    }
}
