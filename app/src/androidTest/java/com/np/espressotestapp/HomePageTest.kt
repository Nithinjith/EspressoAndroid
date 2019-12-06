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
class HomePageTest {

    companion object {
        const val LIST_BTN_TEXT = "List"
        const val DETAIL_BTN_TEXT = "Details"
        const val EXIT_BTN_TEXT = "Exit"
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkDetailScreenButtonIsVisible() {
        onView(withId(R.id.btn_detail)).check(matches(isDisplayed()))
    }

    @Test
    fun checkDetailScreenBtnIsClickable() {
        onView(withId(R.id.btn_detail))
            .check(matches(isClickable()))
    }

    @Test
    fun checkDetailScreenBtnIsEnabled() {
        onView(withId(R.id.btn_detail))
            .check(matches(isEnabled()))
    }

    @Test
    fun checkDetailScreenBtnText() {
        onView(withId(R.id.btn_detail))
            .check(matches(withText(DETAIL_BTN_TEXT)))
    }

    @Test
    fun checkListScreenBtnIsVisible() {
        onView(withId(R.id.btn_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkListScreenBtnIsClickable() {
        onView(withId(R.id.btn_list))
            .check(matches(isClickable()))
    }

    @Test
    fun checkListScreenBtnIsEnabled() {
        onView(withId(R.id.btn_list))
            .check(matches(isEnabled()))
    }

    @Test
    fun checkListScreenBtnTxt() {
        onView(withId(R.id.btn_list))
            .check(matches(withText(LIST_BTN_TEXT)))
    }

    @Test
    fun checkExitScreenBtnIsVisible() {
        onView(withId(R.id.btn_exit)).check(matches(isDisplayed()))
    }

    @Test
    fun checkExitScreenBtnIsClickable() {
        onView(withId(R.id.btn_exit))
            .check(matches(isClickable()))
    }

    @Test
    fun checkExitScreenBtnIsEnabled() {
        onView(withId(R.id.btn_exit))
            .check(matches(isEnabled()))
    }

    @Test
    fun checkExitScreenBtnIsTxt() {
        onView(withId(R.id.btn_exit))
            .check(matches(withText(EXIT_BTN_TEXT)))
    }

    @Test
    fun checkHomeImageIsVisible() {
        onView(withId(R.id.iv_home_image)).check(matches(isDisplayed()))
    }

}