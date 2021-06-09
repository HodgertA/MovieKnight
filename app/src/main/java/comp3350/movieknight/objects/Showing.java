package comp3350.movieknight.objects;


import java.util.ArrayList;
import java.util.Calendar;


public class Showing {
    private String showingID;
    private String movieID;
    private String theatreID;

    private Calendar showingDate;

    private ArrayList<Boolean> seats;

    public Showing(String showingID, String movieID, String theatreID, int year,int month,int date,int hour, int minute) {
        if (showingID != null && movieID != null && theatreID != null && hour >= 0 && hour <= 23 && minute >= 0 && minute <=59) {
            this.seats = new ArrayList<Boolean>();
            this.showingID = showingID;
            this.movieID = movieID;
            this.theatreID = theatreID;
            this.showingDate =Calendar.getInstance();
            this.showingDate.set(year,month,date,hour,minute);


        } else {
            throw new IllegalArgumentException("Invalid showing attributes");
        }
    }


    public Calendar getShowingDate() {
        return showingDate;
    }

    public String getShowingID() { return showingID; }

    public String getMovieID()
    {
        return movieID;
    }

    public String getTheatreID()
    {
        return theatreID;
    }



    public ArrayList<Boolean> getSeats() { return seats; }

    public String toString()
    {
        return "Showing: "+ showingID + ", Movie: " + movieID + ", Theatre: " + theatreID;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Showing showing;

        if (object instanceof Showing)
        {
            showing = (Showing) object;
            if (((showing.movieID == null && movieID == null) || (showing.movieID != null && showing.movieID.equals(movieID)))
                && ((showing.theatreID == null  && theatreID == null)  || (showing.theatreID != null  && showing.theatreID.equals(theatreID))))
            {
                result = true;
            }
        }
        return result;
    }
}
