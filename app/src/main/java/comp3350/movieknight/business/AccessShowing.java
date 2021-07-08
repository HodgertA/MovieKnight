package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.persistence.DatabaseStub;

public class AccessShowing {
    private DatabaseStub dataAccess;

    public AccessShowing(){
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getShowingForMovie(ArrayList<Showing> showingList, int movieID){
        dataAccess.getMovieShowings(showingList ,movieID);
        return FilterList.filterShowingsByDate(showingList);
    }
    public String getShowingForMovieByDate(ArrayList<Showing> showingList, int movieID, Calendar date){
        dataAccess.getMovieShowings(showingList ,movieID);
        return FilterList.filterShowingsBySelectDate(showingList,date);
    }
    public ArrayList<Showing> getShowingByID(int ShowingID){
        ArrayList<Showing> showings=new ArrayList<>();
        dataAccess.getAllShowings(showings);

        if(showings != null) {

            Iterator<Showing> iterator = showings.iterator();

            while (iterator.hasNext()) {

                Showing sh = iterator.next();

                if (sh.getShowingID()!=ShowingID) {
                    iterator.remove();
                }
            }
        }


        return showings;
    }
}