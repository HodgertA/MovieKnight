package comp3350.movieknight.objects;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

public class Showing {
    private String showingID;
    private String movieID;
    private String theatreID;
    private Date showingDay;

    private ArrayList<Boolean> seats;

    public Showing(String showingID, String movieID, String theatreID, int year,int month,int date,int hour, int minute) {
        if (showingID != null && movieID != null && theatreID != null && hour >= 0 && hour <= 23 && minute >= 0 && minute <=59) {
            this.showingID = showingID;
            this.movieID = movieID;
            this.theatreID = theatreID;

            try{
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.showingDay=format.parse(year+"-"+month+"-"+date+" "+hour+":"+minute);
            }catch (ParseException e){

            }

            seats = new ArrayList<Boolean>();
        } else {
            throw new IllegalArgumentException("Invalid showing attributes");
        }
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

    public Date getShowingDay() {
        return showingDay;
    }

    public ArrayList<Boolean> getSeats() { return seats; }

    public String toString()
    {
        return "Showing: "+ showingID + ", Movie: " + movieID + ", Theatre: " + theatreID + ", Showing Time: " + showingDay;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Showing showing;

        if (object instanceof Showing)
        {
            showing = (Showing) object;
            if (((showing.movieID == null && movieID == null) || (showing.movieID != null && showing.movieID.equals(movieID)))
                && ((showing.theatreID == null  && theatreID == null)  || (showing.theatreID != null  && showing.theatreID.equals(theatreID)))
                && ((showing.showingDay == null && showingDay == null) || (showing.showingDay != null && showing.showingDay.equals(showingDay))))
            {
                result = true;
            }
        }
        return result;
    }
}
