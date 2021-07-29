package comp3350.movieknight.tests.acceptance;

import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SendTicketAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSendTicket() {
        onView(withText("Default User")).perform(click());
        onView(withText("LOGIN")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withId(R.id.nav_movie_list)).check(matches(isDisplayed()));
        onView(withId(R.id.nav_tickets)).check(matches(isDisplayed()));

        onView(withId(R.id.nav_tickets)).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withId(R.id.tickets_recycler_view)).check(matches(isDisplayed()));

        onView(withId(R.id.tickets_recycler_view)).perform(swipeUp());
        onView(withText("Ice Age")).perform(click());

        onView(withText("YES!!")).perform(click());

        onView(withText("Ice Age")).check(doesNotExist());

        onView(withText("LOGOUT")).perform(click());

        onView(withText("User2")).perform(click());
        onView(withText("LOGIN")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withId(R.id.nav_movie_list)).check(matches(isDisplayed()));
        onView(withId(R.id.nav_tickets)).check(matches(isDisplayed()));

        onView(withId(R.id.nav_tickets)).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(withId(R.id.tickets_recycler_view)).check(matches(isDisplayed()));

        onView(withId(R.id.tickets_recycler_view)).perform(swipeUp());
        onView(withText("Ice Age")).check(matches(isDisplayed()));

        //send it back so we can run the test again
        onView(withText("Ice Age")).perform(click());
        onView(withText("YES!!")).perform(click());
    }
}
