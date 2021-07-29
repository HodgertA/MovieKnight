package comp3350.movieknight.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.business.AccessMovies;
import comp3350.movieknight.tests.persistence.DatabaseStub;

public class AccessMoviesTest extends TestCase {

    private static String dbName = Main.dbName;

    public AccessMoviesTest(String arg0) {
        super(arg0);
    }

    public void testGetMoviesInTheatres() {
        System.out.println("\nStarting getMoviesInTheatres tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessMovies accessMovies = new AccessMovies();

        Movie movie1 = new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6, 8);
        Movie movie2 = new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6, 9);
        Movie movie3 = new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6, 7);
        Movie movie4 = new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 7, 26);
        Movie movie5 = new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 7, 26);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        accessMovies.getMoviesInTheatres(movies);

        assertEquals(4, movies.size());
        assertFalse(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        assertTrue(movies.contains(movie3));
        assertTrue(movies.contains(movie4));
        assertTrue(movies.contains(movie5));

        Services.closeDataAccess();
        System.out.println("\nFinished getMoviesInTheatres tests (using stub)");
    }

    public void testGetMovie() {
        System.out.println("\nStarting getMovie tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessMovies accessMovies = new AccessMovies();

        Movie movie1 = new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6, 8);
        Movie movie2 = new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6, 9);
        Movie movie3 = new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6, 7);
        Movie movie4 = new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 7, 26);
        Movie movie5 = new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 7, 26);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        accessMovies.getMoviesInTheatres(movies);

        assertEquals(movie1, accessMovies.getMovie(1));
        assertEquals(movie2, accessMovies.getMovie(2));
        assertEquals(movie3, accessMovies.getMovie(3));
        assertEquals(movie4, accessMovies.getMovie(4));
        assertEquals(movie5, accessMovies.getMovie(5));

        Services.closeDataAccess();
        System.out.println("\nFinished getMovie tests (using stub)");
    }

    public void testDeleteMovie() {
        System.out.println("\nStarting deleteMovie tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessMovies accessMovies = new AccessMovies();

        Movie movie1 = new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6, 8);
        Movie movie2 = new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6, 9);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        accessMovies.getMoviesInTheatres(movies);

        assertEquals(movie1, accessMovies.getMovie(1));
        assertEquals(movie2, accessMovies.getMovie(2));

        accessMovies.deleteMovie(movie1);
        accessMovies.deleteMovie(movie2);

        assertNull(accessMovies.getMovie(1));
        assertNull(accessMovies.getMovie(2));

        Services.closeDataAccess();
        System.out.println("\nFinished deleteMovie tests (using stub)");
    }

    public void testInsertMovie() {
        System.out.println("\nStarting insertMovie tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessMovies accessMovies = new AccessMovies();

        Movie movie = new Movie(6, "Description for Wall-E", "Wall-E", "", 120, 2021, 7, 26);

        assertNull(accessMovies.getMovie(6));

        accessMovies.insertMovie(movie);
        assertEquals(movie, accessMovies.getMovie(6));

        Services.closeDataAccess();
        System.out.println("\nFinished insertMovie tests (using stub)");
    }

    public void testUpdateMovie() {
        System.out.println("\nStarting updateMovie tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessMovies accessMovies = new AccessMovies();

        Movie movie = new Movie(5, "When Shrek and Fiona return from their honeymoon, her parents, the rulers of Far Far Away, invite them over.", "Shrek 2", "shrek", 120, 2021, 7, 26);

        assertEquals(5, accessMovies.getMovie(5).getMovieID());
        assertEquals("Description for Shrek", accessMovies.getMovie(5).getDescription());
        assertEquals("Shrek", accessMovies.getMovie(5).getTitle());

        accessMovies.updateMovie(movie);

        assertEquals(5, accessMovies.getMovie(5).getMovieID());
        assertEquals("When Shrek and Fiona return from their honeymoon, her parents, the rulers of Far Far Away, invite them over.", accessMovies.getMovie(5).getDescription());
        assertEquals("Shrek 2", accessMovies.getMovie(5).getTitle());

        Services.closeDataAccess();
        System.out.println("\nFinished updateMovie tests (using stub)");
    }
}