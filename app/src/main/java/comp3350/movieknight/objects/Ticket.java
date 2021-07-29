package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

public class Ticket {

    private int seatNum;
    private int userID;
    private int showingID;

    public Ticket(int userID, int showingID, int seatNum) {
        if (userID >= 0 && showingID >= 0 && seatNum >= 0) {
            this.userID = userID;
            this.showingID = showingID;
            this.seatNum = seatNum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Ticket(int showingID, int seatNum) {
        if (showingID >= 0 && seatNum >= 0) {
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

    @NotNull
    public String toString() {
        return "Seat Number: " + seatNum + ", User: " + userID + ", Showing: " + showingID;
    }

    public boolean equals(Object object) {
        boolean result = false;
        Ticket ticket;

        if(object instanceof Ticket) {
            ticket = (Ticket) object;

            if(ticket.showingID == showingID && ticket.seatNum == seatNum) {
                result = true;
            }
        }

        return result;
   }
}
