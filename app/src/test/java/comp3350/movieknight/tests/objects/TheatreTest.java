package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Theatre;

public class TheatreTest extends TestCase
{
    public TheatreTest(String arg0)
    {
        super(arg0);
    }

    public void testTheatreConstructor()
    {
        Theatre theatre;

        System.out.println("\nStarting testTheatreConstructor");

        theatre = new Theatre(4, 200);
        assertNotNull(theatre);
        assertEquals(4, theatre.getTheatreNumber());

        System.out.println("Finished testTheatreConstructor");
    }

    public void testTheatreToString()
    {
        Theatre theatre;

        System.out.println("\nStarting testTheatreToString");

        theatre = new Theatre(1, 39);

        assertEquals("Theatre #1 can seat 39 people", theatre.toString());

        System.out.println("Finished testTheatreToString");
    }

    public void testEquals()
    {
        Theatre theatre;
        Theatre theatreCopy;

        System.out.println("\nStarting testTheatreEquals");

        theatre = new Theatre(6, 60);
        theatreCopy = new Theatre(6, 60);
        assertNotNull(theatre);
        assertNotNull(theatreCopy);
        assertEquals(theatre,theatreCopy);

        System.out.println("Finished testTheatreEquals");
    }
}