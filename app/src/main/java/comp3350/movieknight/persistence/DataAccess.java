package comp3350.movieknight.persistence;

import java.util.List;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public interface DataAccess {
    void open(String string);

    void close();

    String getAllMovies(List<Movie> movieResult);

    Movie getMovie(Movie movie);

    String insertMovie(Movie movie);

    String updateMovie(Movie movie);

    String deleteMovie(Movie movie);

    String getAllTheatres(List<Theatre> theatreResult);

    Theatre getTheatre(Theatre theatre);

    String insertTheatre(Theatre theatre);

    String updateTheatre(Theatre theatre);

    String deleteTheatre(Theatre theatre);

    String getAllShowings(List<Showing> showingResult);

    Showing getShowing(Showing showing);

    String getMovieShowings(List<Showing> showingList, int movieId);

    String getTheatreShowings(List<Showing> showingList, int theatreId);

    String insertShowing(Showing showing);

    String updateShowing(Showing showing);

    String deleteShowing(Showing showing);

    String getAllUsers(List<User> userResult);

    String insertUser(User user);

    String updateUser(User user);

    String deleteUser(User user);

    String getAllTickets(List<Ticket> ticketResult);

    String getShowingTickets(List<Ticket> ticketResult, int showingID);

    String getUserTickets(List<Ticket> ticketResult, int userID);

    String insertTicket(Ticket ticket);

    String updateTicket(Ticket ticket);

    String deleteTicket(Ticket ticket);
}
