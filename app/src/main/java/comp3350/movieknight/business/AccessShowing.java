package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.persistence.DataAccess;

public class AccessShowing {
    private DataAccess dataAccess;

    public AccessShowing() {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getShowingForMovieByDate(ArrayList<Showing> showingList, int movieID, Calendar date) {
        dataAccess.getMovieShowings(showingList ,movieID);
        return FilterList.filterShowingsBySelectDate(showingList,date);
    }

    public Showing getShowing(int showingID) { return dataAccess.getShowing(new Showing(showingID));}

    public String insertShowing(Showing newShowing) { return dataAccess.insertShowing(newShowing);}

    public String updateShowing(Showing showing) { return dataAccess.updateShowing(showing);}

    public String deleteShowing(Showing showing) { return dataAccess.deleteShowing(showing);}
}