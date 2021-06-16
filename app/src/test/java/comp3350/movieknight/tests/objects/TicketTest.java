package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class TicketTest extends TestCase {

    public TicketTest(String arg0) { super(arg0);}

    public void testTypicalTicket()
    {
        System.out.println("Starting Ticket test: testTypicalTicket");

        Ticket ticket1 = new Ticket(1, 1, 1, 1, 10);
        assertNotNull(ticket1);
        assertEquals(1, ticket1.getTicketID());
        assertEquals(1, ticket1.getUserID());
        assertEquals(1, ticket1.getShowingID());
        assertEquals(1, ticket1.getTheatreID());
        assertEquals(10, ticket1.getSeatNum());
        assertEquals("Ticket: 1, Seat Number: 10, User: 1, Showing: 1, Theatre: 1", ticket1.toString());
        assertTrue(ticket1.equals(ticket1));

        Ticket ticket2 = new Ticket(1, 1, 1, 10);
        assertNotNull(ticket2);
        assertEquals(1, ticket2.getTicketID());
        assertEquals(-1, ticket2.getUserID());
        assertEquals(1, ticket2.getShowingID());
        assertEquals(1, ticket2.getTheatreID());
        assertEquals(10, ticket2.getSeatNum());
        assertEquals("Ticket: 1, Seat Number: 10, User: -1, Showing: 1, Theatre: 1", ticket2.toString());
        assertTrue(ticket2.equals(ticket2));

        System.out.println("Finished Ticket test: testTypicalTicket");
    }

    public void testTwoTickets()
    {
        System.out.println("Starting Ticket test: testTwoTickets");

        Ticket ticket1 = new Ticket(1, 1, 1, 1, 10);
        Ticket ticket2 = new Ticket(2, 2, 2, 2, 20);
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertEquals(1, ticket1.getTicketID());
        assertEquals(2, ticket2.getTicketID());
        assertEquals(1, ticket1.getUserID());
        assertEquals(2, ticket2.getUserID());
        assertEquals(1, ticket1.getShowingID());
        assertEquals(2, ticket2.getShowingID());
        assertEquals(1, ticket1.getTheatreID());
        assertEquals(2, ticket2.getTheatreID());
        assertEquals(10, ticket1.getSeatNum());
        assertEquals(20, ticket2.getSeatNum());
        assertEquals("Ticket: 1, Seat Number: 10, User: 1, Showing: 1, Theatre: 1", ticket1.toString());
        assertEquals("Ticket: 2, Seat Number: 20, User: 2, Showing: 2, Theatre: 2", ticket2.toString());
        assertFalse(ticket1.equals(ticket2));

        Ticket ticket3 = new Ticket(1, 1, 1, 10);
        Ticket ticket4 = new Ticket(2, 2, 2, 20);
        assertNotNull(ticket3);
        assertNotNull(ticket4);
        assertEquals(1, ticket3.getTicketID());
        assertEquals(2, ticket4.getTicketID());
        assertEquals(-1, ticket3.getUserID());
        assertEquals(-1, ticket4.getUserID());
        assertEquals(1, ticket3.getShowingID());
        assertEquals(2, ticket4.getShowingID());
        assertEquals(1, ticket3.getTheatreID());
        assertEquals(2, ticket4.getTheatreID());
        assertEquals(10, ticket3.getSeatNum());
        assertEquals(20, ticket4.getSeatNum());
        assertEquals("Ticket: 1, Seat Number: 10, User: -1, Showing: 1, Theatre: 1", ticket3.toString());
        assertEquals("Ticket: 2, Seat Number: 20, User: -1, Showing: 2, Theatre: 2", ticket4.toString());
        assertFalse(ticket3.equals(ticket4));

        System.out.println("Finished Ticket test: testTwoTickets");
    }

    public void testEdgeCases()
    {
        System.out.println("Starting Ticket test: testEdgeCases");

        Ticket ticket1 = new Ticket(0, 0, 0, 0, 1);
        assertNotNull(ticket1);
        assertEquals(0, ticket1.getTicketID());
        assertEquals(0, ticket1.getUserID());
        assertEquals(0, ticket1.getShowingID());
        assertEquals(0, ticket1.getTheatreID());
        assertEquals(1, ticket1.getSeatNum());
        assertEquals("Ticket: 0, Seat Number: 1, User: 0, Showing: 0, Theatre: 0", ticket1.toString());
        assertTrue(ticket1.equals(ticket1));

        Ticket ticket2 = new Ticket(0, 0, 0, 1);
        assertNotNull(ticket2);
        assertEquals(0, ticket2.getTicketID());
        assertEquals(-1, ticket2.getUserID());
        assertEquals(0, ticket2.getShowingID());
        assertEquals(0, ticket2.getTheatreID());
        assertEquals(1, ticket2.getSeatNum());
        assertEquals("Ticket: 0, Seat Number: 1, User: -1, Showing: 0, Theatre: 0", ticket2.toString());
        assertTrue(ticket2.equals(ticket2));

        System.out.println("Finished Ticket test: testEdgeCases");
    }

    public void testInvalidValues()
    {
        System.out.println("Starting Ticket test: testInvalidValues");

        Ticket ticket;

        try {
            ticket = new Ticket(-1, 1,1,1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1, -1,1,1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1, 1,-1,1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1, 1,1,-1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1, 1,1,1,0);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(-1,1,1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1,-1,1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1,1,-1,1);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        try {
            ticket = new Ticket(1,1,1,0);
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) {}

        System.out.println("Finished Ticket test: testInvalidValues");
    }
}