package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Ticket;

public class TicketTest extends TestCase {

    public TicketTest(String arg0) { super(arg0);}

    public void testConstructor(){
        System.out.println("starting testConstructor for Ticket class\n");

            Ticket ticket1 = new Ticket(1,1,1,1,1);
            assertNotNull(ticket1);
            assertEquals(1,ticket1.getTicketID());
            assertEquals(1,ticket1.getUserID());
            assertEquals(1,ticket1.getShowingID());
            assertEquals(1,ticket1.getTheatreID());
            assertEquals(1,ticket1.getSeatNum());

            Ticket ticket2 = new Ticket(2,2,2,2);
            assertNotNull(ticket2);
            assertEquals(2,ticket2.getTicketID());
            assertEquals(2,ticket2.getShowingID());
            assertEquals(2,ticket2.getTheatreID());
            assertEquals(2,ticket2.getSeatNum());

        System.out.println("Finished testConstructor for Ticket class\n\n");
    }

    public void testToString(){

        System.out.println("starting testToString for Ticket class\n");

            Ticket ticket1 = new Ticket(1,1,1,1,1);
            assertEquals("Ticket: ticketID=1, seatNum=1, userID=1, showingID=1, theatreID=1",ticket1.toString());

        System.out.println("Finished testToString for Ticket class\n\n");

    }

    public void testEquals(){
        System.out.println("starting testEquals for Ticket class\n");
            Ticket ticket1 = new Ticket(1,1,1,1,1);
            Ticket ticket1Copy = new Ticket(1,1,1,1,1);
            Ticket ticket2 = new Ticket(2,2,2,2);
            Ticket ticket3 = new Ticket(1,2,2,2);

            boolean temp;

            temp=ticket1Copy.equals(ticket1);
            assertTrue(temp);

            temp=ticket1.equals(ticket2);
            assertFalse(temp);

            temp=ticket1.equals(ticket3);
            assertTrue(temp);

        System.out.println("Finished testEquals for Ticket class\n");
    }
}