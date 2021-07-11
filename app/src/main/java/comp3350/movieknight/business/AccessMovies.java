package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Iterator;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.persistence.DataAccess;
import comp3350.movieknight.objects.Showing;

public class AccessMovies {
    private DataAccess dataAccess;

    public AccessMovies()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getMoviesInTheatres(ArrayList<Movie> movies)
    {
        dataAccess.getAllMovies(movies);
        return FilterList.filterMoviesInTheatres(movies);
    }

    public ArrayList<Movie> getMovieByID(int movieID){
        ArrayList<Movie> movies=new ArrayList<>();
        dataAccess.getAllMovies(movies);
        if(movies!=null){

        Iterator<Movie> iterator=movies.iterator();

            while (iterator.hasNext()) {

                Movie sh = iterator.next();

                if (sh.getMovieID()!=movieID) {
                    iterator.remove();
                }
            }
        }


        return movies;
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
