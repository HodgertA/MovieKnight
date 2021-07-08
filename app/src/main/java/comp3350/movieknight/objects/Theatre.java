package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

public class Theatre
{
    private int TheatreID;
    private int numSeats;

    public Theatre(int TheatreID, int numSeats) {
        if (TheatreID >= 0 && numSeats > 0) {
            this.TheatreID = TheatreID;
            this.numSeats = numSeats;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTheatreID() { return (TheatreID); }

    public int getNumSeats() { return (numSeats); }
    
    @NotNull
    public String toString()
    {
        return "Theatre: " + TheatreID +", Number of seats: " + numSeats;
    }

    public boolean equals(Object object)
    {
        boolean result;
        Theatre theatre;

        result = false;

        if (object instanceof Theatre) {
            theatre = (Theatre) object;

            if (theatre.TheatreID == this.TheatreID) {
                result = true;
            }
        }
        return result;
    }
}