package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Theatre;

public class TheatreTest extends TestCase {
    public TheatreTest(String arg0)
    {
        super(arg0);
    }

    public void testTypicalTheatre() {
        System.out.println("Starting Theatre test: testTypicalTheatre");

        Theatre theatre =  new Theatre(1, 10);
        assertNotNull(theatre);
        assertEquals(1,theatre.getTheatreID());
        assertEquals(10, theatre.getNumSeats());
        assertEquals("Theatre: 1, Number of seats: 10", theatre.toString());
        assertEquals(theatre,theatre);

        System.out.println("Finished Theatre test: testTypicalTheatre");
    }

    public void testTwoTheatres() {
        System.out.println("Starting Theatre test: testTwoTheatres");

        Theatre theatre1 = new Theatre(1, 10);
        Theatre theatre2 = new Theatre(2, 10);
        assertNotNull(theatre1);
        assertNotNull(theatre2);
        assertEquals(1,theatre1.getTheatreID());
        assertEquals(2,theatre2.getTheatreID());
        assertEquals(10, theatre1.getNumSeats());
        assertEquals(10, theatre2.getNumSeats());
        assertEquals("Theatre: 1, Number of seats: 10", theatre1.toString());
        assertEquals("Theatre: 2, Number of seats: 10", theatre2.toString());
        assertFalse(theatre1.equals(theatre2));

        System.out.println("Finished Theatre test: testTwoTheatres");
    }

    public void testEdgeCases() {
        System.out.println("Starting Theatre test: testEdgeCases");

        Theatre theatre = new Theatre(0, 1);
        assertNotNull(theatre);
        assertEquals(0,theatre.getTheatreID());
        assertEquals(1, theatre.getNumSeats());
        assertEquals("Theatre: 0, Number of seats: 1", theatre.toString());
        assertEquals(theatre,theatre);

        System.out.println("Finished Theatre test: testEdgeCases");
    }

    public void testInvalidValues() {
        System.out.println("Starting Theatre test: testInvalidValues");
        Theatre theatre;

        try {
            theatre = new Theatre(-1, 10);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        try {
            theatre = new Theatre(1, 0);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        System.out.println("Finished Theatre test: testInvalidValues");
    }
}