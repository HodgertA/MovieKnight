package comp3350.movieknight.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class DatabaseStub {

    private String dbName;
    private String dbType = "stub";

    private ArrayList<Movie> movies;
    private ArrayList<Theatre> theatres;
    private ArrayList<Showing> showings;
    private ArrayList<Ticket> tickets;
    private ArrayList<User> users;

    public DatabaseStub(String dbName) {this.dbName = dbName; }

    public DatabaseStub() {this.dbName = "DB"; }

    public void open(String dbName)
    {
        Movie movie;
        Theatre theatre;
        Showing showing;
        User user;
        //not starting off with any tickets generated

        movies = new ArrayList<Movie>();
        movie = new Movie(1, "Description for The Bee Movie", "The Bee Movie", R.drawable.the_bee_movie, 120, 2021, 6,8);
        movies.add(movie);
        movie = new Movie(2, "Description for Finding Nemo", "Finding Nemo", R.drawable.finding_nemo, 120, 2022, 6,9);
        movies.add(movie);
        movie = new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", R.drawable.monsters_inc, 120, 2022, 6,7);
        movies.add(movie);
        movie = new Movie(4, "Description for Ice Age", "Ice Age", R.drawable.ice_age, 120, 2021, 7,26);
        movies.add(movie);
        movie = new Movie(5, "Description for Shrek", "Shrek", R.drawable.shrek, 120, 2021, 7,26);
        movies.add(movie);

        theatres = new ArrayList<Theatre>();
        theatre = new Theatre(1, 12);
        theatres.add(theatre);

        showings = new ArrayList<Showing>();
        showing = new Showing(1, 1, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(), 2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(2, 1, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(3, 2, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(5, 3, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(6, 3, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(7, 4, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);
        showing = new Showing(9, 5, 1, getTheatre(new Theatre(1, 1)).getNumberOfSeatsInRoom(),2021, 1, 3, 8, 0);
        showings.add(showing);

        users = new ArrayList<User>();
        user = new User(1, "Default User");
        users.add(user);

        tickets = new ArrayList<Ticket>();
    }

    public void close() { System.out.println("Closed " + dbType + " database " + dbName); }

    public String getAllMovies(List<Movie> movieResult)
    {
        movieResult.addAll(movies);
        return null;
    }

    public String insertMovie(Movie movie)
    {
        if (!movies.contains(movie)) {
            movies.add(movie);
        } else {
            System.out.println("Duplicate Movie");
        }
        return null;
    }

    public String updateMovie(Movie movie)
    {
        int index;

        index = movies.indexOf(movie);
        if (index >= 0)
        {
            movies.set(index, movie);
        }
        return null;
    }

    public String deleteMovie(Movie movie)
    {
        int index;

        index = movies.indexOf(movie);
        if (index >= 0)
        {
            movies.remove(index);
        }
        return null;
    }

    public String getAllTheatres(List<Theatre> theatreResult)
    {
        theatreResult.addAll(theatres);
        return null;
    }

    public Theatre getTheatre(Theatre theatre) {
        Theatre result = null;
        int index = theatres.indexOf(theatre);
        if (index >= 0)
        {
            result = theatres.get(index);
        }
        return result;
    }

    public String insertTheatre(Theatre theatre)
    {
        if (!theatres.contains(theatre)) {
            theatres.add(theatre);
        } else {
            System.out.println("Duplicate Theatre");
        }
        return null;
    }

    public String updateTheatre(Theatre theatre)
    {
        int index;

        index = theatres.indexOf(theatre);
        if (index >= 0)
        {
            theatres.set(index, theatre);
        }
        return null;
    }

    public String deleteTheatre(Theatre theatre)
    {
        int index;

        index = theatres.indexOf(theatre);
        if (index >= 0)
        {
            theatres.remove(index);
        }
        return null;
    }

    public String getAllShowings(List<Showing> showingResult)
    {
        showingResult.addAll(showings);
        return null;
    }

    public ArrayList<Showing> getMovieShowings(Showing showing)
    {
        ArrayList<Showing> result = new ArrayList<Showing>();
        Showing curr;

        for (int counter = 0; counter < showings.size(); counter++)
        {
            curr = showings.get(counter);
            if (curr.getMovieID() == showing.getMovieID())
            {
                result.add(curr);
            }
        }
        return result;
    }

    public ArrayList<Showing> getTheatreShowings(Showing showing)
    {
        ArrayList<Showing> result = new ArrayList<Showing>();
        Showing curr;

        for (int counter = 0; counter < showings.size(); counter++)
        {
            curr = showings.get(counter);
            if (curr.getTheatreID() == showing.getTheatreID())
            {
                result.add(curr);
            }
        }
        return result;
    }

    public ArrayList<Showing> getDateShowings(Showing showing)
    {
        ArrayList<Showing> result = new ArrayList<Showing>();
        Showing curr;

        for (int counter = 0; counter < showings.size(); counter++)
        {
            curr = showings.get(counter);
            if (curr.getShowingDate().equals(showing.getShowingDate()))
            {
                result.add(curr);
            }
        }
        return result;
    }

    public String insertShowing(Showing showing)
    {
        if (!showings.contains(showing)) {
            showings.add(showing);
        } else {
            System.out.println("Duplicate Showing");
        }
        return null;
    }

    public String updateShowing(Showing showing)
    {
        int index;

        index = showings.indexOf(showing);
        if (index >= 0)
        {
            showings.set(index, showing);
        }
        return null;
    }

    public String deleteShowing(Showing showing)
    {
        int index;

        index = showings.indexOf(showing);
        if (index >= 0)
        {
            showings.remove(index);
        }
        return null;
    }

    public String getAllUsers(List<User> userResult)
    {
        userResult.addAll(users);
        return null;
    }

    public String insertUser(User user)
    {
        if (!users.contains(user)) {
            users.add(user);
        } else {
            System.out.println("Duplicate User");
        }
        return null;
    }

    public String updateUser(User user)
    {
        int index;

        index = users.indexOf(user);
        if (index >= 0)
        {
            users.set(index, user);
        }
        return null;
    }

    public String deleteUser(User user)
    {
        int index;

        index = users.indexOf(user);
        if (index >= 0)
        {
            users.remove(index);
        }
        return null;
    }

    public String getAllTickets(List<Ticket> ticketResult)
    {
        ticketResult.addAll(tickets);
        return null;
    }

    public ArrayList<Ticket> getShowingTickets(Ticket ticket)
    {
        ArrayList<Ticket> result = new ArrayList<Ticket>();
        Ticket curr;

        for (int counter = 0; counter < showings.size(); counter++)
        {
            curr = tickets.get(counter);
            if (curr.getShowingID() == ticket.getShowingID())
            {
                result.add(curr);
            }
        }
        return result;
    }

    public ArrayList<Ticket> getUserTickets(Ticket ticket)
    {
        ArrayList<Ticket> result = new ArrayList<Ticket>();
        Ticket curr;

        for (int counter = 0; counter < showings.size(); counter++)
        {
            curr = tickets.get(counter);
            if (curr.getUserID() == ticket.getUserID())
            {
                result.add(curr);
            }
        }
        return result;
    }

    public String insertTicket(Ticket ticket)
    {
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
        } else {
            System.out.println("Duplicate Ticket");
        }
        return null;
    }

    public String updateTicket(Ticket ticket)
    {
        int index;

        index = tickets.indexOf(ticket);
        if (index >= 0)
        {
            tickets.set(index, ticket);
        }
        return null;
    }

    public String deleteTicket(Ticket ticket)
    {
        int index;

        index = tickets.indexOf(ticket);
        if (index >= 0)
        {
            tickets.remove(index);
        }
        return null;
    }
}
