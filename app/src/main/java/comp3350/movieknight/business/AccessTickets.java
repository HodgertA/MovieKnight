package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.persistence.DataAccess;

public class AccessTickets {
    private DataAccess dataAccess;

    public AccessTickets() {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String insertTicket(Ticket ticket) {
        return dataAccess.insertTicket(ticket);
    }

    public String updateTicket(Ticket ticket) {
        return dataAccess.updateTicket(ticket);
    }

    public String deleteTicket(Ticket ticket) {
        return dataAccess.deleteTicket(ticket);
    }

    public boolean[] compileSeatAvailability(int showingID, int numberOfSeats) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        dataAccess.getShowingTickets(tickets, showingID);
        return FindAvailableSeats.compileAvailableSeats(tickets, numberOfSeats);
    }

    public String getUserTickets(ArrayList<Ticket> tickets,int userId) { return dataAccess.getUserTickets(tickets, userId); }

    public void createTicket(int userID, ArrayList<Integer> selectedSeats, int showingID) {
        for (int seatNum : selectedSeats) {
            Ticket newTicket = new Ticket(userID, showingID, seatNum);
            dataAccess.insertTicket(newTicket);
        }
    }
}