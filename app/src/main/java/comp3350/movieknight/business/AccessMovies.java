package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.persistence.DatabaseStub;

public class AccessMovies {
    private DatabaseStub dataAccess;

    public AccessMovies()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getMoviesInTheatres(ArrayList<Movie> movies)
    {
        dataAccess.getAllMovies(movies);
        return FilterList.filterMoviesInTheatres(movies);
    }


    public String insertMovie(Movie newMovie)
    {
        return dataAccess.insertMovie(newMovie);
    }

    public String updateMovie(Movie movie)
    {
        return dataAccess.updateMovie(movie);
    }

    public String deleteMovie(Movie movie)
    {
        return dataAccess.deleteMovie(movie);
    }
}
