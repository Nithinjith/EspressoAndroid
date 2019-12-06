package com.np.espressotestapp


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginPageTest2 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginPageTest2() {
        val editText = onView(
            allOf(
                withId(R.id.et_username), withText("User Name"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
//        editText.check(matches(isDisplayed()))

        val editText2 = onView(
            allOf(
                withId(R.id.et_username), withText("User Name"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
//        editText2.check(matches(isDisplayed()))

        val editText3 = onView(
            allOf(
                withId(R.id.et_username), withText("User Name"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText3.check(matches(isDisplayed()))

        val appCompatEditText = onView(
            allOf(
                withId(R.id.et_username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Nith"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.et_username), withText("Nith"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.et_username), withText("Nith"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("Nithinjith"))

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.et_username), withText("Nithinjith"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.et_password),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("1234"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.et_password), withText("1234"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(pressImeActionButton())

        val appCompatButton = onView(
            allOf(
                withId(R.id.btn_login), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fl_fragment_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
