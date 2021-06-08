package comp3350.movieknight.objects;

public class Theatre
{
    private int theatreNumber;
    private int numberOfSeatsInRoom;

    public Theatre(int theatreNumber, int numberOfSeatsInRoom)
    {
        this.theatreNumber = theatreNumber;
        this.numberOfSeatsInRoom =  numberOfSeatsInRoom;
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