package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.persistence.DataAccess;

public class AccessTickets {
    private DataAccess dataAccess;

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
            Ticket newTicket = new Ticket(userID, showingID, seatNum);
            dataAccess.insertTicket(newTicket);
        }
    }
}