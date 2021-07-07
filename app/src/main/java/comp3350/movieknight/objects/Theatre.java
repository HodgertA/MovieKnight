package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Theatre
{
    private int theatreNumber;
    private ArrayList<Seat> seats;;

    public Theatre(int theatreNumber, ArrayList<Seat> seats) {
        if (theatreNumber >= 0 && seats.size() > 0) {
            this.theatreNumber = theatreNumber;
            this.seats = seats;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTheatreNumber() { return (theatreNumber); }

    public int getNumSeats() { return (seats.size()); }

    public ArrayList<Seat> getSeats() { return (seats); }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    
    @NotNull
    public String toString()
    {
        return "Theatre: " + theatreNumber +", Number of seats: " + seats.size();
    }

    public boolean equals(Object object)
    {
        boolean result;
        Theatre theatre;

        result = false;

        if (object instanceof Theatre) {
            theatre = (Theatre) object;

            if (theatre.theatreNumber == this.theatreNumber) {
                result = true;
            }
        }
        return result;
    }
}