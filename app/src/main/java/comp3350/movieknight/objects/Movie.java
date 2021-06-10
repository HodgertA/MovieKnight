package comp3350.movieknight.objects;

import java.util.Calendar;

public class Movie
{
    private String movieID;
    private String description;
    private String title;
    private int poster;
    private int runtime;
    private Calendar lastShowDate;

    public Calendar getLastShowDate() {
        return lastShowDate;
    }

    public void setEndDate(Calendar endDate) {
        this.lastShowDate = endDate;
    }

    public Movie(String movieID)
    {
        this.movieID = movieID;
        this.description = null;
        this.title = null;
        this.poster = 0;
        this.runtime = 0; //in minutes
        this.lastShowDate = null;
    }

    public Movie(String movieID, String description, String title, int poster, int runtime, int endYear, int endMonth, int endDay )
    {
        this.movieID = movieID;
        this.description = description;
        this.title = title;
        this.poster = poster;
        this.runtime = runtime;
        this.lastShowDate = Calendar.getInstance();
        this.lastShowDate.set(endYear, endMonth-1, endDay);
    }

    public String getMovieID()
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

    public String toString()
    {
        return "Movie: " + movieID + " " + title;
    }

    public boolean equals(Object object)
    {
        boolean result = false;
        Movie m;

        if (object instanceof Movie)
        {
            m = (Movie) object;
            if(((movieID == null) && (m.movieID == null)) || (m.movieID.equals(movieID)))
            {
                result = true;
            }
        }
        return result;
    }
}
