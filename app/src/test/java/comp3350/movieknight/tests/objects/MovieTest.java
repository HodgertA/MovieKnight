package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Movie;

public class MovieTest extends TestCase
{
    public MovieTest(String arg0)
    {
        super(arg0);
    }

    public void testMovieConstructor1()
    {
        Movie movie;

        System.out.println("\nStarting testMovieConstructor1");

        movie = new Movie("123");
        assertNotNull(movie);
        assertEquals("123", movie.getMovieID());
        assertNull(movie.getDescription());
        assertNull(movie.getTitle());
        assertEquals(movie.getRuntime(), 0);

        System.out.println("Finished testMovieConstructor1");
    }

    public void testMovieConstructor2()
    {
        Movie movie;

        System.out.println("\nStarting testMovieConstructor2");

        movie = new Movie("123", "A movie about a bee", "The Bee Movie", 95);
        assertNotNull(movie);
        assertEquals("123", movie.getMovieID());
        assertEquals("A movie about a bee", movie.getDescription());
        assertEquals("The Bee Movie", movie.getTitle());
        assertEquals(movie.getRuntime(), 95);

        System.out.println("Finished testMovieConstructor2");
    }

    public void testToString()
    {
        Movie movie;

        System.out.println("\nStarting testToString");

        movie = new Movie("123", "A movie about a bee", "The Bee Movie", 95);
        assertNotNull(movie);
        assertEquals("Movie: 123 The Bee Movie", movie.toString());

        System.out.println("Finished testToString");
    }

    public void testMovieEquals()
    {
        Movie movie1;
        Movie movie2;

        System.out.println("\nStarting testMovieEquals");

        movie1 = new Movie("123", "A movie about a bee", "The Bee Movie", 95);
        movie2 = new Movie("123", "A movie about a bee", "The Bee Movie", 95);
        assertNotNull(movie1);
        assertNotNull(movie2);
        assertTrue(movie1.equals(movie2));

        System.out.println("Finished testMovieEquals");
    }
}
