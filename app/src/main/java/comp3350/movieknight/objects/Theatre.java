package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

public class Theatre {
    private int theatreID;
    private int numSeats;

    public Theatre(int theatreID, int numSeats) {
        if (theatreID >= 0 && numSeats > 0) {
            this.theatreID = theatreID;
            this.numSeats = numSeats;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTheatreID() { return (theatreID); }

    public int getNumSeats() { return (numSeats); }
    
    @NotNull
    public String toString() {
        return "Theatre: " + theatreID +", Number of seats: " + numSeats;
    }

    public boolean equals(Object object) {
        boolean result;
        Theatre theatre;

        result = false;

        if (object instanceof Theatre) {
            theatre = (Theatre) object;

            if (theatre.theatreID == this.theatreID) {
                result = true;
            }
        }
        return result;
    }
}