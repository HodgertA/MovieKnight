package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.tests.persistence.DatabaseStub;

public class AccessTicketsTest extends TestCase {
    public AccessTicketsTest(String arg0) {
        super(arg0);
    }

    private static String dbName = Main.dbName;

    public void testCreateTicket(){
        System.out.println("\nStarting createTickets tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();
        //normal test
        ArrayList<Integer> selectedSeats=new ArrayList<>();
        selectedSeats.add(5);
        selectedSeats.add(12);
        selectedSeats.add(20);
        accessTickets.createTicket(4,selectedSeats,1);


        ArrayList<Ticket> tickets= accessTickets.getUserTickets(4);

        assertEquals(3,tickets.size());
        assertTrue(tickets.contains(new Ticket(4,1,5)));
        assertTrue(tickets.contains(new Ticket(4,1,12)));
        assertTrue(tickets.contains(new Ticket(4,1,20)));
        //normal test done

        //empty list test
        selectedSeats=new ArrayList<>();
        accessTickets.createTicket(5,selectedSeats,1);

        tickets= accessTickets.getUserTickets(5);

        assertEquals(0,tickets.size());
        //empty list test done

        //fill list test
        selectedSeats=new ArrayList<>();
        for(int i=0;i<24;i++){
            selectedSeats.add(i);
        }
        accessTickets.createTicket(6,selectedSeats,20);
        tickets= accessTickets.getUserTickets(6);

        assertEquals(24,tickets.size());
        for(int i=0;i<24;i++){
            assertTrue(tickets.contains(new Ticket(6,20,i)));
        }
        //fill list test done
        Services.closeDataAccess();
        System.out.println("\nFinished createTickets tests (using stub)");
    }


    public void testGetUserTickets(){
        System.out.println("\nStarting getUserTickets tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();

        ArrayList<Ticket>tickets= accessTickets.getUserTickets(1);

        assertEquals(8,tickets.size());
        assertTrue(tickets.contains(new Ticket(1, 1, 0)));
        assertTrue(tickets.contains(new Ticket(1, 1, 3)));
        assertTrue(tickets.contains(new Ticket(1, 2, 6)));
        assertTrue(tickets.contains(new Ticket(1, 3, 9)));
        assertTrue(tickets.contains(new Ticket(1, 5, 12)));
        assertTrue(tickets.contains(new Ticket(1, 7, 15)));
        assertTrue(tickets.contains(new Ticket(1, 10, 18)));
        assertTrue(tickets.contains(new Ticket(1, 12, 4)));


        Services.closeDataAccess();
        System.out.println("\nFinished getUserTickets tests (using stub)");
    }
    public void testCompileSeatAvailability(){
        System.out.println("\nStarting compileSeatAvailability tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();

        boolean[] result=accessTickets.compileSeatAvailability(1,24);
        boolean[] expectedResult={ false,false,false,false,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true};
        assertTrue(Arrays.equals(expectedResult, result));

        result=accessTickets.compileSeatAvailability(2,24);
        expectedResult=new boolean[]{ true,true,true,true,false,
                                        false,false,false,true,true,
                                        true,true,true,true,true,
                                        true,true,true,true,true,
                                        true,true,true,true};
        assertTrue(Arrays.equals(expectedResult, result));

        Services.closeDataAccess();
        System.out.println("\nFinished compileSeatAvailability tests (using stub)");
    }

    public void testInsertTicket(){
        System.out.println("\nStarting insertTicket tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();
        ArrayList<Ticket> tickets=new ArrayList<>();

        assertEquals(0,accessTickets.getUserTickets(4).size());

        tickets.add(new Ticket(4,100,100));
        accessTickets.insertTicket(tickets.get(0));

        assertEquals(1,accessTickets.getUserTickets(4).size());
        assertEquals(tickets,accessTickets.getUserTickets(4));

        Services.closeDataAccess();
        System.out.println("\nFinished insertTicket tests (using stub)");
    }


    public void testUpdateTicket(){
        System.out.println("\nStarting updateTicket tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();

        assertEquals(1,accessTickets.getUserTickets(1).get(0).getUserID());
        assertEquals(0,accessTickets.getUserTickets(1).get(0).getSeatNum());
        assertEquals(1,accessTickets.getUserTickets(1).get(0).getShowingID());

        assertEquals(0,accessTickets.getUserTickets(4).size());

        accessTickets.updateTicket(new Ticket(4,1,0));

        assertEquals(1,accessTickets.getUserTickets(4).size());
        assertEquals(4,accessTickets.getUserTickets(4).get(0).getUserID());

        Services.closeDataAccess();
        System.out.println("\nFinished updateTicket tests (using stub)");
    }

    public void testDeleteTicket(){
        System.out.println("\nStarting deleteTicket tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTickets accessTickets=new AccessTickets();

        assertEquals(8,accessTickets.getUserTickets(1).size());

        for(int j=1;j<4;j++) {
            for (int i = 0; i < 8; i++) {
                accessTickets.deleteTicket(accessTickets.getUserTickets(j).get(0));
                assertEquals(7 - i, accessTickets.getUserTickets(j).size());
            }
        }

        Services.closeDataAccess();
        System.out.println("\nFinished deleteTicket tests (using stub)");
    }


}