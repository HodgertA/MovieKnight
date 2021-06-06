package comp3350.movieknight.Objects;

public class Showing {
    private String movieID;
    private String theatreID;
    private String showingTime;

    public Showing(String movieID, String theatreID, int hour, int minute) {
        if (movieID != null && theatreID != null && hour >= 0 && hour <= 23 && minute >= 0 && minute <=59) {
            this.movieID = movieID;
            this.theatreID = theatreID;
            showingTime = hour + ":" + minute;
        } else {
            throw new IllegalArgumentException("Invalid showing attributes");
        }
    }

    public String getMovieID()
    {
        return movieID;
    }

    public String getTheatreID()
    {
        return theatreID;
    }

    public String getShowingTime()
    {
        return showingTime;
    }

    public String toString()
    {
        return "Movie: " + movieID + ", Theatre: " + theatreID + ", Showing Time: " + showingTime;
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
                && ((showing.showingTime == null && showingTime == null) || (showing.showingTime != null && showing.showingTime.equals(showingTime))))
            {
                result = true;
            }
        }
        return result;
    }
}
