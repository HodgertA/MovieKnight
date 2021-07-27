package comp3350.movieknight.tests.acceptance;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(Suite.class)
@LargeTest
public class ProfileAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> homeActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testProfile() {
        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withId(R.id.list)).perform(click());
        onView(withText("LOGIN")).perform(click());
    }
}
