package edu.pcc.alizanganeh.aihmultisportweekendapp;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import edu.pcc.alizanganeh.aihmultisportweekendapp.ui.MainActivity;

/**
 * Created by ABZanganeh on 10/18/17.
 */

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

//    @Test
//    public void validateEditText() {
//        onView(withId(R.id.ali)).perform(typeText("Ace"))
//                .check(matches(withText("Ace")));
//    }

}
