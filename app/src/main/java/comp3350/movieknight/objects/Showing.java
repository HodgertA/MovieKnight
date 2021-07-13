package comp3350.movieknight.objects;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class Showing {
    private int showingID;
    private int movieID;
    private int theatreID;
    private Calendar showingDate;
    private int showingHour;
    private int showingMinute;
    private int seats;

    public Showing(int showingID) {
        if(showingID >= 0) {

            this.showingID = showingID;
            this.movieID = 0;
            this.theatreID = 0;
            this.showingDate = null;
            this.showingHour = 0;
            this.showingMinute = 0;
            this.seats=0;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public Showing(int showingID, int movieID, int theatreID, int seats, int year, int month, int date, int hour, int minute) {
        if (showingID >= 0 && movieID >= 0 && theatreID >= 0 && seats >= 1 && month > 0 && month <= 12 && date > 0 && date <= 31 && hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            this.seats = seats;
            this.showingID = showingID;
            this.movieID = movieID;
            this.theatreID = theatreID;
            this.showingDate = Calendar.getInstance();
            this.showingDate.set(year, month-1, date, hour, minute);
            this.showingHour = hour;
            this.showingMinute = minute;
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

    public int getShowingHour() { return showingHour; }

    public int getShowingMinute() { return showingMinute; }

    public int getSeats() { return seats; }

    @NotNull
    public String toString() {
        return "Showing: "+ showingID + ", Movie: " + movieID + ", Theatre: " + theatreID + ", Showing time: " + showingDate.get(Calendar.YEAR) + " " + (showingDate.get(Calendar.MONTH)+1)+" " + showingDate.get(Calendar.DATE) + " at " + showingHour + ":" + showingMinute;
    }

    public boolean equals(Object object) {
        boolean result = false;
        Showing showing;

        if (object instanceof Showing) {
            showing = (Showing) object;

            if (showing.showingID == showingID) {
                result = true;
            }
        }
        return result;
    }
}
