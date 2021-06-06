package comp3350.movieknight.Objects;

import junit.framework.TestCase;

public class ShowingTest extends TestCase
{
    public ShowingTest(String arg0)
    {
        super(arg0);
    }

    public void testConstructor()
    {
        Showing showing1 = new Showing("1", "1",  2,15);
        assertEquals("1", showing1.getMovieID() );
        assertEquals("1", showing1.getTheatreID());
        assertEquals("2:15", showing1.getShowingTime());

        Showing showing2 = new Showing("", "",  0,0);
        assertEquals("", showing2.getMovieID() );
        assertEquals("", showing2.getTheatreID());
        assertEquals("0:0", showing2.getShowingTime());

        try {
            Showing showing3 = new Showing("45", "2", 78, 34);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing4 = new Showing("45", "2", 23, 60);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}

        try {
            Showing showing5 = new Showing(null, null, 23, 60);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException ex) {}
    }

    public void testToString()
    {
        Showing showing = new Showing("1", "2",1, 35);
        assertEquals("Movie: 1, Theatre: 2, Showing Time: 1:35", showing.toString());
    }

    public void testEquals()
    {
        Showing showing1 = new Showing("1", "2", 6, 57);
        Showing showing2 = new Showing("1", "2", 6, 57);
        assertTrue(showing1.equals(showing2));
    }

}
