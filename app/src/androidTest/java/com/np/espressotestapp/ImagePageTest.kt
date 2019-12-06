package com.np.espressotestapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ImagePageTest {

    companion object {
        const val WELCOME_TEXT =
            "Welcome to Espresso test. This is an Espresso test application with Page Object Pattern."
        const val DETAIL_TEXT =
            "The Espresso API encourages test authors to think in terms of what a user might do while interacting with the application - locating UI elements and interacting with them. At the same time, the framework prevents direct access to activities and views of the application because holding on to these objects and operating on them off the UI thread is a major source of test flakiness."
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun checkWelcomeTextIsVisible() {
        onView(withId(R.id.tv_detail_welcome))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkWelcomeTextMatches() {
        onView(withId(R.id.tv_detail_welcome))
            .check(matches(withText(WELCOME_TEXT)))
    }

    @Test
    fun checkDetailTextIsVisible() {
        onView(withId(R.id.tv_espresso_description))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkDetailTextMatches() {
        onView(withId(R.id.tv_espresso_description))
            .check(matches(withText(DETAIL_TEXT)))
    }

    @Test
    fun checkDetailImageVisible() {
        onView(withId(R.id.iv_detail_image))
            .check(matches(isDisplayed()))
    }

}