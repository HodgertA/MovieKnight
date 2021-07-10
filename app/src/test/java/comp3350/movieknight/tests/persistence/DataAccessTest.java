package comp3350.movieknight.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;
import comp3350.movieknight.persistence.DataAccess;

public class DataAccessTest extends TestCase {

    private DataAccess dataAccess;

    public DataAccessTest(String arg0)
    {
        super(arg0);
    }

    public void setUp() {
        System.out.println("\nStarting Persistence test DataAccess (using stub)");

        dataAccess = new DatabaseStub();
        dataAccess.open("Stub");
    }

    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    public void testDefaultMovies() {
        ArrayList<Movie> movies;
        Movie movie;
        Calendar lastShowingDate;
        String result;

        System.out.println("Starting DataAccess Test: testDefaultMovies");

        movies = new ArrayList<Movie>();
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(5, movies.size());

        movie = movies.get(0);
        assertEquals(1, movie.getMovieID());
        assertEquals("Description for The Bee Movie", movie.getDescription());
        assertEquals("The Bee Movie", movie.getTitle());
        assertEquals("the_bee_movie", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH));
        assertEquals(8, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(1);
        assertEquals(2, movie.getMovieID());
        assertEquals("Description for Finding Nemo", movie.getDescription());
        assertEquals("Finding Nemo", movie.getTitle());
        assertEquals("finding_nemo", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH));
        assertEquals(9, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(2);
        assertEquals(3, movie.getMovieID());
        assertEquals("Description for Monsters Inc.", movie.getDescription());
        assertEquals("Monsters Inc", movie.getTitle());
        assertEquals("monsters_inc", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH));
        assertEquals(7, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(3);
        assertEquals(4, movie.getMovieID());
        assertEquals("Description for Ice Age", movie.getDescription());
        assertEquals("Ice Age", movie.getTitle());
        assertEquals("ice_age", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(7, lastShowingDate.get(Calendar.MONTH));
        assertEquals(26, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(4);
        assertEquals(5, movie.getMovieID());
        assertEquals("Description for Shrek", movie.getDescription());
        assertEquals("Shrek", movie.getTitle());
        assertEquals("shrek", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH));
        assertEquals(8, lastShowingDate.get(Calendar.DATE));

        System.out.println("Finished DataAccess Test: testDefaultMovies");
    }

    public void testDefaultTheatres() {
        ArrayList<Theatre> theatres;
        Theatre theatre;
        String result;

        System.out.println("Starting DataAccess Test: testDefaultTheatres");

        theatres = new ArrayList<Theatre>();
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(1, theatres.size());

        theatre = theatres.get(0);
        assertEquals(1, theatre.getTheatreID());
        assertEquals(24, theatre.getNumSeats());

        System.out.println("Finished DataAccess Test: testDefaultTheatres");

    }

    public void testDefaultShowings() {
        ArrayList<Showing> showings;
        Showing showing;
        Calendar showingDate;
        Calendar today = Calendar.getInstance();
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        String result;

        System.out.println("Starting DataAccess Test: testDefaultShowings");

        showings = new ArrayList<Showing>();
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(84, showings.size());

        showing = showings.get(0);
        assertEquals(1, showing.getShowingID());
        assertEquals(1, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(today.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(today.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(today.get(Calendar.DATE), showingDate.get(Calendar.DATE));

        System.out.println("Finished DataAccess Test: testDefaultShowings");
    }

    public void testDefaultTickets() {
        ArrayList<Ticket> tickets;
        Ticket ticket;
        String result;

        System.out.println("Starting DataAccess Test: testDefaultTickets");

        tickets = new ArrayList<Ticket>();
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(23, tickets.size());

        ticket = tickets.get(0);
        assertEquals(1, ticket.getUserID());
        assertEquals(1, ticket.getShowingID());
        assertEquals(0, ticket.getSeatNum());

        System.out.println("Finished DataAccess Test: testDefaultTickets");
    }

    public void testDefaultUsers() {
        ArrayList<User> users;
        User user;
        String result;

        System.out.println("Starting DataAccess Test: testDefaultUsers");

        users = new ArrayList<User>();
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(3, users.size());

        user = users.get(0);
        assertEquals(1, user.getUserID());
        assertEquals("Default User", user.getUsername());

        System.out.println("Finished DataAccess Test: testDefaultUsers");
    }

    public void testMovieUpdates() {

    }

    public void testTheatreUpdates() {

    }

    public void testShowingUpdates() {

    }

    public void testTicketUpdates() {

    }

    public void testUserUpdates() {

    }

    public void testRemovingMovies() {

    }

    public void testRemovingTheatres() {

    }

    public void testRemovingShowings() {

    }

    public void testRemovingTickets() {

    }

    public void testRemovingUsers() {

    }

    public void testAddingMovies() {

    }

    public void testAddingTheatres() {

    }

    public void testAddingShowings() {

    }

    public void testAddingTickets() {

    }

    public void testAddingUsers() {

    }
}

