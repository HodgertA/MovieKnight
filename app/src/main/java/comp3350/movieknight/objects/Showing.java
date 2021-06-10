package comp3350.movieknight.objects;

import java.util.ArrayList;

public class Showing {
    private int showingID;
    private int movieID;
    private int theatreID;
    private String showingTime;
    private ArrayList<Boolean> seats;

    public Showing(int showingID, int movieID, int theatreID, int hour, int minute) {
        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <=59) {
            this.showingID = showingID;
            this.movieID = movieID;
            this.theatreID = theatreID;
            showingTime = hour + ":" + minute;
            seats = new ArrayList<Boolean>();
        } else {
            throw new IllegalArgumentException("Invalid showing attributes");
        }
    }

    public int getShowingID() { return showingID; }

    public int getMovieID()
    {
        return movieID;
    }

    public int getTheatreID()
    {
        return theatreID;
    }

    public String getShowingTime()
    {
        return showingTime;
    }

    public ArrayList<Boolean> getSeats() { return seats; }

    public String toString()
    {
        return "Showing: "+ showingID + ", Movie: " + movieID + ", Theatre: " + theatreID + ", Showing Time: " + showingTime;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Showing showing;

        if (object instanceof Showing)
        {
            showing = (Showing) object;
            if (showing.movieID == movieID && showing.theatreID == theatreID && showing.showingTime.equals(showingTime))
            {
                result = true;
            }
        }
        return result;
    }
}
