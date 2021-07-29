package comp3350.movieknight.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.business.FilterList;
import comp3350.movieknight.objects.Movie;

public class FilterMoviesTest extends TestCase {

    public FilterMoviesTest(String arg0)
    {
        super(arg0);
    }

    public void testNullList() {
        System.out.println("Starting filter movies test: testNullList");

        ArrayList<Movie> movies = null;

        try {
            FilterList.filterMoviesInTheatres(movies);
            fail("Expected an NullPointerException");
        } catch (NullPointerException ex) {}

        System.out.println("Finished filter movies test: testNullList");

    }

    public void testEmptyList() {
        System.out.println("Starting filter movies test: testEmptyList");

        ArrayList<Movie> movies = new ArrayList<Movie>();

        FilterList.filterMoviesInTheatres(movies);
        assertTrue(movies.isEmpty());

        System.out.println("Finished filter movies test: testEmptyList");
    }

    public void testOneMovieInTheatres() {
        System.out.println("Starting filter movies test: testOneMovieInTheatres");

        Calendar calendar = Calendar.getInstance();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie = new Movie(5, "", "Shrek", "poster", 120, calendar.get(Calendar.YEAR)+1, calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
        movies.add(movie);
        assertEquals(1, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertFalse(movies.isEmpty());
        assertEquals(1, movies.size());
        assertTrue(movies.contains(movie));

        System.out.println("Finished filter movies test: testOneMovieInTheatres");
    }

    public void testOneMovieNotInTheatres() {
        System.out.println("Starting filter movies test: testOneMovieNotInTheatres");

        Calendar calendar = Calendar.getInstance();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie(5, "", "Shrek", "poster", 120, calendar.get(Calendar.YEAR-1), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH)));
        assertEquals(1, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertTrue(movies.isEmpty());

        System.out.println("Finished filter movies test: testOneMovieNotInTheatres");
    }

    public void testAllMoviesNotInTheatres() {
        System.out.println("Starting filter movies test: testAllMoviesNotInTheatres");

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar lastMonth = Calendar.getInstance();
        lastMonth.add(Calendar.MONTH, -1);
        Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie(1, "", "Shrek", "poster", 120, yesterday.get(Calendar.YEAR), yesterday.get(Calendar.MONTH)+1, yesterday.get(Calendar.DATE)));
        movies.add(new Movie(2, "", "Finding Nemo", "poster", 120, lastMonth.get(Calendar.YEAR), lastMonth.get(Calendar.MONTH)+1, lastMonth.get(Calendar.DATE)));
        movies.add(new Movie(3, "", "Ice Age", "poster", 120, lastYear.get(Calendar.YEAR), lastYear.get(Calendar.MONTH)+1, lastYear.get(Calendar.DATE)));
        assertEquals(3, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertTrue(movies.isEmpty());

        System.out.println("Finished filter movies test: testAllMoviesNotInTheatres");
    }

    public void testAllMoviesInTheatres() {

        System.out.println("Starting filter movies test: testAllMoviesInTheatres");

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(Calendar.MONTH, 1);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie1 = new Movie(1, "", "Shrek", "poster", 120, tomorrow.get(Calendar.YEAR), tomorrow.get(Calendar.MONTH)+1, tomorrow.get(Calendar.DATE));
        movies.add(movie1);
        Movie movie2 = new Movie(2, "", "Finding Nemo", "poster", 120, nextMonth.get(Calendar.YEAR), nextMonth.get(Calendar.MONTH)+1, nextMonth.get(Calendar.DATE));
        movies.add(movie2);
        Movie movie3 = new Movie(3, "", "Ice Age", "poster", 120, nextYear.get(Calendar.YEAR), nextYear.get(Calendar.MONTH)+1, nextYear.get(Calendar.DATE));
        movies.add(movie3);
        assertEquals(3, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertEquals(3, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        assertTrue(movies.contains(movie3));

        System.out.println("Finished filter movies test: testAllMoviesNotInTheatres");
    }

    public void testLastDayInTheatres() {
        System.out.println("Starting filter movies test: testLastDayInTheatres");

        Calendar today = Calendar.getInstance();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie = new Movie(5, "", "Shrek", "poster", 120, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DAY_OF_MONTH));
        movies.add(movie);
        assertEquals(1, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertFalse(movies.isEmpty());
        assertEquals(1, movies.size());
        assertTrue(movies.contains(movie));

        System.out.println("Finished filter movies test: testLastDayInTheatres");
    }

    public void testDayBeforeLastDayInTheatres() {
        System.out.println("Starting filter movies test: testDayBeforeLastDayInTheatres");

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie = new Movie(5, "", "Shrek", "poster", 120, tomorrow.get(Calendar.YEAR), tomorrow.get(Calendar.MONTH)+1, tomorrow.get(Calendar.DAY_OF_MONTH));
        movies.add(movie);
        assertEquals(1, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertFalse(movies.isEmpty());
        assertEquals(1, movies.size());
        assertTrue(movies.contains(movie));

        System.out.println("Finished filter movies test: testDayBeforeLastDayInTheatres");
    }

    public void testDayAfterLastDayInTheatres() {
        System.out.println("Starting filter movies test: testDayBeforeLastDayInTheatres");

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie = new Movie(5, "", "Shrek", "poster", 120, yesterday.get(Calendar.YEAR), yesterday.get(Calendar.MONTH)+1, yesterday.get(Calendar.DAY_OF_MONTH));
        movies.add(movie);
        assertEquals(1, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertTrue(movies.isEmpty());

        System.out.println("Finished filter movies test: testDayBeforeLastDayInTheatres");
    }

    public void testNormalCase() {
        System.out.println("Starting filter movies test: testNormalCase");

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar lastMonth = Calendar.getInstance();
        lastMonth.add(Calendar.MONTH, -1);
        Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(Calendar.MONTH, 1);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movieNotPlaying1 = new Movie(5, "", "Shrek", "poster", 120, yesterday.get(Calendar.YEAR), yesterday.get(Calendar.MONTH)+1, yesterday.get(Calendar.DATE));
        movies.add(movieNotPlaying1);
        Movie movieNotPlaying2 = new Movie(5, "", "Finding Nemo", "poster", 120, lastMonth.get(Calendar.YEAR), lastMonth.get(Calendar.MONTH)+1, lastMonth.get(Calendar.DATE));
        movies.add(movieNotPlaying2);
        Movie movieNotPlaying3 = new Movie(5, "", "Ice Age", "poster", 120, lastYear.get(Calendar.YEAR), lastYear.get(Calendar.MONTH)+1, lastYear.get(Calendar.DATE));
        movies.add(movieNotPlaying3);
        Movie moviePlaying1 = new Movie(1, "", "Shrek", "poster", 120, tomorrow.get(Calendar.YEAR), tomorrow.get(Calendar.MONTH)+1, tomorrow.get(Calendar.DATE));
        movies.add(moviePlaying1);
        Movie moviePlaying2 = new Movie(2, "", "Finding Nemo", "poster", 120, nextMonth.get(Calendar.YEAR), nextMonth.get(Calendar.MONTH)+1, nextMonth.get(Calendar.DATE));
        movies.add(moviePlaying2);
        Movie moviePlaying3 = new Movie(3, "", "Ice Age", "poster", 120, nextYear.get(Calendar.YEAR), nextYear.get(Calendar.MONTH)+1, nextYear.get(Calendar.DATE));
        movies.add(moviePlaying3);
        assertEquals(6, movies.size());

        FilterList.filterMoviesInTheatres(movies);
        assertEquals(3, movies.size());
        assertTrue(movies.contains(moviePlaying1));
        assertTrue(movies.contains(moviePlaying2));
        assertTrue(movies.contains(moviePlaying3));
        assertFalse(movies.contains(movieNotPlaying1));
        assertFalse(movies.contains(movieNotPlaying2));
        assertFalse(movies.contains(movieNotPlaying3));

        System.out.println("Finished filter movies test: testNormalCase");
    }
}

