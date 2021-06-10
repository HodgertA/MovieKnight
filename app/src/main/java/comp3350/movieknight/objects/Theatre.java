package comp3350.movieknight.objects;

public class Theatre
{
    private int theatreNumber;
    private int numberOfSeatsInRoom;

    public Theatre(int theatreNumber, int numberOfSeatsInRoom) {
        if (theatreNumber >= 0 && numberOfSeatsInRoom > 0) {
            this.theatreNumber = theatreNumber;
            this.numberOfSeatsInRoom = numberOfSeatsInRoom;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTheatreNumber() { return (theatreNumber); }

    public int getNumberOfSeatsInRoom() { return (numberOfSeatsInRoom); }
    
    public String toString()
    {
        return "Theatre #" + theatreNumber +" can seat " +numberOfSeatsInRoom + " people";
    }

    public boolean equals(Object object)
    {
        boolean result;
        Theatre t;

        result = false;

        if (object instanceof Theatre)
        {
            t = (Theatre) object;
            if (t.theatreNumber == this.theatreNumber)
            {
                result = true;
            }
        }
        return result;
    }
}