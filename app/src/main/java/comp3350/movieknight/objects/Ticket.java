package comp3350.movieknight.objects;

public class Ticket {

    private int ticketID;
    private int seatNum;
    private int userID;
    private int showingID;
    private int theatreID;

    public Ticket(int ticketID, int userID, int showingID, int theatreID, int seatNum){
        if (ticketID >= 0 && userID >= 0 && showingID >= 0 && theatreID >= 0 && seatNum> 0) {
            this.ticketID = ticketID;
            this.userID = userID;
            this.showingID = showingID;
            this.theatreID = theatreID;
            this.seatNum = seatNum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Ticket(int ticketID, int showingID, int theatreID, int seatNum){
        if (ticketID >= 0 && showingID >= 0 && theatreID >= 0 && seatNum> 0) {
            this.ticketID = ticketID;
            this.userID = -1;
            this.showingID = showingID;
            this.theatreID = theatreID;
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

    public int getTheatreID() {
        return theatreID;
    }

    public int getUserID() {
        return userID;
    }

    public int getTicketID() {
        return ticketID;
    }

    @Override
    public String toString() {
        return "Ticket: " +
                "ticketID= " + ticketID +
                ", seatNum= " + seatNum +
                ", userID= " + userID +
                ", showingID= " + showingID +
                ", theatreID= " + theatreID ;
    }

    @Override
    public boolean equals(Object o) {

        boolean result=false;
        Ticket ticket;

        if(o instanceof Ticket)
        {
            ticket=(Ticket) o;
            if(ticket.userID == userID
                    && ticket.showingID == showingID
                    && ticket.seatNum == seatNum)
            {
                result=true;
            }
        }

        return result;
   }
}
