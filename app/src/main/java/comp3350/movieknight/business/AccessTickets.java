package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.persistence.DatabaseStub;

public class AccessTickets {
    private DatabaseStub dataAccess;

    public AccessTickets()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String insertTicket(Ticket ticket)
    {
        return dataAccess.insertTicket(ticket);
    }

    public String updateTicket(Ticket ticket)
    {
        return dataAccess.updateTicket(ticket);
    }

    public String deleteTicket(Ticket ticket)
    {
        return dataAccess.deleteTicket(ticket);
    }

    public boolean[] compileSeatReservations(int showingID, int numberOfSeats) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        dataAccess.getShowingTickets(tickets, showingID);
        return FindAvailableSeats.compileReservedSeats(tickets, numberOfSeats);
    }

    public ArrayList<Ticket> getUserTickets(int userId) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        dataAccess.getUserTickets(tickets, userId);
        return tickets;
    }

    public void createTicket(int userID, ArrayList<Integer> selectedSeats, int showingID) {
        for (int seatNum : selectedSeats) {
            Ticket newTicket = new Ticket(0, userID, showingID, 0, seatNum);
            dataAccess.insertTicket(newTicket);
        }
    }
}