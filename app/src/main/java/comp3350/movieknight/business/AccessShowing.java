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
        dataAccess = (DatabaseStub) Services.getDataAccess(Main.dbName);
    }
    public ArrayList<Showing> getShowingForMovie(Movie movie){

        ArrayList<Showing> showingList;
        showingList= dataAccess.getMovieShowings(movie);
        return FilterList.filterShowingsByDate(showingList);

    }
}
