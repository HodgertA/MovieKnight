package comp3350.movieknight.tests.business;

import junit.framework.TestCase;
import java.util.*;

import comp3350.movieknight.business.FindAvailableSeats;
import comp3350.movieknight.objects.Ticket;

public class FindAvailableSeatsTest extends TestCase {

    public FindAvailableSeatsTest(String arg0)
    {
        super(arg0);
    }

    public void testNullList() {
        System.out.println("Starting find available seats test: testNullList");

        try {
            FindAvailableSeats.compileAvailableSeats(null,10);
            fail("Expected a NullPointerException");
        } catch (NullPointerException e) { }

        System.out.println("Finished find available seats test: testNullList");
    }

    public void testEmptyList() {
        System.out.println("Starting find available seats test: testEmptyList");

        ArrayList<Ticket> tickets = new ArrayList<>();
        boolean [] result;
        boolean [] expectedResult = { true };

        result = FindAvailableSeats.compileAvailableSeats(tickets,1);
        assertTrue(Arrays.equals(result,expectedResult));

        System.out.println("Finished find available seats test: testEmptyList");
    }

    public void testNullTicket() {
        System.out.println("Starting find available seats test: testNullTicket");

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(null);

        try {
            FindAvailableSeats.compileAvailableSeats(tickets,10);
            fail("Expected an NullPointerException");
        } catch (NullPointerException e) { }

        System.out.println("Finished find available seats test: testNullTicket");
    }

    public void testOneTicketInList() {
        System.out.println("Starting find available seats test: testOneTicketInList");

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1,0));
        boolean [] result;
        boolean [] expectedResult = { false };

        result = FindAvailableSeats.compileAvailableSeats(tickets,1);
        assertTrue(Arrays.equals(result,expectedResult));

        System.out.println("Finished find available seats test: testOneTicketInList");

    }

    public void testZeroSeat() {
        System.out.println("Starting find available seats test: testZeroSeat");

        ArrayList<Ticket> tickets = new ArrayList<>();
        //add some tickets to the list, the list is not empty
        tickets.add(new Ticket(1,1));
        tickets.add(new Ticket(1,1));

        try {
            FindAvailableSeats.compileAvailableSeats(tickets,0);
            fail("Expected an ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) { }

        System.out.println("Finished find available seats test: testZeroSeat");
    }

    public void testNegativeSeat() {
        System.out.println("Starting find available seats test: testNegativeSeat");

        ArrayList<Ticket> tickets = new ArrayList<>();
        //add some tickets to the list, the list is not empty
        tickets.add(new Ticket(1,1));
        tickets.add(new Ticket(1,1));

        try {
            FindAvailableSeats.compileAvailableSeats(tickets,-1);
            fail("Expected an NegativeArraySizeException");
        } catch (NegativeArraySizeException e) { }

        System.out.println("Finished find available seats test: testNegativeSeat");
    }

    public void testTicketSeatNumberBiggerThanTotalSeatsNum() {
        System.out.println("Starting find available seats test: testTicketSeatNumberBiggerThanTotalSeatsNum");

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1,100));
        tickets.add(new Ticket(1,200));

        try {
            //ticket seat number is bigger than the number of seats
            FindAvailableSeats.compileAvailableSeats(tickets,10);
            fail("Expected an ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) { }

        System.out.println("Finished find available seats test: testTicketSeatNumberBiggerThanTotalSeatsNum");
    }

    public void testNoTicket() {
        System.out.println("Starting find available seats test: testNoTickets");

        ArrayList<Ticket> tickets = new ArrayList<>();

        boolean [] result;
        boolean [] expectedResult = { true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true};


        result = FindAvailableSeats.compileAvailableSeats(tickets,40);
        assertTrue(Arrays.equals(result,expectedResult));
        System.out.println("Finished find available seats test: testNoTickets");
    }

    public void testDuplicatedTickets() {
        System.out.println("Starting find available seats test: testDuplicatedTickets");

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1,0));
        tickets.add(new Ticket(1,0));
        tickets.add(new Ticket(1,0));

        boolean [] result;
        boolean [] expectedResult = { false,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,true};


        result = FindAvailableSeats.compileAvailableSeats(tickets,40);
        assertTrue(Arrays.equals(result,expectedResult));

        System.out.println("Finished find available seats test: testDuplicatedTickets");
    }


    public void testManyTickets() {
        System.out.println("Starting find available seats test: testManyTickets");

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1,0));
        tickets.add(new Ticket(1,3));
        tickets.add(new Ticket(1,10));
        tickets.add(new Ticket(1,20));
        tickets.add(new Ticket(1,27));
        tickets.add(new Ticket(1,39));

        boolean [] result;
        boolean [] expectedResult = { false,true,true,false,true,
                                    true,true,true,true,true,
                                    false,true,true,true,true,
                                    true,true,true,true,true,
                                    false,true,true,true,true,
                                    true,true,false,true,true,
                                    true,true,true,true,true,
                                    true,true,true,true,false};


        result = FindAvailableSeats.compileAvailableSeats(tickets,40);
        assertTrue(Arrays.equals(result,expectedResult));

        System.out.println("Finished find available seats test: testManyTickets");
    }




}