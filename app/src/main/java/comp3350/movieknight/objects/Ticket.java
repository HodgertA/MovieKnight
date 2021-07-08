package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

public class Ticket {

    private int ticketID;
    private int seatNum;
    private int userID;
    private int showingID;

    public Ticket(int ticketID, int userID, int showingID, int seatNum){
        if (ticketID >= 0 && userID >= 0 && showingID >= 0 && seatNum >= 0) {
            this.ticketID = ticketID;
            this.userID = userID;
            this.showingID = showingID;
            this.seatNum = seatNum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Ticket(int ticketID, int showingID, int seatNum){
        if (ticketID >= 0 && showingID >= 0 && seatNum >= 0) {
            this.ticketID = ticketID;
            this.userID = -1;
            this.showingID = showingID;
            this.seatNum = seatNum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getShowingID() {
        return showingID;
    }

    public int getUserID() {
        return userID;
    }

    public int getTicketID() {
        return ticketID;
    }

    @NotNull
    public String toString() {
        return "Ticket: " + ticketID + ", Seat Number: " + seatNum + ", User: " + userID + ", Showing: " + showingID;
    }

    public boolean equals(Object object) {

        boolean result=false;
        Ticket ticket;

        if(object instanceof Ticket)
        {
            ticket=(Ticket) object;

            if(ticket.userID == userID && ticket.showingID == showingID && ticket.seatNum == seatNum)
            {
                result=true;
            }
        }

        return result;
   }
}
