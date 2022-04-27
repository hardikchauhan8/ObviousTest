package com.example.obvioustest.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.obvioustest.R
import com.example.obvioustest.adapters.ImageListAdapter
import com.example.obvioustest.model.SpaceImagesModel
import com.google.gson.Gson
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageListFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isImageListFragmentVisible_onLaunch() {
        onView(withId(R.id.rcvImageList)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectItem_isDetailFragmentVisible() {

        val context = InstrumentationRegistry.getInstrumentation().context
        val data = context.assets.open("data.json").bufferedReader().use { it.readText() }
        val imageListTest = Gson().fromJson(data, Array<SpaceImagesModel>::class.java).toList()

        onView(withId(R.id.rcvImageList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageListAdapter.ViewHolder>(
                3,
                click()
            )
        )

        onView(withId(R.id.tvTitle)).check(matches(withText(imageListTest[3].title)))

        pressBack()

        onView(withId(R.id.rcvImageList)).check(matches(isDisplayed()))
    }
}