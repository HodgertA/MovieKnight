package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.persistence.DatabaseStub;

public class AccessTickets {
    private DatabaseStub dataAccess;

    public AccessTickets()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getTicketsInShowing(ArrayList<Ticket> ticketList, int showingID)
    {
        //provides a list of tickets that are already sold for that showing
        ticketList = dataAccess.getShowingTickets(new Ticket(0, 0, showingID, 0, 0));
        return null;
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

}
