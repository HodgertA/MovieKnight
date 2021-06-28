package comp3350.movieknight.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class DataAccessObject implements DataAccess {

    private Statement st1, st2, st3;
    private Connection c1;
    private ResultSet rs2, rs3, rs4, rs5;

    private String dbName;
    private String dbType;

    private ArrayList<Movie> movies;
    private ArrayList<Showing> showings;
    private ArrayList<Theatre> theatres;
    private ArrayList<Ticket> tickets;
    private ArrayList<User> users;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF = "  ";

    public DataAccessObject(String dbName)
    {
        this.dbName = dbName;
    }

    @Override
    public void open(String dbPath) {
        String url;
        try {
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();
            st2 = c1.createStatement();
            st3 = c1.createStatement();
        } catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("Opened " +dbType +" database " +dbPath);
    }

    @Override
    public void close() {
        try
        {	// commit all changes to the database
            cmdString = "shutdown compact";
            rs2 = st1.executeQuery(cmdString);
            c1.close();
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        System.out.println("Closed " +dbType +" database " +dbName);
    }

    @Override
    public String getAllMovies(List<Movie> movieResult) {
        return null;
    }

    @Override
    public String insertMovie(Movie movie) {
        return null;
    }

    @Override
    public String updateMovie(Movie movie) {
        return null;
    }

    @Override
    public String deleteMovie(Movie movie) {
        return null;
    }

    @Override
    public String getAllTheatres(List<Theatre> theatreResult) {
        return null;
    }

    @Override
    public Theatre getTheatre(Theatre theatre) {
        return null;
    }

    @Override
    public String insertTheatre(Theatre theatre) {
        return null;
    }

    @Override
    public String updateTheatre(Theatre theatre) {
        return null;
    }

    @Override
    public String deleteTheatre(Theatre theatre) {
        return null;
    }

    @Override
    public String getAllShowings(List<Showing> showingResult) {
        return null;
    }

    @Override
    public String getMovieShowings(ArrayList<Showing> showingList, int movieId) {
        return null;
    }

    @Override
    public ArrayList<Showing> getTheatreShowings(Showing showing) {
        return null;
    }

    @Override
    public ArrayList<Showing> getDateShowings(Showing showing) {
        return null;
    }

    @Override
    public String insertShowing(Showing showing) {
        return null;
    }

    @Override
    public String updateShowing(Showing showing) {
        return null;
    }

    @Override
    public String deleteShowing(Showing showing) {
        return null;
    }

    @Override
    public String getAllUsers(List<User> userResult) {
        return null;
    }

    @Override
    public String insertUser(User user) {
        return null;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public String deleteUser(User user) {
        return null;
    }

    @Override
    public String getAllTickets(List<Ticket> ticketResult) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getShowingTickets(Ticket ticket) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getUserTickets(Ticket ticket) {
        return null;
    }

    @Override
    public String insertTicket(Ticket ticket) {
        return null;
    }

    @Override
    public String updateTicket(Ticket ticket) {
        return null;
    }

    @Override
    public String deleteTicket(Ticket ticket) {
        return null;
    }

    public String processSQLError(Exception e)
    {
        String result = "*** SQL Error: " + e.getMessage();
        e.printStackTrace();

        return result;
    }
}
