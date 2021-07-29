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

    public static void dataAccessTest(DataAccess dataAccess) {
        DataAccessTest dataAccessTest = new DataAccessTest("");
        dataAccessTest.dataAccess = dataAccess;

        dataAccessTest.testDefaultMovies();
        dataAccessTest.testDefaultTheatres();
        dataAccessTest.testDefaultShowings();
        dataAccessTest.testDefaultTickets();
        dataAccessTest.testDefaultUsers();

        dataAccessTest.testTypicalMovies();
        dataAccessTest.testTypicalShowings();
        dataAccessTest.testTypicalTheatres();
        dataAccessTest.testTypicalTickets();
        dataAccessTest.testTypicalUsers();

        dataAccessTest.testInvalidIDs();
        dataAccessTest.testNonexistentIDs();

        dataAccessTest.testNonexistentObjects();
        dataAccessTest.testDuplicateObjects();
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
        assertEquals(6, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(8, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(1);
        assertEquals(2, movie.getMovieID());
        assertEquals("Description for Finding Nemo", movie.getDescription());
        assertEquals("Finding Nemo", movie.getTitle());
        assertEquals("finding_nemo", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(9, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(2);
        assertEquals(3, movie.getMovieID());
        assertEquals("Description for Monsters Inc.", movie.getDescription());
        assertEquals("Monsters Inc.", movie.getTitle());
        assertEquals("monsters_inc", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(7, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(3);
        assertEquals(4, movie.getMovieID());
        assertEquals("Description for Ice Age", movie.getDescription());
        assertEquals("Ice Age", movie.getTitle());
        assertEquals("ice_age", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(8, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(26, lastShowingDate.get(Calendar.DATE));

        movie = movies.get(4);
        assertEquals(5, movie.getMovieID());
        assertEquals("Description for Shrek", movie.getDescription());
        assertEquals("Shrek", movie.getTitle());
        assertEquals("shrek", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(8, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(26, lastShowingDate.get(Calendar.DATE));

        movie = new Movie(1, "", "", "", 1, 1, 1, 1);
        movie = dataAccess.getMovie(movie);
        assertEquals(1, movie.getMovieID());
        assertEquals("Description for The Bee Movie", movie.getDescription());
        assertEquals("The Bee Movie", movie.getTitle());
        assertEquals("the_bee_movie", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(6, lastShowingDate.get(Calendar.MONTH)+1);
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

        theatre = new Theatre(1, 24);
        theatre = dataAccess.getTheatre(theatre);
        assertEquals(1, theatre.getTheatreID());
        assertEquals(24, theatre.getNumSeats());

        System.out.println("Finished DataAccess Test: testDefaultTheatres");
    }

    public void testDefaultShowings() {
        ArrayList<Showing> showings;
        Showing showing;
        Calendar showingDate;
        Calendar day = Calendar.getInstance();
        String result;

        System.out.println("Starting DataAccess Test: testDefaultShowings");

        showings = new ArrayList<Showing>();
        result = dataAccess.getAllShowings(showings);
        //assertNull(result);
        assertEquals(84, showings.size());

        showing = showings.get(0);
        assertEquals(1, showing.getShowingID());
        assertEquals(1, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(day.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showingDate.get(Calendar.DATE));
        assertEquals(8, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showing = showings.get(12);
        day.add(Calendar.DATE, 1);
        assertEquals(13, showing.getShowingID());
        assertEquals(1, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(day.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showingDate.get(Calendar.DATE));
        assertEquals(8, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showing = showings.get(41);
        day.add(Calendar.DATE, 2);
        assertEquals(42, showing.getShowingID());
        assertEquals(2, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(day.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showingDate.get(Calendar.DATE));
        assertEquals(12, showing.getShowingHour());
        assertEquals(55, showing.getShowingMinute());

        showing = showings.get(69);
        day.add(Calendar.DATE, 2);
        assertEquals(70, showing.getShowingID());
        assertEquals(4, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(day.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showingDate.get(Calendar.DATE));
        assertEquals(20, showing.getShowingHour());
        assertEquals(35, showing.getShowingMinute());

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 1);
        assertNull(result);
        assertEquals(14, showings.size());
        showing = showings.get(0);
        assertEquals(1, showing.getShowingID());
        showing = showings.get(1);
        assertEquals(2, showing.getShowingID());
        showing = showings.get(2);
        assertEquals(13, showing.getShowingID());
        showing = showings.get(3);
        assertEquals(14, showing.getShowingID());
        showing = showings.get(4);
        assertEquals(25, showing.getShowingID());
        showing = showings.get(5);
        assertEquals(26, showing.getShowingID());
        showing = showings.get(6);
        assertEquals(37, showing.getShowingID());
        showing = showings.get(7);
        assertEquals(38, showing.getShowingID());
        showing = showings.get(8);
        assertEquals(49, showing.getShowingID());
        showing = showings.get(9);
        assertEquals(50, showing.getShowingID());
        showing = showings.get(10);
        assertEquals(61, showing.getShowingID());
        showing = showings.get(11);
        assertEquals(62, showing.getShowingID());
        showing = showings.get(12);
        assertEquals(73, showing.getShowingID());
        showing = showings.get(13);
        assertEquals(74, showing.getShowingID());

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(84, showings.size());

        day.add(Calendar.DATE, -5);
        showing = new Showing(12, 1, 1, 24, 1, 1, 1, 1, 1);
        showing = dataAccess.getShowing(showing);
        assertEquals(5, showing.getMovieID());
        assertEquals(1,showing.getTheatreID());
        assertEquals(24, showing.getSeats());
        showingDate = showing.getShowingDate();
        assertEquals(day.get(Calendar.YEAR), showingDate.get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showingDate.get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showingDate.get(Calendar.DATE));
        assertEquals(9, showing.getShowingHour());
        assertEquals(45, showing.getShowingMinute());

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
        assertEquals(24, tickets.size());

        ticket = tickets.get(0);
        assertEquals(1, ticket.getUserID());
        assertEquals(1, ticket.getShowingID());
        assertEquals(0, ticket.getSeatNum());

        ticket = tickets.get(14);
        assertEquals(3, ticket.getUserID());
        assertEquals(6, ticket.getShowingID());
        assertEquals(14, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 5);
        assertNull(result);
        assertEquals(1, tickets.size());
        ticket = tickets.get(0);
        assertEquals(1, ticket.getUserID());
        assertEquals(12, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 12);
        assertNull(result);
        assertEquals(4, tickets.size());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 1);
        assertNull(result);
        assertEquals(8, tickets.size());
        ticket = tickets.get(2);
        assertEquals(2, ticket.getShowingID());
        assertEquals(6, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 3);
        assertNull(result);
        assertEquals(8, tickets.size());

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
        assertEquals(4, users.size());

        user = users.get(0);
        assertEquals(1, user.getUserID());
        assertEquals("Default User", user.getUsername());

        user = users.get(1);
        assertEquals(2, user.getUserID());
        assertEquals("User2", user.getUsername());

        user = users.get(2);
        assertEquals(3, user.getUserID());
        assertEquals("User3", user.getUsername());

        System.out.println("Finished DataAccess Test: testDefaultUsers");
    }

    public void testTypicalMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie;
        String result;
        Calendar lastShowingDate;

        System.out.println("Starting DataAccess Test: testTypicalMovies");

        movie = new Movie(6, "A description", "A title", "a_poster", 120, 2022, 12, 24);
        result = dataAccess.insertMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(6, movies.size());
        assertTrue(movies.contains(movie));
        movie = movies.get(5);
        assertEquals(6, movie.getMovieID());
        assertEquals("A description", movie.getDescription());
        assertEquals("A title", movie.getTitle());
        assertEquals("a_poster", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(12, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(24, lastShowingDate.get(Calendar.DATE));

        movies.clear();
        movie = new Movie(6, "New description", "New title", "new_poster", 20, 2021, 1, 1);
        result = dataAccess.updateMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertTrue(movies.contains(movie));
        assertEquals(6, movies.size());
        movie = movies.get(5);
        assertEquals(6, movie.getMovieID());
        assertEquals("New description", movie.getDescription());
        assertEquals("New title", movie.getTitle());
        assertEquals("new_poster", movie.getPoster());
        assertEquals(20, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(1, lastShowingDate.get(Calendar.MONTH)+1);
        assertEquals(1, lastShowingDate.get(Calendar.DATE));

        movies.clear();
        movie = new Movie(6, "", "", "", 1, 1, 1, 1);
        result = dataAccess.deleteMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(5, movies.size());
        assertFalse(movies.contains(movie));

        System.out.println("Finished DataAccess Test: testTypicalMovies");
    }

    public void testTypicalTheatres() {
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        Theatre theatre;
        String result;

        System.out.println("Starting DataAccess Test: testTypicalTheatres");

        theatre = new Theatre(2, 20);
        result = dataAccess.insertTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(2, theatres.size());
        assertTrue(theatres.contains(theatre));
        theatre = theatres.get(1);
        assertEquals(2, theatre.getTheatreID());
        assertEquals(20, theatre.getNumSeats());

        theatres.clear();
        theatre = new Theatre(2, 40);
        result = dataAccess.updateTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertTrue(theatres.contains(theatre));
        assertEquals(2, theatres.size());
        theatre = theatres.get(1);
        assertEquals(2, theatre.getTheatreID());
        assertEquals(40, theatre.getNumSeats());

        theatres.clear();
        theatre = new Theatre(2, 40);
        result = dataAccess.deleteTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(1, theatres.size());
        assertFalse(theatres.contains(theatre));

        System.out.println("Finished DataAccess Test: testTypicalTheatres");
    }

    public void testTypicalShowings() {
        ArrayList<Showing> showings = new ArrayList<Showing>();
        Showing showing;
        String result;
        Calendar today = Calendar.getInstance();

        System.out.println("Starting DataAccess Test: testTypicalShowings");

        showing = new Showing(85, 3, 1, 20, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15);
        result = dataAccess.insertShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(85, showings.size());
        assertTrue(showings.contains(showing));
        showing = showings.get(84);
        assertEquals(85, showing.getShowingID());
        assertEquals(3, showing.getMovieID());
        assertEquals(1, showing.getTheatreID());
        assertEquals(20, showing.getSeats());
        assertEquals(today.get(Calendar.YEAR), showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(today.get(Calendar.MONTH), showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(today.get(Calendar.DATE), showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(85, showings.size());
        assertTrue(showings.contains(new Showing(85, 3, 1, 20, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 3);
        assertNull(result);
        assertEquals(22, showings.size());
        assertTrue(showings.contains(new Showing(85, 3, 1, 20, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        showing = new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15);
        result = dataAccess.updateShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(85, showings.size());
        assertTrue(showings.contains(new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));
        showing = showings.get(84);
        assertEquals(85, showing.getShowingID());
        assertEquals(2, showing.getMovieID());
        assertEquals(1, showing.getTheatreID());
        assertEquals(21, showing.getSeats());
        assertEquals(today.get(Calendar.YEAR), showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(today.get(Calendar.MONTH), showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(today.get(Calendar.DATE), showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(85, showings.size());
        assertTrue(showings.contains(new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 3);
        assertNull(result);
        assertEquals(21, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 2);
        assertNull(result);
        assertEquals(29, showings.size());
        assertTrue(showings.contains(new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        showing = new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15);
        result = dataAccess.deleteShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(84, showings.size());
        assertFalse(showings.contains(showing));

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(84, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 21, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 2);
        assertNull(result);
        assertEquals(28, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 20, today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE), 10, 15)));

        dataAccess.deleteShowing(showing);

        System.out.println("Finished DataAccess Test: testTypicalShowings");
    }

    public void testTypicalTickets() {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Ticket ticket;
        String result;

        System.out.println("Starting DataAccess Test: testTypicalTickets");

        ticket = new Ticket(3, 13, 3);
        result = dataAccess.insertTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(25, tickets.size());
        assertTrue(tickets.contains(ticket));
        ticket = tickets.get(24);
        assertEquals(3, ticket.getUserID());
        assertEquals(13, ticket.getShowingID());
        assertEquals(3, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 3);
        assertNull(result);
        assertEquals(9, tickets.size());
        assertTrue(tickets.contains(new Ticket(3, 13,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 13);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(new Ticket(3, 13,3)));

        tickets.clear();
        ticket = new Ticket(2, 13, 3);
        result = dataAccess.updateTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(25, tickets.size());
        assertTrue(tickets.contains(new Ticket(2, 13, 3)));
        ticket = tickets.get(24);
        assertEquals(2, ticket.getUserID());
        assertEquals(13, ticket.getShowingID());
        assertEquals(3, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 3);
        assertNull(result);
        assertEquals(8, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 13,3)));

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 2);
        assertNull(result);
        assertEquals(9, tickets.size());
        assertTrue(tickets.contains(new Ticket(2, 13,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 13);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertFalse(tickets.contains(new Ticket(3, 2,3)));

        tickets.clear();
        ticket = new Ticket(2, 13, 3);
        result = dataAccess.deleteTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(24, tickets.size());
        assertFalse(tickets.contains(ticket));

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 2);
        assertNull(result);
        assertEquals(8, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 13,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 3);
        assertNull(result);
        assertEquals(3, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 13,3)));

        System.out.println("Finished DataAccess Test: testTypicalTickets");
    }

    public void testTypicalUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user;
        String result;

        System.out.println("Starting DataAccess Test: testTypicalUsers");

        user = new User(5, "Bob");
        result = dataAccess.insertUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(5, users.size());
        assertTrue(users.contains(user));
        user = users.get(4);
        assertEquals(5, user.getUserID());
        assertEquals("Bob", user.getUsername());

        users.clear();
        user = new User(5, "Greg");
        result = dataAccess.updateUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(5, users.size());
        assertTrue(users.contains(user));
        user = users.get(4);
        assertEquals(5, user.getUserID());
        assertEquals("Greg", user.getUsername());

        users.clear();
        user = new User(5, "Greg");
        result = dataAccess.deleteUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(4, users.size());
        assertFalse(users.contains(user));

        System.out.println("Finished DataAccess Test: testTypicalUsers");
    }

    public void testDuplicateObjects() {
        String result;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        ArrayList<Showing> showings = new ArrayList<Showing>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        ArrayList<User> users = new ArrayList<User>();

        Movie movie;
        Theatre theatre;
        Showing showing;
        Ticket ticket;
        User user;

        System.out.println("Started DataAccess Test: testDuplicateObjects");

        movie = new Movie(1, "", "", "", 1, 1, 1, 1);
        result = dataAccess.insertMovie(movie);
        assertTrue(result.contains("Violation of unique constraint"));

        dataAccess.getAllMovies(movies);
        assertEquals(5, movies.size());

        theatre = new Theatre(1, 24);
        result = dataAccess.insertTheatre(theatre);
        assertTrue(result.contains("Violation of unique constraint"));
        dataAccess.getAllTheatres(theatres);
        assertEquals(1, theatres.size());

        showing = new Showing(1, 1, 1, 10, 1, 1, 1, 1, 1);
        result = dataAccess.insertShowing(showing);
        assertTrue(result.contains("Violation of unique constraint"));
        dataAccess.getAllShowings(showings);
        assertEquals(84, showings.size());

        ticket = new Ticket(1, 1, 0);
        result = dataAccess.insertTicket(ticket);
        assertTrue(result.contains("Violation of unique constraint"));
        dataAccess.getAllTickets(tickets);
        assertEquals(24, tickets.size());

        user = new User(1, "Bob");
        result = dataAccess.insertUser(user);
        assertTrue(result.contains("Violation of unique constraint"));
        dataAccess.getAllUsers(users);
        assertEquals(4, users.size());

        System.out.println("Finished DataAccess Test: testDuplicateObjects");
    }

    public void testNonexistentObjects() {
        String result;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        ArrayList<Showing> showings = new ArrayList<Showing>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        ArrayList<User> users = new ArrayList<User>();

        Movie movie;
        Theatre theatre;
        Showing showing;
        Ticket ticket;
        User user;

        System.out.println("Started DataAccess Test: testNonExistentObjects");

        movie = new Movie(6, "", "", "", 1, 1, 1, 1);
        result = dataAccess.updateMovie(movie);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllMovies(movies);
        assertFalse(movies.contains(movie));

        movies.clear();
        result = dataAccess.deleteMovie(movie);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllMovies(movies);
        assertEquals(5, movies.size());

        movie = dataAccess.getMovie(movie);
        assertNull(movie);

        theatre = new Theatre(6, 1);
        result = dataAccess.updateTheatre(theatre);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllTheatres(theatres);
        assertFalse(theatres.contains(theatre));

        theatres.clear();
        result = dataAccess.deleteTheatre(theatre);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllTheatres(theatres);
        assertEquals(1, theatres.size());

        theatre = dataAccess.getTheatre(theatre);
        assertNull(theatre);

        showing = new Showing(90, 1, 1, 1, 1, 1, 1, 10, 10);
        result = dataAccess.updateShowing(showing);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllShowings(showings);
        assertFalse(showings.contains(showing));

        showings.clear();
        result = dataAccess.deleteShowing(showing);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllShowings(showings);
        assertEquals(84, showings.size());

        showing = dataAccess.getShowing(showing);
        assertNull(showing);

        ticket = new Ticket(3, 12, 3);
        result = dataAccess.updateTicket(ticket);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllTickets(tickets);
        assertFalse(tickets.contains(ticket));

        tickets.clear();
        result = dataAccess.deleteTicket(ticket);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllTickets(tickets);
        assertEquals(24, tickets.size());

        user = new User(6, "Polly");
        result = dataAccess.updateUser(user);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllUsers(users);
        assertFalse(users.contains(user));

        users.clear();
        result = dataAccess.deleteUser(user);
        assertEquals("Tuple not inserted correctly.", result);
        dataAccess.getAllUsers(users);
        assertEquals(4, users.size());

        System.out.println("Finished DataAccess Test: testNonExistentObjects");
    }

    public void testInvalidIDs() {
        ArrayList<Showing> showings = new ArrayList<Showing>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        String result;

        System.out.println("Started DataAccessTest: testInvalidIDs");

        result = dataAccess.getMovieShowings(showings, -1);
        assertNull(result);
        assertTrue(showings.isEmpty());

        result = dataAccess.getTheatreShowings(showings, -1);
        assertNull(result);
        assertTrue(showings.isEmpty());

        result = dataAccess.getShowingTickets(tickets, -1);
        assertNull(result);
        assertTrue(tickets.isEmpty());

        result = dataAccess.getUserTickets(tickets, -1);
        assertNull(result);
        assertTrue(tickets.isEmpty());

        System.out.println("Finished DataAccessTest: testInvalidIDs");
    }

    public void testNonexistentIDs() {
        ArrayList<Showing> showings = new ArrayList<Showing>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        String result;

        System.out.println("Started DataAccessTest: testNonexistentIDs");

        result = dataAccess.getMovieShowings(showings, 100);
        assertNull(result);
        assertTrue(showings.isEmpty());

        result = dataAccess.getTheatreShowings(showings, 100);
        assertNull(result);
        assertTrue(showings.isEmpty());

        result = dataAccess.getShowingTickets(tickets, 100);
        assertNull(result);
        assertTrue(tickets.isEmpty());

        result = dataAccess.getUserTickets(tickets, 100);
        assertNull(result);
        assertTrue(tickets.isEmpty());

        System.out.println("Finished DataAccessTest: testNonexistentIDs");
    }

    public void testEmptyMovieTable() {
        ArrayList<Movie> movies;
        Movie movie;
        Calendar lastShowingDate;
        String result;

        System.out.println("Started DataAccess Test: testEmptyMovieTable");

        dataAccess.deleteMovie(new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6,8));
        dataAccess.deleteMovie(new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6,9));
        dataAccess.deleteMovie(new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6,7));
        dataAccess.deleteMovie(new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 7,26));
        dataAccess.deleteMovie(new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 7,26));

        movies = new ArrayList<Movie>();
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(0, movies.size());

        movie = dataAccess.getMovie(new Movie(1, "", "", "", 120, 1, 1, 1));
        assertNull(movie);

        movies.clear();
        movie = new Movie(6, "A description", "A title", "a_poster", 120, 2022, 12, 24);
        result = dataAccess.insertMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(1, movies.size());
        assertTrue(movies.contains(movie));
        movie = movies.get(0);
        assertEquals(6, movie.getMovieID());
        assertEquals("A description", movie.getDescription());
        assertEquals("A title", movie.getTitle());
        assertEquals("a_poster", movie.getPoster());
        assertEquals(120, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2022, lastShowingDate.get(Calendar.YEAR));
        assertEquals(12, lastShowingDate.get(Calendar.MONTH) + 1);
        assertEquals(24, lastShowingDate.get(Calendar.DATE));

        movies.clear();
        movie = new Movie(6, "New description", "New title", "new_poster", 20, 2021, 1, 1);
        result = dataAccess.updateMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertTrue(movies.contains(movie));
        assertEquals(1, movies.size());
        movie = movies.get(0);
        assertEquals(6, movie.getMovieID());
        assertEquals("New description", movie.getDescription());
        assertEquals("New title", movie.getTitle());
        assertEquals("new_poster", movie.getPoster());
        assertEquals(20, movie.getRuntime());
        lastShowingDate = movie.getLastShowDate();
        assertEquals(2021, lastShowingDate.get(Calendar.YEAR));
        assertEquals(1, lastShowingDate.get(Calendar.MONTH) +1);
        assertEquals(1, lastShowingDate.get(Calendar.DATE));

        movies.clear();
        movie = new Movie(6, "", "", "", 1, 1, 1, 1);
        result = dataAccess.deleteMovie(movie);
        assertNull(result);
        result = dataAccess.getAllMovies(movies);
        assertNull(result);
        assertEquals(0, movies.size());
        assertFalse(movies.contains(movie));

        result = dataAccess.deleteMovie(movie);

        dataAccess.insertMovie(new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6,8));
        dataAccess.insertMovie(new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6,9));
        dataAccess.insertMovie(new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6,7));
        dataAccess.insertMovie(new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 8,26));
        dataAccess.insertMovie(new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 8,26));

        System.out.println("Finished DataAccessTest: testEmptyMovieTable");
    }

    public void testEmptyTheatreTable() {
        ArrayList<Theatre> theatres;
        Theatre theatre;
        String result;

        System.out.println("Started DataAccessTest: testEmptyTheatreTable");

        dataAccess.deleteTheatre(new Theatre(1, 24));

        theatres = new ArrayList<Theatre>();
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(0, theatres.size());

        theatres.clear();
        theatre = dataAccess.getTheatre(new Theatre(4, 10));
        assertNull(theatre);

        theatres.clear();
        theatre = new Theatre(2, 20);
        result = dataAccess.insertTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(1, theatres.size());
        assertTrue(theatres.contains(theatre));
        theatre = theatres.get(0);
        assertEquals(2, theatre.getTheatreID());
        assertEquals(20, theatre.getNumSeats());

        theatres.clear();
        theatre = new Theatre(2, 40);
        result = dataAccess.updateTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertTrue(theatres.contains(theatre));
        assertEquals(1, theatres.size());
        theatre = theatres.get(0);
        assertEquals(2, theatre.getTheatreID());
        assertEquals(40, theatre.getNumSeats());

        theatres.clear();
        theatre = new Theatre(2, 40);
        result = dataAccess.deleteTheatre(theatre);
        assertNull(result);
        result = dataAccess.getAllTheatres(theatres);
        assertNull(result);
        assertEquals(0, theatres.size());
        assertFalse(theatres.contains(theatre));

        result = dataAccess.deleteTheatre(theatre);
        assertNotNull(result);

        dataAccess.insertTheatre(new Theatre(1, 24));

        System.out.println("Finished DataAccessTest: testEmptyTheatreTable");
    }

    public void testEmptyShowingTable() {
        ArrayList<Showing> showings;
        Showing showing;
        String result;
        Calendar day = Calendar.getInstance();

        System.out.println("Started DataAccessTest: testEmptyShowingTable");

        dataAccess.deleteShowing(new Showing(1, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(2, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(3, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(4, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(5, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(6, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(7, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(8, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(9, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(10, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(11, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(12, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(13, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(14, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(15, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(16, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(17, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(18, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(19, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(20, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(21, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(22, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(23, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(24, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(25, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(26, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(27, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(28, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(29, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(30, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(31, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(32, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(33, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(34, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(35, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(36, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(37, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(38, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(39, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(40, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(41, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(42, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(43, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(44, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(45, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(46, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(47, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(48, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(49, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(50, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(51, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(52, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(53, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(54, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(55, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(56, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(57, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(58, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(59, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(60, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(61, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(62, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(63, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(64, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(65, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(66, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(67, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(68, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(69, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(70, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(71, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(72, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        dataAccess.deleteShowing(new Showing(73, 1, 1, 24, day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));
        dataAccess.deleteShowing(new Showing(74, 1, 1, 24, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(75, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));
        dataAccess.deleteShowing(new Showing(76, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));
        dataAccess.deleteShowing(new Showing(77, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));
        dataAccess.deleteShowing(new Showing(78, 2, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));
        dataAccess.deleteShowing(new Showing(79, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));
        dataAccess.deleteShowing(new Showing(80, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));
        dataAccess.deleteShowing(new Showing(81, 3, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));
        dataAccess.deleteShowing(new Showing(82, 4, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));
        dataAccess.deleteShowing(new Showing(83, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));
        dataAccess.deleteShowing(new Showing(84, 5, 1, 24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

        showings = new ArrayList<Showing>();
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(0, showings.size());

        showings.clear();
        showing = dataAccess.getShowing(new Showing(1, 1, 1, 1, 1, 1, 1, 1,1));
        showing = dataAccess.getShowing(showing);
        assertNull(showing);

        showing = new Showing(85, 3, 1, 20, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15);
        result = dataAccess.insertShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(1,  showings.size());
        assertTrue(showings.contains(showing));
        showing = showings.get(0);
        assertEquals(85, showing.getShowingID());
        assertEquals(3, showing.getMovieID());
        assertEquals(1, showing.getTheatreID());
        assertEquals(20, showing.getSeats());
        assertEquals(day.get(Calendar.YEAR), showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(1, showings.size());
        assertTrue(showings.contains(new Showing(85, 3, 1, 20, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 3);
        assertNull(result);
        assertEquals(1, showings.size());
        assertTrue(showings.contains(new Showing(85, 3, 1, 20, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        showing = new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15);
        result = dataAccess.updateShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(1, showings.size());
        assertTrue(showings.contains(showing));
        showing = showings.get(0);
        assertEquals(85, showing.getShowingID());
        assertEquals(2, showing.getMovieID());
        assertEquals(1, showing.getTheatreID());
        assertEquals(21, showing.getSeats());
        assertEquals(day.get(Calendar.YEAR), showing.getShowingDate().get(Calendar.YEAR));
        assertEquals(day.get(Calendar.MONTH), showing.getShowingDate().get(Calendar.MONTH));
        assertEquals(day.get(Calendar.DATE), showing.getShowingDate().get(Calendar.DATE));
        assertEquals(10, showing.getShowingHour());
        assertEquals(15, showing.getShowingMinute());

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(1, showings.size());
        assertTrue(showings.contains(new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 3);
        assertNull(result);
        assertEquals(0, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 2);
        assertNull(result);
        assertEquals(1, showings.size());
        assertTrue(showings.contains(new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        showing = new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15);
        result = dataAccess.deleteShowing(showing);
        assertNull(result);
        result = dataAccess.getAllShowings(showings);
        assertNull(result);
        assertEquals(0, showings.size());
        assertFalse(showings.contains(showing));

        showings.clear();
        result = dataAccess.getTheatreShowings(showings, 1);
        assertNull(result);
        assertEquals(0, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 21, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        showings.clear();
        result = dataAccess.getMovieShowings(showings, 2);
        assertNull(result);
        assertEquals(0, showings.size());
        assertFalse(showings.contains(new Showing(85, 2, 1, 20, day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1, day.get(Calendar.DATE), 10, 15)));

        result = dataAccess.deleteShowing(showing);
        assertNotNull(result);

        System.out.println("Finished DataAccessTest: testEmptyShowingTable");
    }

    public void testEmptyTicketTable() {
        ArrayList<Ticket> tickets;
        Ticket ticket;
        String result;

        System.out.println("Started DataAccessTest: testEmptyTicketTable");

        dataAccess.deleteTicket(new Ticket(1, 1, 0));
        dataAccess.deleteTicket(new Ticket(2, 1, 1));
        dataAccess.deleteTicket(new Ticket(3, 1, 2));
        dataAccess.deleteTicket(new Ticket(1, 1, 3));
        dataAccess.deleteTicket(new Ticket(2, 2, 4));
        dataAccess.deleteTicket(new Ticket(3, 2, 5));
        dataAccess.deleteTicket(new Ticket(1, 2, 6));
        dataAccess.deleteTicket(new Ticket(2, 2, 7));
        dataAccess.deleteTicket(new Ticket(3, 3, 8));
        dataAccess.deleteTicket(new Ticket(1, 3, 9));
        dataAccess.deleteTicket(new Ticket(2, 3, 10));
        dataAccess.deleteTicket(new Ticket(3, 4, 11));
        dataAccess.deleteTicket(new Ticket(1, 5, 12));
        dataAccess.deleteTicket(new Ticket(2, 6, 13));
        dataAccess.deleteTicket(new Ticket(3, 6, 14));
        dataAccess.deleteTicket(new Ticket(1, 7, 15));
        dataAccess.deleteTicket(new Ticket(2, 8, 16));
        dataAccess.deleteTicket(new Ticket(3, 9,17));
        dataAccess.deleteTicket(new Ticket(1, 10, 18));
        dataAccess.deleteTicket(new Ticket(2, 11, 19));
        dataAccess.deleteTicket(new Ticket(3, 12, 1));
        dataAccess.deleteTicket(new Ticket(1, 12, 4));
        dataAccess.deleteTicket(new Ticket(2, 12,8));
        dataAccess.deleteTicket(new Ticket(3, 12,5));

        tickets = new ArrayList<Ticket>();
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(0, tickets.size());

        tickets.clear();
        ticket = new Ticket(3, 3, 3);
        result = dataAccess.insertTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(ticket));
        ticket = tickets.get(0);
        assertEquals(3, ticket.getUserID());
        assertEquals(3, ticket.getShowingID());
        assertEquals(3, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 3);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(new Ticket(3, 3,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 3);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(new Ticket(3, 3,3)));

        tickets.clear();
        ticket = new Ticket(2, 3, 3);
        result = dataAccess.updateTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(ticket));
        ticket = tickets.get(0);
        assertEquals(2, ticket.getUserID());
        assertEquals(3, ticket.getShowingID());
        assertEquals(3, ticket.getSeatNum());

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 2);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(new Ticket(2, 3,3)));

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 3);
        assertNull(result);
        assertEquals(0, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 3,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 3);
        assertNull(result);
        assertEquals(1, tickets.size());
        assertFalse(tickets.contains(new Ticket(3, 2,3)));

        tickets.clear();
        ticket = new Ticket(2, 3, 3);
        result = dataAccess.deleteTicket(ticket);
        assertNull(result);
        result = dataAccess.getAllTickets(tickets);
        assertNull(result);
        assertEquals(0, tickets.size());
        assertFalse(tickets.contains(ticket));

        tickets.clear();
        result = dataAccess.getUserTickets(tickets, 2);
        assertNull(result);
        assertEquals(0, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 3,3)));

        tickets.clear();
        result = dataAccess.getShowingTickets(tickets, 3);
        assertNull(result);
        assertEquals(0, tickets.size());
        assertFalse(tickets.contains(new Ticket(2, 3,3)));

        result = dataAccess.deleteTicket(ticket);
        assertNotNull(result);

        System.out.println("Finished DataAccessTest: testEmptyTicketTable");
    }

    public void testEmptyUserTable() {
        ArrayList<User> users;
        User user;
        String result;

        System.out.println("Started DataAccessTest: testEmptyUserTable");

        dataAccess.deleteUser(new User(1, "Default User"));
        dataAccess.deleteUser(new User(2, "User2"));
        dataAccess.deleteUser(new User(3, "User3"));
        dataAccess.deleteUser(new User(4, "NoTickets"));

        users = new ArrayList<User>();
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(0, users.size());

        users.clear();
        user = new User(5, "Bob");
        result = dataAccess.insertUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(1, users.size());
        assertTrue(users.contains(user));
        user = users.get(0);
        assertEquals(5, user.getUserID());
        assertEquals("Bob", user.getUsername());

        users.clear();
        user = new User(5, "Greg");
        result = dataAccess.updateUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(1, users.size());
        assertTrue(users.contains(user));
        user = users.get(0);
        assertEquals(5, user.getUserID());
        assertEquals("Greg", user.getUsername());

        users.clear();
        user = new User(5, "Greg");
        result = dataAccess.deleteUser(user);
        assertNull(result);
        result = dataAccess.getAllUsers(users);
        assertNull(result);
        assertEquals(0, users.size());
        assertFalse(users.contains(user));

        result = dataAccess.deleteUser(user);
        assertNotNull(result);

        System.out.println("Finished DataAccessTest: testEmptyUserTable");
    }
}

