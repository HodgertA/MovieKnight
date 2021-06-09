package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;

public class FilterList {

    public static String filterMoviesInTheatres(List<Movie> allMovies){

        return null;
    }

    public static String filterShowingsByDate(ArrayList<Showing> allShowing){

        Calendar toDay=Calendar.getInstance();
        Iterator<Showing> iterator=allShowing.iterator();
        while (iterator.hasNext()){
            Showing sh=iterator.next();

            if(     sh.getShowingDate().get(Calendar.YEAR)!=toDay.get(Calendar.YEAR)||
                    sh.getShowingDate().get(Calendar.MONTH)!=toDay.get(Calendar.MONTH)||
                    sh.getShowingDate().get(Calendar.DATE)!=toDay.get(Calendar.DATE)){
                iterator.remove();
            }
        }

        return null;
    }
}
