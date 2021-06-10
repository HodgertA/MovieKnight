package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.User;

public class TheatreTest extends TestCase
{
    public TheatreTest(String arg0)
    {
        super(arg0);
    }

    public void testTypicalTheatre()
    {
        System.out.println("Starting Theatre test: testTypicalTheatre");

        Theatre theatre =  new Theatre(1, 10);
        assertNotNull(theatre);
        assertEquals(1,theatre.getTheatreNumber());
        assertEquals(10, theatre.getNumberOfSeatsInRoom());
        assertEquals("Theatre #1 can seat 10 people", theatre.toString());
        assertTrue(theatre.equals(theatre));

        System.out.println("Finished Theatre test: testTypicalTheatre");
    }

    public void testTwoTheatres()
    {
        System.out.println("Starting Theatre test: testTwoTheatres");

        Theatre theatre1 =  new Theatre(1, 10);
        Theatre theatre2 = new Theatre(2, 10);
        assertNotNull(theatre1);
        assertNotNull(theatre2);
        assertEquals(1,theatre1.getTheatreNumber());
        assertEquals(2,theatre2.getTheatreNumber());
        assertEquals(10, theatre1.getNumberOfSeatsInRoom());
        assertEquals(10, theatre2.getNumberOfSeatsInRoom());
        assertEquals("Theatre #1 can seat 10 people", theatre1.toString());
        assertEquals("Theatre #2 can seat 10 people", theatre2.toString());
        assertFalse(theatre1.equals(theatre2));

        System.out.println("Finished Theatre test: testTwoTheatres");
    }

    public void testEdgeCases()
    {
        System.out.println("Starting Theatre test: testEdgeCases");

        Theatre theatre =  new Theatre(0, 1);
        assertNotNull(theatre);
        assertEquals(0,theatre.getTheatreNumber());
        assertEquals(1, theatre.getNumberOfSeatsInRoom());
        assertEquals("Theatre #0 can seat 1 people", theatre.toString());
        assertTrue(theatre.equals(theatre));

        System.out.println("Finished Theatre test: testEdgeCases");
    }

    public void testInvalidValues()
    {
        System.out.println("Starting Theatre test: testInvalidValues");
        Theatre theatre;

        try {
            theatre = new Theatre(-1, 10);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            theatre = new Theatre(1, 0);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        System.out.println("Finished Theatre test: testInvalidValues");
    }
}