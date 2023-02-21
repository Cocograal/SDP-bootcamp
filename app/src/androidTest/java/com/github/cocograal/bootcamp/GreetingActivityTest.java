package com.github.cocograal.bootcamp;


import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Ordering;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void testGetRightIntents() {
        Intent intents = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intents.putExtra("name", "John Doe");
        try {
            ActivityScenario.launch(intents);
        } catch (Exception e) {
            e.printStackTrace();
        }

        onView(withId(R.id.greetingMessage))
                .check(matches(withText("Welcome John Doe")));
    }
}
