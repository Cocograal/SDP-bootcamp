package com.github.cocograal.bootcamp;

import androidx.core.widget.TextViewCompat;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }
    @Test
    public void testName() {
        onView(withId(R.id.editPersonNameText))
                .perform(androidx.test.espresso.action.ViewActions.typeText("John Doe"))
                .perform(androidx.test.espresso.action.ViewActions.closeSoftKeyboard());

        onView(withId(R.id.validateNameButton))
                .perform(androidx.test.espresso.action.ViewActions.click());

        Intents.intended(hasComponent(GreetingActivity.class.getName()));
    }

    @Test
    public void testWithEmptyName() {
        onView(withId(R.id.validateNameButton))
                .perform(androidx.test.espresso.action.ViewActions.click());

        Intents.intended(hasComponent(GreetingActivity.class.getName()));
    }

    @Test
    public void testWithReallyLongName() {
        String s = "John Doeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeel";
        onView(withId(R.id.editPersonNameText))
                .perform(androidx.test.espresso.action.ViewActions.typeText(s))
                .perform(androidx.test.espresso.action.ViewActions.closeSoftKeyboard());

        onView(withId(R.id.validateNameButton))
                .perform(androidx.test.espresso.action.ViewActions.click());

        Intents.intended(hasComponent(GreetingActivity.class.getName()));
    }
}


