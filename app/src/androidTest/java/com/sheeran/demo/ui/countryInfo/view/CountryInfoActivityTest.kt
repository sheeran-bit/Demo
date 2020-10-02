package com.sheeran.demo.ui.countryInfo.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.sheeran.demo.R
import com.sheeran.demo.ui.countryInfo.view.CustomAssertions.Companion.hasItemCount
import com.sheeran.demo.ui.countryInfo.view.CustomMatchers.Companion.withItemCount
import org.junit.Rule
import org.junit.Test

class CountryInfoActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(CountryInfoActivity::class.java)

    @Test
    fun countItems() {
        onView(withId(R.id.rvCountryInfo))
                .check(matches(withItemCount(12)))
    }

    @Test
    fun countItemsWithViewAssertion() {
        onView(withId(R.id.rvCountryInfo))
                .check(hasItemCount(12))
    }
}

