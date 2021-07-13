package comp3350.movieknight.business;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.persistence.DataAccess;

public class AccessTheatre {
    private DataAccess dataAccess;

    public AccessTheatre() {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public Theatre getTheatre(int theatreID) {
        return dataAccess.getTheatre(new Theatre(theatreID, 1));
    }

    public String insertTheatre(Theatre theatre) {
        return dataAccess.insertTheatre(theatre);
    }

    public String updateTheatre(Theatre theatre) {
        return dataAccess.updateTheatre(theatre);
    }

    public String deleteTheatre(Theatre theatre) {
        return dataAccess.deleteTheatre(theatre);
    }
}
