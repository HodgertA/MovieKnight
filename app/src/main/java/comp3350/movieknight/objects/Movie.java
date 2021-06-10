package comp3350.movieknight.objects;

public class Movie
{
    private String movieID;
    private String poster;
    private String description;
    private String title;
    private int runtime;
    private int startDate;
    private int endDate;

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public Movie(String movieID)
    {
        this.movieID = movieID;

        this.description = null;
        this.title = null;
        this.runtime = 0; //in minutes
    }

    public Movie(String movieID,String poster, String description, String title, int runtime, int startDate, int endDate)
    {
        this.movieID = movieID;
        this.poster = poster;
        this.description = description;
        this.title = title;
        this.runtime = runtime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public int getRuntime()
    {
        return runtime;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
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
