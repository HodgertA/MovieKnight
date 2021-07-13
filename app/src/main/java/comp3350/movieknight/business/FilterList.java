package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;

public class FilterList {

    public static String filterMoviesInTheatres(ArrayList<Movie> movies) {
        Calendar today = Calendar.getInstance();
        Iterator<Movie> iterator = movies.iterator();

        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            Calendar lastShowDate = movie.getLastShowDate();

            //if the lastShowDate happened before today
            if(lastShowDate.get(Calendar.YEAR) < today.get(Calendar.YEAR) || /*last year*/
                    (lastShowDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) && lastShowDate.get(Calendar.MONTH) < today.get(Calendar.MONTH)) || /*last month*/
                    (lastShowDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) && lastShowDate.get(Calendar.MONTH) == today.get(Calendar.MONTH) && lastShowDate.get(Calendar.DATE) < today.get(Calendar.DATE)) /* yesterday*/) {
                iterator.remove();//remove from list
            }
        }

        return null;
    }

    public static String filterShowingsBySelectDate(ArrayList<Showing> showings,Calendar date) {

        if(showings != null) {
            Iterator<Showing> iterator = showings.iterator();

            while (iterator.hasNext()) {
                Showing sh = iterator.next();

                if (sh==null || sh.getShowingDate().get(Calendar.YEAR) != date.get(Calendar.YEAR) ||
                        sh.getShowingDate().get(Calendar.MONTH) != date.get(Calendar.MONTH) ||
                        sh.getShowingDate().get(Calendar.DATE) != date.get(Calendar.DATE)) {
                    iterator.remove();
                }
            }
        }

        return null;
    }
}
