package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;
import java.util.Calendar;

import comp3350.movieknight.objects.Showing;

public class ShowingTest extends TestCase {
    public ShowingTest(String arg0)
    {
        super(arg0);
    }

    public void testTypicalShowing() {
        System.out.println("Starting Showing test: testTypicalShowing");

        Showing showing = new Showing(1, 1, 1, 12, 2021, 7, 10, 10,10);
        assertNotNull(showing);
        assertEquals(1, showing.getShowingID());
        assertEquals(1, showing.getMovieID());
        assertEquals(1, showing.getTheatreID());
        assertEquals(12, showing.getSeats());
        assertEquals(2021, showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(6, showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(10, showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(10, showing.getShowingMinute());
        assertEquals("Showing: 1, Movie: 1, Theatre: 1, Showing time: 2021 7 10 at 10:10", showing.toString());
        assertEquals(showing,showing);

        System.out.println("Finished Showing test: testTypicalUser");
    }

    public void testTwoShowings() {
        System.out.println("Starting Showing test: testTwoShowings");

        Showing showing1 = new Showing(1, 1, 1,12,2021, 7, 10, 10,10);
        Showing showing2 = new Showing(2, 2,2, 12,2021, 8, 11, 11, 11);
        assertNotNull(showing1);
        assertNotNull(showing2);
        assertEquals(1, showing1.getShowingID());
        assertEquals(2, showing2.getShowingID());
        assertEquals(1, showing1.getMovieID());
        assertEquals(2, showing2.getMovieID());
        assertEquals(1, showing1.getTheatreID());
        assertEquals(2, showing2.getTheatreID());
        assertEquals(12, showing1.getSeats());
        assertEquals(12, showing2.getSeats());
        assertEquals(2021, showing1.getShowingDate().get(Calendar.YEAR));
        assertEquals(2021, showing2.getShowingDate().get(Calendar.YEAR));
        assertEquals(6, showing1.getShowingDate().get(Calendar.MONTH));
        assertEquals(7, showing2.getShowingDate().get(Calendar.MONTH));
        assertEquals(10, showing1.getShowingDate().get(Calendar.DATE));
        assertEquals(11, showing2.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing1.getShowingHour());
        assertEquals(10, showing1.getShowingMinute());
        assertEquals(11, showing2.getShowingHour());
        assertEquals(11, showing2.getShowingMinute());
        assertEquals("Showing: 1, Movie: 1, Theatre: 1, Showing time: 2021 7 10 at 10:10", showing1.toString());
        assertEquals("Showing: 2, Movie: 2, Theatre: 2, Showing time: 2021 8 11 at 11:11", showing2.toString());
        assertFalse(showing1.equals(showing2));

        System.out.println("Finished Showing test: testTwoShowings");
    }

    public void testEdgeCases() {
        System.out.println("Starting Showing test: testEdgeCases");

        Showing showing = new Showing(0, 0, 0, 1,1, 1, 1, 10,10);
        assertNotNull(showing);
        assertEquals(0, showing.getShowingID());
        assertEquals(0, showing.getMovieID());
        assertEquals(0, showing.getTheatreID());
        assertEquals(1, showing.getSeats());
        assertEquals(1, showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(0, showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(1, showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(10, showing.getShowingMinute());
        assertEquals("Showing: 0, Movie: 0, Theatre: 0, Showing time: 1 1 1 at 10:10", showing.toString());
        assertEquals(showing,showing);

        System.out.println("Finished Showing test: testEdgeCases");
    }

    public void testInvalidValues() {
        System.out.println("Starting Showing test: testInvalidValues");

        Showing showing;
        try {
            showing = new Showing(-1, 1,1,1,1, 1,1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, -1,1,1,1, 1,1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,-1,1,1, 1,1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,1,0,1, 1,1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,1,1,1, 13,1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,1,1,1, 1,-1, 1, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,1,1,1, 1,1, 25, 1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            showing = new Showing(1, 1,1,1,1, 1,1, 1, 65);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        System.out.println("Finished Showing test: testInvalidValues");
    }

}
