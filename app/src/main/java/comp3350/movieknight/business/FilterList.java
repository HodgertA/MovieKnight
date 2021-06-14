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
            Calendar lastShowDate = movie.getLastShowDate();

            //if the lastShowDate happened before today
            if(lastShowDate.get(Calendar.YEAR) < todaysDate.get(Calendar.YEAR) || //last year
                    (lastShowDate.get(Calendar.YEAR) == todaysDate.get(Calendar.YEAR) && lastShowDate.get(Calendar.MONTH) < todaysDate.get(Calendar.MONTH)) || //last month
                    (lastShowDate.get(Calendar.YEAR) == todaysDate.get(Calendar.YEAR) && lastShowDate.get(Calendar.MONTH) == todaysDate.get(Calendar.MONTH) && lastShowDate.get(Calendar.DATE) < todaysDate.get(Calendar.DATE)) // yesterday
                ) {
                itr.remove();//remove from list
            }
        }

        return null;
    }

    public static String filterShowingsByDate(ArrayList<Showing> allShowings){

        if(allShowings!=null) {
            Calendar today = Calendar.getInstance();
            Iterator<Showing> iterator = allShowings.iterator();
            while (iterator.hasNext()) {
                Showing sh = iterator.next();

                if (sh==null ||
                        sh.getShowingDate().get(Calendar.YEAR) != today.get(Calendar.YEAR) ||
                        sh.getShowingDate().get(Calendar.MONTH) != today.get(Calendar.MONTH) ||
                        sh.getShowingDate().get(Calendar.DATE) != today.get(Calendar.DATE)
                ) {
                    iterator.remove();
                }
            }
        }

        return null;
    }
}
