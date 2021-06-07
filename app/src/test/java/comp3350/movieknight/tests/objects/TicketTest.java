package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.Ticket;

public class TicketTest extends TestCase {

    public TicketTest(String arg0) { super(arg0);}

    public void testConstructor(){
        System.out.println("starting testConstructor for Ticket class\n");

            Ticket ticket1=new Ticket("ti1","u1","s1","th1",1);
            assertNotNull(ticket1);
            assertEquals("ti1",ticket1.getTicketID());
            assertEquals("u1",ticket1.getUserID());
            assertEquals("s1",ticket1.getShowingID());
            assertEquals("th1",ticket1.getTheatreID());
            assertEquals(1,ticket1.getSeatNum());

            Ticket ticket2=new Ticket("ti2","s2","th2",2);
            assertNotNull(ticket2);
            assertEquals("ti2",ticket2.getTicketID());
            assertEquals("s2",ticket2.getShowingID());
            assertEquals("th2",ticket2.getTheatreID());
            assertEquals(2,ticket2.getSeatNum());

        System.out.println("Finished testConstructor for Ticket class\n\n");
    }

    public void testToString(){

        System.out.println("starting testToString for Ticket class\n");

            Ticket ticket1=new Ticket("ti1","u1","s1","th1",1);
            assertEquals("Ticket: ticketID='ti1', seatNum=1, userID='u1', showingID='s1', theatreID='th1'",ticket1.toString());

        System.out.println("Finished testToString for Ticket class\n\n");

    }

    public void testEquals(){
        System.out.println("starting testEquals for Ticket class\n");
            Ticket ticket1=new Ticket("ti1","u1","s1","th1",1);
            Ticket ticket1Copy=new Ticket("ti1","u1","s1","th1",1);
            Ticket ticket2=new Ticket("ti2","s2","th2",2);
            Ticket ticket3=new Ticket("ti1","s2","th2",2);

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