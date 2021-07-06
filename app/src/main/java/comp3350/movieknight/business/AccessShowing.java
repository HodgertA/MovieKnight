package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.persistence.DataAccess;

public class AccessShowing {
    private DataAccess dataAccess;

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
}