package com.example.obvioustest.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.obvioustest.R
import com.example.obvioustest.adapters.ImageListAdapter
import com.example.obvioustest.adapters.ImageListViewPagerAdapter
import com.example.obvioustest.model.SpaceImagesModel
import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isDetailFragmentVisible_onImageClickOnList() {

        Espresso.onView(ViewMatchers.withId(R.id.rcvImageList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageListViewPagerAdapter.ViewHolder>(
                2,
                ViewActions.click()
            )
        )
    }

    @Test
    fun test_selectedItemVisible_onDetailFragment() {

        val context = InstrumentationRegistry.getInstrumentation().context
        val data = context.assets.open("data.json").bufferedReader().use { it.readText() }
        val imageListTest = Gson().fromJson(data, Array<SpaceImagesModel>::class.java).toList()

        Espresso.onView(ViewMatchers.withId(R.id.rcvImageList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageListAdapter.ViewHolder>(
                3,
                ViewActions.click()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.vpImageList))
            .check(matches(hasDescendant(withText(imageListTest[3].title))))
    }
}