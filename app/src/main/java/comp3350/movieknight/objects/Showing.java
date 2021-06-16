package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class Showing {
    private int showingID;
    private int movieID;
    private int theatreID;
    private Calendar showingDate;
    private double showingTime;
    private int seats;

    public Showing(int showingID, int movieID, int theatreID, int seats, int year, int month, int date, int hour, int minute) {
        if (showingID >=0 && movieID >= 0 && theatreID >= 0 && seats >= 1 && month > 0 && month <=12 && date >0 && date <=31 && hour >= 0 && hour <= 23 && minute >= 0 && minute <=59) {
            this.seats = seats;
            this.showingID = showingID;
            this.movieID = movieID;
            this.theatreID = theatreID;
            this.showingDate = Calendar.getInstance();
            this.showingDate.set(year, month-1, date, hour, minute);
            this.showingTime = hour + ( minute / 100.0);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Calendar getShowingDate() {
        return showingDate;
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

    public double getShowingTime() { return showingTime;}

    public int getSeats() { return seats; }

    @NotNull
    public String toString()
    {
        return "Showing: "+ showingID + ", Movie: " + movieID + ", Theatre: " + theatreID + ", Showing time: " + showingDate.get(Calendar.YEAR) + " " + (showingDate.get(Calendar.MONTH)+1)+" " + showingDate.get(Calendar.DATE) + " at " + showingTime;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Showing showing;

        if (object instanceof Showing) {
            showing = (Showing) object;

            if (showing.movieID == movieID
                    && showing.theatreID == theatreID
                    && showing.showingDate.get(Calendar.YEAR) == showingDate.get(Calendar.YEAR)
                    && showing.showingDate.get(Calendar.MONTH) == showingDate.get(Calendar.MONTH)
                    && showing.showingDate.get(Calendar.DATE) == showingDate.get(Calendar.DATE)
                    && showing.showingTime == showingTime) {
                result = true;
            }
        }
        return result;
    }
}
