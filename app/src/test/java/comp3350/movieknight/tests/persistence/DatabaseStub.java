package comp3350.movieknight.tests.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;
import comp3350.movieknight.persistence.DataAccess;

public class DatabaseStub implements DataAccess {

    private String dbName;
    private String dbType = "stub";

    private ArrayList<Movie> movies;
    private ArrayList<Theatre> theatres;
    private ArrayList<Showing> showings;
    private ArrayList<Ticket> tickets;
    private ArrayList<User> users;

    public DatabaseStub(String dbName) {this.dbName = dbName; }

    public DatabaseStub() {this.dbName = "DB"; }

    public void open(String dbName) {
        Movie movie;
        Theatre theatre;
        Showing showing;
        User user;
        Ticket ticket;

        movies = new ArrayList<Movie>();
        movie = new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6,8);
        movies.add(movie);
        movie = new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6,9);
        movies.add(movie);
        movie = new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6,7);
        movies.add(movie);
        movie = new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 8,26);
        movies.add(movie);
        movie = new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 8,26);
        movies.add(movie);

        theatres = new ArrayList<Theatre>();
        theatre = new Theatre(1, 24);
        theatres.add(theatre);

        Calendar day = Calendar.getInstance();

        showings = new ArrayList<Showing>();

        //day 1
        showing = new Showing(1, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(2, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(3, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(4, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(5, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(6, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(7, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(8, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(9, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(10, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(11, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(12, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 2
        day.add(Calendar.DATE, 1);
        showing = new Showing(13, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(14, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(15, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(16, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(17, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(18, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(19, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(20, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(21, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(22, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(23, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(24, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 3
        day.add(Calendar.DATE, 1);
        showing = new Showing(25, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(26, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(27, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(28, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(29, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(30, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(31, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(32, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(33, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(34, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(35, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(36, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 4
        day.add(Calendar.DATE, 1);
        showing = new Showing(37, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(38, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(39, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(40, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(41, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(42, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(43, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(44, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(45, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(46, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(47, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(48, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 5
        day.add(Calendar.DATE, 1);
        showing = new Showing(49, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(50, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(51, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(52, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(53, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(54, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(55, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(56, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(57, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(58, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(59, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(60, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 6
        day.add(Calendar.DATE, 1);
        showing = new Showing(61, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(62, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(63, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(64, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(65, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(66, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(67, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(68, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(69, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(70, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(71, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(72, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        //day 7
        day.add(Calendar.DATE, 1);
        showing = new Showing(73, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(), day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);
        showings.add(showing);
        showing = new Showing(74, 1, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(75, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55);
        showings.add(showing);
        showing = new Showing(76, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55);
        showings.add(showing);
        showing = new Showing(77, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55);
        showings.add(showing);
        showing = new Showing(78, 2, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55);
        showings.add(showing);
        showing = new Showing(79, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15);
        showings.add(showing);
        showing = new Showing(80, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35);
        showings.add(showing);
        showing = new Showing(81, 3, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25);
        showings.add(showing);
        showing = new Showing(82, 4, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35);
        showings.add(showing);
        showing = new Showing(83, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45);
        showings.add(showing);
        showing = new Showing(84, 5, 1, getTheatre(new Theatre(1, 1)).getNumSeats(),day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45);
        showings.add(showing);

        users = new ArrayList<User>();
        user = new User(1, "Default User");
        users.add(user);
        user = new User(2, "User2");
        users.add(user);
        user = new User(3, "User3");
        users.add(user);
        user = new User(4, "NoTickets");
        users.add(user);

        tickets = new ArrayList<Ticket>();
        ticket = new Ticket(1, 1, 0);
        tickets.add(ticket);
        ticket = new Ticket(2, 1, 1);
        tickets.add(ticket);
        ticket = new Ticket(3, 1, 2);
        tickets.add(ticket);
        ticket = new Ticket(1, 1, 3);
        tickets.add(ticket);
        ticket = new Ticket(2, 2,4);
        tickets.add(ticket);
        ticket = new Ticket(3, 2, 5);
        tickets.add(ticket);
        ticket = new Ticket(1, 2, 6);
        tickets.add(ticket);
        ticket = new Ticket(2, 2, 7);
        tickets.add(ticket);
        ticket = new Ticket(3, 3, 8);
        tickets.add(ticket);
        ticket = new Ticket(1, 3, 9);
        tickets.add(ticket);
        ticket = new Ticket(2, 3, 10);
        tickets.add(ticket);
        ticket = new Ticket(3, 4, 11);
        tickets.add(ticket);
        ticket = new Ticket(1, 5, 12);
        tickets.add(ticket);
        ticket = new Ticket(2, 6, 13);
        tickets.add(ticket);
        ticket = new Ticket(3, 6, 14);
        tickets.add(ticket);
        ticket = new Ticket(1, 7, 15);
        tickets.add(ticket);
        ticket = new Ticket(2, 8, 16);
        tickets.add(ticket);
        ticket = new Ticket(3, 9,17);
        tickets.add(ticket);
        ticket = new Ticket(1, 10, 18);
        tickets.add(ticket);
        ticket = new Ticket(2, 11, 19);
        tickets.add(ticket);
        ticket = new Ticket(3, 12, 1);
        tickets.add(ticket);
        ticket = new Ticket(1, 12, 4);
        tickets.add(ticket);
        ticket = new Ticket(2, 12,8);
        tickets.add(ticket);
        ticket = new Ticket(3, 12,5);
        tickets.add(ticket);
    }

    public void close() { System.out.println("Closed " + dbType + " database " + dbName); }

    @Override
    public String getAllMovies(List<Movie> movieResult) {
        movieResult.addAll(movies);
        return null;
    }

    @Override
    public Movie getMovie(Movie movie) {
        Movie result = null;

        int index = movies.indexOf(movie);
        if (index >= 0) {
            result = movies.get(index);
        }
        return result;
    }

    @Override
    public String insertMovie(Movie movie) {
        String result = null;
        if (!movies.contains(movie)) {
            movies.add(movie);
        } else {
            result = "Violation of unique constraint";
        }
        return result;
    }

    @Override
    public String updateMovie(Movie movie) {
        int index;
        String result = null;

        index = movies.indexOf(movie);
        if (index >= 0) {
            movies.set(index, movie);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String deleteMovie(Movie movie) {
        int index;
        String result = null;

        index = movies.indexOf(movie);
        if (index >= 0) {
            movies.remove(index);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String getAllTheatres(List<Theatre> theatreResult) {
        theatreResult.addAll(theatres);
        return null;
    }

    @Override
    public Theatre getTheatre(Theatre theatre) {
        Theatre result = null;

        int index = theatres.indexOf(theatre);
        if (index >= 0) {
            result = theatres.get(index);
        }
        return result;
    }

    @Override
    public String insertTheatre(Theatre theatre) {
        String result = null;
        if (!theatres.contains(theatre)) {
            theatres.add(theatre);
        } else {
            result = "Violation of unique constraint";
        }
        return result;
    }

    @Override
    public String updateTheatre(Theatre theatre) {
        int index;
        String result = null;

        index = theatres.indexOf(theatre);
        if (index >= 0) {
            theatres.set(index, theatre);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String deleteTheatre(Theatre theatre) {
        int index;
        String result = null;

        index = theatres.indexOf(theatre);
        if (index >= 0) {
            theatres.remove(index);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String getAllShowings(List<Showing> showingResult) {
        showingResult.addAll(showings);
        return null;
    }

    @Override
    public Showing getShowing(Showing showing) {
        Showing result=null;

        int index=showings.indexOf(showing);
        if(index>=0){
            result=showings.get(index);
        }
        return result;
    }

    @Override
    public String getMovieShowings(List<Showing> showingList, int movieId) {
        Showing curr;
        String result = null;
        if (movieId > 0) {
            for (int counter = 0; counter < showings.size(); counter++) {
                curr = showings.get(counter);
                if (curr.getMovieID() == movieId) {
                    showingList.add(curr);
                }
            }
        }

       return result;
    }

    @Override
    public String getTheatreShowings(List<Showing> showingList, int theatreId) {
        Showing curr;
        String result = null;

        if (theatreId > 0) {
            for (int counter = 0; counter < showings.size(); counter++) {
                curr = showings.get(counter);
                if (curr.getTheatreID() == theatreId) {
                    showingList.add(curr);
                }
            }
        }

        return result;
    }

    @Override
    public String insertShowing(Showing showing) {
        String result = null;
        if (!showings.contains(showing)) {
            showings.add(showing);
        } else {
            result = "Violation of unique constraint";
        }
        return result;
    }

    @Override
    public String updateShowing(Showing showing) {
        int index;
        String result = null;

        index = showings.indexOf(showing);
        if (index >= 0) {
            showings.set(index, showing);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String deleteShowing(Showing showing) {
        int index;
        String result = null;

        index = showings.indexOf(showing);
        if (index >= 0) {
            showings.remove(index);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String getAllUsers(List<User> userResult) {
        userResult.addAll(users);
        return null;
    }

    @Override
    public String insertUser(User user) {
        String result = null;
        if (!users.contains(user)) {
            users.add(user);
        } else {
            result = "Violation of unique constraint";
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        int index;
        String result = null;

        index = users.indexOf(user);
        if (index >= 0) {
            users.set(index, user);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String deleteUser(User user) {
        int index;
        String result = null;

        index = users.indexOf(user);
        if (index >= 0) {
            users.remove(index);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String getAllTickets(List<Ticket> ticketResult) {
        ticketResult.addAll(tickets);
        return null;
    }

    @Override
    public String getShowingTickets(List<Ticket> ticketList, int showingId) {
        Ticket curr;
        String result = null;

        if (showingId > 0) {
            for (int counter = 0; counter < tickets.size(); counter++) {
                curr = tickets.get(counter);
                if (curr.getShowingID() == showingId) {
                    ticketList.add(curr);
                }
            }
        }

        return result;
    }

    @Override
    public String getUserTickets(List<Ticket> ticketList, int userId) {
        Ticket curr;
        String result = null;

        if (userId > 0 ) {
            for (int counter = 0; counter < tickets.size(); counter++) {
                curr = tickets.get(counter);
                if (curr.getUserID() == userId) {
                    ticketList.add(curr);
                }
            }
        }

        return result;
    }

    @Override
    public String insertTicket(Ticket ticket) {
        String result = null;
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
        } else {
            result = "Violation of unique constraint";
        }
        return result;
    }

    @Override
    public String updateTicket(Ticket ticket) {
        int index;
        String result = null;

        index = tickets.indexOf(ticket);
        if (index >= 0) {
            tickets.set(index, ticket);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    @Override
    public String deleteTicket(Ticket ticket) {
        int index;
        String result = null;

        index = tickets.indexOf(ticket);
        if (index >= 0) {
            tickets.remove(index);
        } else {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }
}
