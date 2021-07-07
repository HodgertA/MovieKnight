package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.movieknight.objects.Seat;
import comp3350.movieknight.objects.Theatre;

public class TheatreTest extends TestCase
{
    public TheatreTest(String arg0)
    {
        super(arg0);
    }
    private ArrayList<Seat> seats;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        seats = new ArrayList<>();
        seats.add(new Seat(1,false));
        seats.add(new Seat(2,false));
        seats.add(new Seat(3,false));
        seats.add(new Seat(4,false));
        seats.add(new Seat(5,false));
        seats.add(new Seat(6,false));
        seats.add(new Seat(7,false));
        seats.add(new Seat(8,false));
        seats.add(new Seat(9,false));
        seats.add(new Seat(10,false));

    }

    public void testTypicalTheatre()
    {
        System.out.println("Starting Theatre test: testTypicalTheatre");
        Theatre theatre =  new Theatre(1, seats);
        assertNotNull(theatre);
        assertEquals(1,theatre.getTheatreNumber());
        assertEquals(10, theatre.getNumSeats());
        assertEquals("Theatre: 1, Number of seats: 10", theatre.toString());
        assertTrue(theatre.equals(theatre));

        System.out.println("Finished Theatre test: testTypicalTheatre");
    }

    public void testTwoTheatres()
    {
        System.out.println("Starting Theatre test: testTwoTheatres");

        Theatre theatre1 =  new Theatre(1, seats);
        Theatre theatre2 = new Theatre(2, seats);
        assertNotNull(theatre1);
        assertNotNull(theatre2);
        assertEquals(1,theatre1.getTheatreNumber());
        assertEquals(2,theatre2.getTheatreNumber());
        assertEquals(10, theatre1.getNumSeats());
        assertEquals(10, theatre2.getNumSeats());
        assertEquals("Theatre: 1, Number of seats: 10", theatre1.toString());
        assertEquals("Theatre: 2, Number of seats: 10", theatre2.toString());
        assertFalse(theatre1.equals(theatre2));

        System.out.println("Finished Theatre test: testTwoTheatres");
    }

    public void testEdgeCases()
    {
        System.out.println("Starting Theatre test: testEdgeCases");

        Theatre theatre =  new Theatre(0, seats);
        assertNotNull(theatre);
        assertEquals(0,theatre.getTheatreNumber());
        assertEquals(10, theatre.getNumSeats());
        assertEquals("Theatre: 0, Number of seats: 1", theatre.toString());
        assertTrue(theatre.equals(theatre));

        System.out.println("Finished Theatre test: testEdgeCases");
    }

    public void testInvalidValues()
    {
        System.out.println("Starting Theatre test: testInvalidValues");
        Theatre theatre;

        try {
//            theatre = new Theatre(-1, 10);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
//            theatre = new Theatre(1, 0);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        System.out.println("Finished Theatre test: testInvalidValues");
    }
}