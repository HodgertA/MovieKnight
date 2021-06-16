package comp3350.movieknight.objects;

import java.util.Calendar;

public class Movie
{
    private int movieID;
    private String description;
    private String title;
    private int poster;
    private int runtime;
    private Calendar lastShowDate;

    public Movie(int movieID)
    {
        if (movieID >= 0) {
            this.movieID = movieID;
            this.description = null;
            this.title = null;
            this.poster = -1;
            this.runtime = 0; //in minutes
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Movie(int movieID, String description, String title, int poster, int runtime, int endYear, int endMonth, int endDay )
    {
        if (movieID >= 0 && runtime >= 0 && endMonth > 0 && endMonth <=12 && endDay > 0 && endDay <= 31) {
            this.movieID = movieID;
            this.description = description;
            this.title = title;
            this.poster = poster;
            this.runtime = runtime;
            this.lastShowDate = Calendar.getInstance();
            this.lastShowDate.set(endYear, endMonth-1, endDay);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getMovieID()
    {
        return movieID;
    }

    public String getDescription()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public int getPoster() {
        return poster;
    }

    public int getRuntime()
    {
        return runtime;
    }

    public Calendar getLastShowDate() {
        return lastShowDate;
    }

    public void setEndDate(Calendar endDate) {
        this.lastShowDate = endDate;
    }

    public String toString()
    {
        return "Movie: " + movieID + " " + title;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Movie movie;

        if (object instanceof Movie) {
            movie = (Movie) object;

            if(movie.movieID == movieID) {
                result = true;
            }
        }
        return result;
    }
}
