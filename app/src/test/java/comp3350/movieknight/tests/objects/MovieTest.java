package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import java.util.Calendar;

import comp3350.movieknight.objects.Movie;

public class MovieTest extends TestCase {
    public MovieTest(String arg0)
    {
        super(arg0);
    }

    public void testTypicalMovie() {
        System.out.println("Starting Movie test: testTypicalMovie");

        Movie movie1 = new Movie(1);
        assertNotNull(movie1);
        assertEquals(1, movie1.getMovieID());
        assertEquals("Movie: 1 null", movie1.toString());
        assertEquals(movie1,movie1);

        Movie movie2 = new Movie(1, "A description", "A title","poster", 100, 2021, 10, 20);
        assertNotNull(movie2);
        assertEquals(1, movie2.getMovieID());
        assertEquals("A description", movie2.getDescription());
        assertEquals("A title", movie2.getTitle());
        assertEquals("poster", movie2.getPoster());
        assertEquals(100, movie2.getRuntime());
        assertEquals(2021, movie2.getLastShowDate().get(Calendar.YEAR));
        assertEquals(9, movie2.getLastShowDate().get(Calendar.MONTH));
        assertEquals(20, movie2.getLastShowDate().get(Calendar.DATE));
        assertEquals("Movie: 1 A title", movie2.toString());
        assertEquals(movie2,movie2);
        assertEquals(movie1,movie2);

        System.out.println("Finished Movie test: testTypicalMovie");
    }

    public void testEmptyValues() {
        System.out.println("Starting Movie test: testEmptyValues");

        Movie movie1 = new Movie(1, "", "","", 100, 2021, 10, 20);
        assertNotNull(movie1);
        assertEquals(1, movie1.getMovieID());
        assertEquals("", movie1.getDescription());
        assertEquals("", movie1.getTitle());
        assertEquals("", movie1.getPoster());
        assertEquals(100, movie1.getRuntime());
        assertEquals(2021, movie1.getLastShowDate().get(Calendar.YEAR));
        assertEquals(9, movie1.getLastShowDate().get(Calendar.MONTH));
        assertEquals(20, movie1.getLastShowDate().get(Calendar.DATE));
        assertEquals("Movie: 1 ", movie1.toString());
        assertEquals(movie1,movie1);

        System.out.println("Finished Movie test: testEmptyValues");
    }

    public void testTwoMovies() {
        System.out.println("Starting Movie test: testTwoMovies");

        Movie movie1 = new Movie(1);
        Movie movie2 = new Movie (2);
        assertNotNull(movie1);
        assertNotNull(movie2);
        assertEquals(1, movie1.getMovieID());
        assertEquals(2, movie2.getMovieID());
        assertEquals("Movie: 1 null", movie1.toString());
        assertEquals("Movie: 2 null", movie2.toString());
        assertFalse(movie1.equals(movie2));

        Movie movie3 = new Movie(1, "A description", "A title","poster1", 100, 2021, 10, 20);
        Movie movie4 = new Movie(2, "description", "title","poster2", 200, 2021, 5, 2);
        assertNotNull(movie3);
        assertNotNull(movie4);
        assertEquals(1, movie3.getMovieID());
        assertEquals(2, movie4.getMovieID());
        assertEquals("A description", movie3.getDescription());
        assertEquals("description", movie4.getDescription());
        assertEquals("A title", movie3.getTitle());
        assertEquals("title", movie4.getTitle());
        assertEquals("poster1", movie3.getPoster());
        assertEquals("poster2", movie4.getPoster());
        assertEquals(100, movie3.getRuntime());
        assertEquals(200, movie4.getRuntime());
        assertEquals(2021, movie3.getLastShowDate().get(Calendar.YEAR));
        assertEquals(2021, movie4.getLastShowDate().get(Calendar.YEAR));
        assertEquals(9, movie3.getLastShowDate().get(Calendar.MONTH));
        assertEquals(4, movie4.getLastShowDate().get(Calendar.MONTH));
        assertEquals(20, movie3.getLastShowDate().get(Calendar.DATE));
        assertEquals(2, movie4.getLastShowDate().get(Calendar.DATE));
        assertEquals("Movie: 1 A title", movie3.toString());
        assertEquals("Movie: 2 title", movie4.toString());
        assertEquals(movie3,movie3);

        System.out.println("Finished Movie test: testTwoMovies");
    }

    public void testNullValues() {
        System.out.println("Starting Movie test: testNullValues");

        Movie movie1 = new Movie(1, null, null,null, 100, 2021, 10, 20);
        assertNotNull(movie1);
        assertEquals(1, movie1.getMovieID());
        assertNull(movie1.getDescription());
        assertNull(movie1.getTitle());
        assertNull(movie1.getPoster());
        assertEquals(100, movie1.getRuntime());
        assertEquals(2021, movie1.getLastShowDate().get(Calendar.YEAR));
        assertEquals(9, movie1.getLastShowDate().get(Calendar.MONTH));
        assertEquals(20, movie1.getLastShowDate().get(Calendar.DATE));
        assertEquals("Movie: 1 null", movie1.toString());
        assertEquals(movie1,movie1);

        System.out.println("Finished Movie test: testNullValues");
    }

    public void testEdgeCases() {
        System.out.println("Starting Movie test: testEdgeCases");

        Movie movie1 = new Movie(0);
        assertNotNull(movie1);
        assertEquals(0, movie1.getMovieID());
        assertEquals("Movie: 0 null", movie1.toString());
        assertEquals(movie1,movie1);

        Movie movie2 = new Movie(0, "A description", "A title","poster", 1, 2021, 1, 31);
        assertNotNull(movie2);
        assertEquals(0, movie2.getMovieID());
        assertEquals("A description", movie2.getDescription());
        assertEquals("A title", movie2.getTitle());
        assertEquals("poster", movie2.getPoster());
        assertEquals(1, movie2.getRuntime());
        assertEquals(2021, movie2.getLastShowDate().get(Calendar.YEAR));
        assertEquals(0, movie2.getLastShowDate().get(Calendar.MONTH));
        assertEquals(31, movie2.getLastShowDate().get(Calendar.DATE));
        assertEquals("Movie: 0 A title", movie2.toString());
        assertEquals(movie2,movie2);

        System.out.println("Finished Movie test: testEdgeCases");
    }

    public void testInvalidValues() {
        System.out.println("Starting Movie test: testInvalidValues");

        Movie movie;
        try {
            movie = new Movie(-1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            movie = new Movie(-1, "A description", "A title","poster", 1, 2021, 1, 31);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            movie = new Movie(0, "A description", "A title","poster", -1, 2021, 1, 31);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            movie = new Movie(0, "A description", "A title","poster", 1, 2021, 13, 31);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            movie = new Movie(0, "A description", "A title","poster", 1, 2021, 1, 35);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        System.out.println("Finished Movie test: testInvalidValues");
    }
}
