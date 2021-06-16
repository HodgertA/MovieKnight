package comp3350.movieknight.objects;

public class Theatre
{
    private int theatreNumber;
    private int numSeats;

    public Theatre(int theatreNumber, int numSeats) {
        if (theatreNumber >= 0 && numSeats > 0) {
            this.theatreNumber = theatreNumber;
            this.numSeats = numSeats;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTheatreNumber() { return (theatreNumber); }

    public int getNumSeats() { return (numSeats); }
    
    public String toString()
    {
        return "Theatre: " + theatreNumber +", Number of seats: " + numSeats;
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