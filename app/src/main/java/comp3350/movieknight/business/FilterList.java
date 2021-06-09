package comp3350.movieknight.business;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import java.util.Calendar;

public class FilterList {

    public static String filterMoviesInTheatres(ArrayList<Movie> movies){
        //get todays date
        long millis=System.currentTimeMillis();
        Calendar todaysDate= Calendar.getInstance();

        //iterate through list of movies
        Iterator<Movie> itr = movies.iterator();
        while (itr.hasNext()) {
            Movie movie = itr.next();

            //if the lastShowDate happened before today
            if(movie.getLastShowDate().compareTo(todaysDate) < 0) {
                itr.remove();//remove from list
            }
        }

        return null;
    }

    public static ArrayList<Showing> filterShowingsByDate(List<Showing> allMovies){

        return null;
    }
}
