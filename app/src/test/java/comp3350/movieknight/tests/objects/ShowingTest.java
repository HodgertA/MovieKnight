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
        Showing showing1 = new Showing("1","1", "1",  2021,5,8,20,30);
        assertNotNull(showing1);
        assertEquals("1", showing1.getShowingID());
        assertEquals("1", showing1.getMovieID() );
        assertEquals("1", showing1.getTheatreID());
        assertEquals(20.3, showing1.getShowingTime());
        assertTrue(showing1.getSeats().isEmpty());

        Showing showing2 = new Showing("","", "",  0,0,0,0,0);
        assertNotNull(showing2);
        assertEquals("", showing2.getShowingID());
        assertEquals("", showing2.getMovieID() );
        assertEquals("", showing2.getTheatreID());
        assertEquals(0.0, showing2.getShowingTime());
        assertTrue(showing1.getSeats().isEmpty());

        try {
            Showing showing3 = new Showing("23","45", "2", 2020,3,2,99,0);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing4 = new Showing("3","45", "2", 2332, 2,3,-1,-2);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing5 = new Showing(null,null, null, 2020,3,2,1,0);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}
    }

    public void testToString()
    {
        Showing showing = new Showing("0","1", "2",2021,5,3,1, 35);
        assertEquals("Showing: 0, Movie: 1, Theatre: 2, Showing time: 2021 5 3 At 1.35", showing.toString());
    }

    public void testEquals()
    {
        Showing showing1 = new Showing("9","1", "2", 2021,4,5,6, 57);
        Showing showing2 = new Showing("9","1", "2", 2021,4,5,6, 57);
        assertTrue(showing1.equals(showing2));
    }

}
