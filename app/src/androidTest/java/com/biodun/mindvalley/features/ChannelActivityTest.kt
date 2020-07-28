package com.biodun.mindvalley.features

import androidx.test.espresso.IdlingRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.agoda.kakao.screen.Screen
import com.biodun.mindvalley.core.idlingresources.EspressoIdlingResource
import com.biodun.mindvalley.features.channel.ui.ChannelActivity
import com.biodun.mindvalley.screens.ChannelActivityScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChannelActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<ChannelActivity> =
        ActivityTestRule(ChannelActivity::class.java)

    private lateinit var categoryIdlingResource: EspressoIdlingResource
    private lateinit var episodeIdlingResource: EspressoIdlingResource
    private lateinit var channelIdlingResource: EspressoIdlingResource

    @Before
    fun setUp() {
        categoryIdlingResource = activityRule.activity.categoryRecyclerViewIdlingResource
        episodeIdlingResource = activityRule.activity.episodeRecyclerViewIdlingResource
        channelIdlingResource = activityRule.activity.channelRecyclerViewIdlingResource
    }

    @Test
    fun categoryIsLoaded() {
        IdlingRegistry.getInstance().register(categoryIdlingResource.idlingResource)
        Screen.onScreen<ChannelActivityScreen> {
            categoriesTitle {
                isDisplayed()
                hasAnyText()
            }
        }

        IdlingRegistry.getInstance().unregister(categoryIdlingResource.idlingResource)
    }

    @Test
    fun episodeIsLoaded() {
        IdlingRegistry.getInstance().register(episodeIdlingResource.idlingResource)
        Screen.onScreen<ChannelActivityScreen> {
            episodeRecycler {
                firstChild<ChannelActivityScreen.EpisodeItem> {
                    isDisplayed()
                    episodeChannelTitleText { hasAnyText() }
                    episodeTitleText { hasAnyText() }
                }
            }
        }
        IdlingRegistry.getInstance().unregister(episodeIdlingResource.idlingResource)
    }

    @Test
    fun channelIsLoaded() {
        IdlingRegistry.getInstance().register(channelIdlingResource.idlingResource)
        Screen.onScreen<ChannelActivityScreen> {
            channelRecycler {
                firstChild<ChannelActivityScreen.ChannelItem> {
                    isDisplayed()
                    channelIconTitleText { hasAnyText() }
                    channelMediaCountText { hasAnyText() }
                }
            }
        }
        IdlingRegistry.getInstance().unregister(channelIdlingResource.idlingResource)
    }
}