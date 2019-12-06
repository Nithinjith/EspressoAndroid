package com.np.espressotestapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
class LoginPageTest {

    companion object{
        const val USERNAME_TYPED = "Nithinjith"
        const val PASSWORD_TYPED = "123456"
        const val USERNAME_HINT = "User Name"
        const val PASSWORD_HINT = "Password"
    }


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkLoginUserNameFieldIsVisible() {
//        launchFragmentInContainer<LoginFragment>()
        onView(withId(R.id.et_username))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginPasswordFiledIsVisible() {
        onView(withId(R.id.et_password)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginUserNameHint() {
        onView(withId(R.id.et_username)).check(matches(withHint(USERNAME_HINT)))
    }

    @Test
    fun checkPasswordHint() {
        onView(withId(R.id.et_password)).check(matches(withHint(PASSWORD_HINT)))
    }

    @Test
    fun checkLoginButtonIsVisible() {
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginButtonIsClickable() {
        onView(withId(R.id.btn_login))
            .check(matches(isClickable()))
    }

    @Test
    fun checkLoginButtonIsEnabled() {
        onView(withId(R.id.btn_login))
            .check(matches(isEnabled()))
    }

    @Test
    fun checkLoginButtonPerformClick() {
        onView(withId(R.id.btn_login))
            .check(matches(isEnabled()))
    }


    @Test
    fun changeText_sameActivity() {
        onView(withId(R.id.et_username))
            .perform(ViewActions.typeText(USERNAME_TYPED), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_password))
            .perform(ViewActions.typeText(PASSWORD_TYPED), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_username)).check(matches(withText(USERNAME_TYPED)))
        onView(withId(R.id.et_password)).check(matches(withText(PASSWORD_TYPED)))
        onView(withId(R.id.btn_login)).perform(ViewActions.click())
    }

}