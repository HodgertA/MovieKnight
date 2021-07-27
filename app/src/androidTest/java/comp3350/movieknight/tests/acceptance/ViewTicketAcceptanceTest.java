package comp3350.movieknight.tests.acceptance;

import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewTicketAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testLoginScreen() {
        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withText("Select User:")).check(matches(isDisplayed()));
        onView(withText("Default User")).check(matches(isDisplayed()));
        onView(withText("User2")).check(matches(isDisplayed()));
        onView(withText("User3")).check(matches(isDisplayed()));
        onView(withText("LOGIN")).check(matches(isDisplayed()));
    }

    @Test
    public void testViewTickets() {
        onView(withText("Default User")).perform(click());
        onView(withText("LOGIN")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withText("Movies")).check(matches(isDisplayed()));
        onView(withText("My Tickets")).check(matches(isDisplayed()));

        onView(withText("My Tickets")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));

    }
}
