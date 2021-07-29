package comp3350.movieknight.tests.acceptance;

import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.hamcrest.Matchers.allOf;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewMoviesAcceptanceTest {

    @Rule
    public ActivityTestRule<MainActivity> homeActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testViewMovies() {
        onView(withText("Default User")).perform(click());
        onView(withText("LOGIN")).perform(click());

        onView(withText("MovieKnight")).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.movie_card), withText("Finding Nemo")));
        onView(allOf(withId(R.id.movie_card), withText("Shrek")));
        onView(allOf(withId(R.id.movie_card), withText("Monsters Inc.")));
        onView(allOf(withId(R.id.movie_card), withText("Ice Age")));
    }
}