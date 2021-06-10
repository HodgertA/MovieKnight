package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Showing;

public class ShowingTest extends TestCase
{
    public ShowingTest(String arg0)
    {
        super(arg0);
    }

    public void testConstructor()
    {
        Showing showing1 = new Showing(1,1, 1,  2021,5,8,20,30);
        assertNotNull(showing1);
        assertEquals(1, showing1.getShowingID());
        assertEquals(1, showing1.getMovieID() );
        assertEquals(1, showing1.getTheatreID());
        assertEquals("2:15", showing1.getShowingTime());
        assertTrue(showing1.getSeats().isEmpty());

        try {
            Showing showing3 = new Showing(23,45, 2, 2021, 4, 1,78, 34);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing3 = new Showing(23,45, 2, 2021, 8,10,-1, 15);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing4 = new Showing(3,45, 2, 2021, 12, 23, 23, 60);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}
    }

    public void testToString()
    {
        Showing showing = new Showing(0,1, 2,2021,5,3,1, 35);
        assertEquals("Showing: 0, Movie: 1, Theatre: 2, Showing time: 2021 5 3 At 1.35", showing.toString());
    }

    public void testEquals()
    {
        Showing showing1 = new Showing(9,1, 2, 2021, 8, 6,6, 57);
        Showing showing2 = new Showing(9,1, 2, 2012, 8, 6, 6, 57);
        assertTrue(showing1.equals(showing2));
    }

}
