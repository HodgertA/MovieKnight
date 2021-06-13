package comp3350.movieknight.business;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

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

    public static String filterShowingsByDate(ArrayList<Showing> allShowing){

        if(allShowing!=null) {
            Calendar toDay = Calendar.getInstance();
            Iterator<Showing> iterator = allShowing.iterator();
            while (iterator.hasNext()) {
                Showing sh = iterator.next();

                if (    sh==null||
                        sh.getShowingDate().get(Calendar.YEAR) != toDay.get(Calendar.YEAR) ||
                        sh.getShowingDate().get(Calendar.MONTH) != toDay.get(Calendar.MONTH) ||
                        sh.getShowingDate().get(Calendar.DATE) != toDay.get(Calendar.DATE)) {
                    iterator.remove();
                }
            }
        }

        return null;
    }
}
