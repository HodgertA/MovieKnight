package comp3350.movieknight.objects;

public class Movie
{
    private String movieID;
    private String description;
    private String title;
    private int runtime;

    public Movie(String movieID)
    {
        this.movieID = movieID;
        this.description = null;
        this.title = null;
        this.runtime = 0;
    }

    public Movie(String movieID, String description, String title, int runtime)
    {
        this.movieID = movieID;
        this.description = description;
        this.title = title;
        this.runtime = runtime;
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
