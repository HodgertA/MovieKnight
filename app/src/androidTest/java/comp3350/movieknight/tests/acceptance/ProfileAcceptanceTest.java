package comp3350.movieknight.tests.acceptance;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> homeActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testLogin() {
        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withText("Select User:")).check(matches(isDisplayed()));
        onView(withText("Default User")).check(matches(isDisplayed()));
        onView(withText("User2")).check(matches(isDisplayed()));
        onView(withText("User3")).check(matches(isDisplayed()));
        onView(withId(R.id.list)).perform(click());
        onView(withText("LOGIN")).perform(click());
    }

    @Test
    public void testLogout() {
        onView(withText("Default User")).perform(click());
        onView(withText("LOGIN")).perform(click());
        onView(withText("LOGOUT")).perform(click());
        onView(withText("Select User:")).check(matches(isDisplayed()));
    }
}
