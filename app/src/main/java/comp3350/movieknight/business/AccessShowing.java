package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.persistence.DatabaseStub;

public class AccessShowing {
    private DatabaseStub dataAccess;

    public AccessShowing(){
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getShowingForMovie(ArrayList<Showing> showingList, Movie movie){
        showingList = dataAccess.getMovieShowings(new Showing(-1, movie.getMovieID(), -1, 0,0, 0, 0, 0));
        return FilterList.filterShowingsByDate(showingList);
    }
}
