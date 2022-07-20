package com.example.android_testing.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android_testing.utils.Utils
import org.hamcrest.CoreMatchers
import org.junit.Before
import com.example.android_testing.R

import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var  scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup(){
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loginWithValidCredentials() {

        // Type user name.
        Espresso.onView(withId(R.id.et_email))
            .perform(ViewActions.typeText(Utils.USER_NAME), ViewActions.closeSoftKeyboard())
        // Type valid password.
        Espresso.onView(withId(R.id.et_password))
            .perform(ViewActions.typeText(Utils.VALID_PASSWORD), ViewActions.closeSoftKeyboard())

        // Click the login button.
        Espresso.onView(withId(R.id.b_login)).perform(ViewActions.click())

        // Validate welcome string contains user name entered.
        Espresso.onView(withId(R.id.tv_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString(Utils.USER_NAME))))
    }
}