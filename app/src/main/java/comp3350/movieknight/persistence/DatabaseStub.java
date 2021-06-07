package comp3350.movieknight.persistence;

import java.util.ArrayList;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.User;

public class DatabaseStub {

    private String dbName;
    private String dbType = "stub";

    private ArrayList<Movie> movies;
    //private ArrayList<Theatre> theatres;
    private ArrayList<Showing> showings;
    private ArrayList<User> users;

    public DatabaseStub(String dbName) {this.dbName = dbName; }

    public DatabaseStub() {this.dbName = "DB"; }


}
