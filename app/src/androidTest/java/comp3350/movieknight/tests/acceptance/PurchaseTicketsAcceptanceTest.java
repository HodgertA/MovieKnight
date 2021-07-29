package comp3350.movieknight.tests.acceptance;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PurchaseTicketsAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> homeActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testPurchaseTickets() {

        AccessTickets at = new AccessTickets();
        at.deleteTicket(new Ticket(4,4,1));

        onView(withText("NoTickets")).perform(click());
        onView(withText("LOGIN")).perform(click());

        onView(allOf(withId(R.id.movie_card), withText("Finding Nemo")));

        onView(withText("Finding Nemo")).check(matches(isDisplayed())).perform(click());
        onView(allOf(withId(R.id.movie_card), withText("9:55")));
        onView(allOf(withId(R.id.movie_card), withText("10:55")));
        onView(allOf(withId(R.id.movie_card), withText("11:55")));

        onView(withText("10:55")).check(matches(isDisplayed())).perform(click());
        onView(withText("Screen")).check(matches(isDisplayed()));
        onView(withText("CHECKOUT")).check(matches(isDisplayed()));

        onView(ViewMatchers.withId(R.id.seats_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        onView(withText("CHECKOUT")).perform(click());

        onView(withText("Order Summary")).check(matches(isDisplayed()));
        onView(withText("Movie Name:")).check(matches(isDisplayed()));
        onView(withText("Movie Time:")).check(matches(isDisplayed()));
        onView(withText("Seat Number:")).check(matches(isDisplayed()));
        onView(withText("Num of Ticket(s):")).check(matches(isDisplayed()));
        onView(withText("Finding Nemo")).check(matches(isDisplayed()));

        onView(withText("PAY THE BILL")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));

        onView(withId(R.id.nav_tickets)).perform(click());
        onView(withId(R.id.tickets_recycler_view)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.ticket_movie_title), withText("Finding Nemo")));

        at.deleteTicket(new Ticket(4,4,1));
    }
}