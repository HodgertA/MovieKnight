package comp3350.movieknight.tests.integration;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.business.AccessMovies;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.business.AccessTheatre;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.business.AccessUser;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class BusinessPersistenceSeamTest extends TestCase {
	public BusinessPersistenceSeamTest(String arg0)
	{
		super(arg0);
	}

	public void testAccessMovies() {
		Services.closeDataAccess();

		System.out.println("\nStarting Integration test of AccessMovies to persistence");

		Services.createDataAccess(Main.dbName);

		AccessMovies accessMovies = new AccessMovies();

		Movie movie1 = new Movie(1, "Description for The Bee Movie", "The Bee Movie", "the_bee_movie", 120, 2021, 6, 8);
		Movie movie2 = new Movie(2, "Description for Finding Nemo", "Finding Nemo", "finding_nemo", 120, 2022, 6, 9);
		Movie movie3 = new Movie(3, "Description for Monsters Inc.", "Monsters Inc.", "monsters_inc", 120, 2022, 6, 7);
		Movie movie4 = new Movie(4, "Description for Ice Age", "Ice Age", "ice_age", 120, 2021, 7, 26);
		Movie movie5 = new Movie(5, "Description for Shrek", "Shrek", "shrek", 120, 2021, 8,26);
		Movie movie6 = new Movie(6, "Description for Wall-E", "Wall-E", "", 120, 2021, 10, 26);
		Movie movie7 = new Movie(5, "When Shrek and Fiona return from their honeymoon, her parents, the rulers of Far Far Away, invite them over.", "Shrek 2", "shrek", 120, 2021, 7, 26);

		ArrayList<Movie> movies = new ArrayList<Movie>();
		accessMovies.getMoviesInTheatres(movies);
		assertEquals(4, movies.size());
		assertFalse(movies.contains(movie1));
		assertTrue(movies.contains(movie2));
		assertTrue(movies.contains(movie3));
		assertTrue(movies.contains(movie4));
		assertTrue(movies.contains(movie5));

		assertEquals(movie1, accessMovies.getMovie(1));
		assertEquals(movie2, accessMovies.getMovie(2));
		assertEquals(movie3, accessMovies.getMovie(3));
		assertEquals(movie4, accessMovies.getMovie(4));
		assertEquals(movie5, accessMovies.getMovie(5));

		assertNull(accessMovies.getMovie(6));
		accessMovies.insertMovie(movie6);
		assertEquals(movie6, accessMovies.getMovie(6));
		accessMovies.deleteMovie(movie6);
		assertNull(accessMovies.getMovie(6));

		assertEquals(5, accessMovies.getMovie(5).getMovieID());
		assertEquals("Description for Shrek", accessMovies.getMovie(5).getDescription());
		assertEquals("Shrek", accessMovies.getMovie(5).getTitle());
		accessMovies.updateMovie(movie7);
		assertEquals(5, accessMovies.getMovie(5).getMovieID());
		assertEquals("When Shrek and Fiona return from their honeymoon, her parents, the rulers of Far Far Away, invite them over.", accessMovies.getMovie(5).getDescription());
		assertEquals("Shrek 2", accessMovies.getMovie(5).getTitle());
		accessMovies.updateMovie(movie5);

		Services.closeDataAccess();

		System.out.println("Finished Integration test of AccessMovies to persistence");
	}

	public void testAccessTheatre() {

		Services.closeDataAccess();

		System.out.println("\nStarting Integration test of AccessTheatre to persistence");

		Services.createDataAccess(Main.dbName);

		AccessTheatre accessTheatre = new AccessTheatre();

		Theatre theatre1 = new Theatre(1, 24);
		Theatre theatre2 = new Theatre(1, 200);
		Theatre theatre3 = new Theatre(999, 200);

		assertEquals(theatre1, accessTheatre.getTheatre(1));
		assertEquals(24, accessTheatre.getTheatre(1).getNumSeats());
		accessTheatre.updateTheatre(theatre2);
		assertEquals(200, accessTheatre.getTheatre(1).getNumSeats());
		accessTheatre.updateTheatre(theatre1);

		assertNull(accessTheatre.getTheatre(999));
		accessTheatre.insertTheatre(theatre3);
		assertEquals(theatre3, accessTheatre.getTheatre(999));
		accessTheatre.deleteTheatre(theatre3);
		assertNull(accessTheatre.getTheatre(999));

		Services.closeDataAccess();

		System.out.println("Finished Integration test of AccessTheatre to persistence");
	}

	public void testAccessShowing() {

		Services.closeDataAccess();

		System.out.println("\nStarting Integration test of AccessShowing to persistence");

		Services.createDataAccess(Main.dbName);

		Calendar today = Calendar.getInstance();
		AccessShowing accessShowing = new AccessShowing();
		ArrayList<Showing> showings = new ArrayList<Showing>();

		assertNull(accessShowing.getShowing(1000));

		Showing showing1 = new Showing(1000,1,1, 4000, today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),8,10);
		Showing showing2 = new Showing(1000,1,1, 4000, today.get(Calendar.YEAR)-1,today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),8,10);

		accessShowing.insertShowing(showing1);

		assertEquals(showing1, accessShowing.getShowing(1000));

		accessShowing.getShowingForMovieByDate(showings, 1, today);
		assertTrue(showings.contains(showing1));

		showings.clear();
		accessShowing.updateShowing(showing2);
		accessShowing.getShowingForMovieByDate(showings, 1, today);
		assertFalse(showings.contains(showing1));

		accessShowing.deleteShowing(showing1);
		assertNull(accessShowing.getShowing(1000));

		Services.closeDataAccess();

		System.out.println("Finished Integration test of AccessShowing to persistence");
	}


	public void testAccessTickets() {
		Services.closeDataAccess();

		System.out.println("\nStarting Integration test of AccessTickets to persistence");

		Services.createDataAccess(Main.dbName);

		AccessTickets accessTickets = new AccessTickets();

		boolean[] result = accessTickets.compileSeatAvailability(1,24);
		boolean[] expectedResult = { false,false,false,false,true,
				true,true,true,true,true,
				true,true,true,true,true,
				true,true,true,true,true,
				true,true,true,true};
		assertTrue(Arrays.equals(expectedResult, result));

		Ticket ticket1 = new Ticket(1, 1, 0);
		Ticket ticket2 = new Ticket(1, 1, 3);
		Ticket ticket3 = new Ticket(1, 2, 6);
		Ticket ticket4 = new Ticket(1, 3, 9);
		Ticket ticket5 = new Ticket(1, 5, 12);
		Ticket ticket6 = new Ticket(1, 7, 15);
		Ticket ticket7 = new Ticket(1, 10, 18);
		Ticket ticket8 = new Ticket(1, 12, 4);

		Ticket ticket9 = new Ticket(1, 1, 99);
		Ticket ticket10 = new Ticket(2, 2, 6);

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		accessTickets.getUserTickets(tickets,1);
		assertEquals(8,tickets.size());
		assertTrue(tickets.contains(ticket1));
		assertTrue(tickets.contains(ticket2));
		assertTrue(tickets.contains(ticket3));
		assertTrue(tickets.contains(ticket4));
		assertTrue(tickets.contains(ticket5));
		assertTrue(tickets.contains(ticket6));
		assertTrue(tickets.contains(ticket7));
		assertTrue(tickets.contains(ticket8));
		assertFalse(tickets.contains(ticket9));

		accessTickets.insertTicket(ticket9);
		accessTickets.updateTicket(ticket10);

		tickets.clear();
		accessTickets.getUserTickets(tickets,1);
		assertEquals(8,tickets.size());
		assertFalse(tickets.contains(ticket3));
		assertTrue(tickets.contains(ticket9));

		tickets.clear();
		accessTickets.getUserTickets(tickets,2);
		assertTrue(tickets.contains(ticket10));
		accessTickets.updateTicket(ticket3);

		tickets.clear();
		accessTickets.deleteTicket(ticket9);
		accessTickets.getUserTickets(tickets,1);
		assertFalse(tickets.contains(ticket9));


		Services.closeDataAccess();

		System.out.println("Finished Integration test of AccessTickets to persistence");
	}


	public void testAccessUser() {

		Services.closeDataAccess();

		System.out.println("\nStarting Integration test of AccessUser to persistence");

		Services.createDataAccess(Main.dbName);

		AccessUser accessUser = new AccessUser();

		User user1 = new User(1, "Default User");
		User user2 = new User(2, "User2");
		User user3 = new User(3, "User3");
		User user4 = new User(5, "Another");

		ArrayList<User> users = new ArrayList<User>();
		accessUser.getAllUsers(users);

		assertEquals(4, users.size());
		assertTrue(users.contains(user1));
		assertTrue(users.contains(user2));
		assertTrue(users.contains(user3));
		assertFalse(users.contains(user4));

		accessUser.insertUser(user4);
		users.clear();
		accessUser.getAllUsers(users);
		assertEquals(5, users.size());
		assertTrue(users.contains(user4));

		User newUser1 = new User(1, "New Username");
		User newUser2 = new User(2, "New Username");
		User newUser3 = new User(3, "New Username");

		accessUser.updateUser(newUser1);
		accessUser.updateUser(newUser2);
		accessUser.updateUser(newUser3);
		accessUser.deleteUser(user4);

		users.clear();
		accessUser.getAllUsers(users);
		assertFalse(users.contains(user4));
		assertEquals(4, users.size());
		assertTrue(users.contains(user1));
		assertEquals("New Username", users.get(0).getUsername());
		assertTrue(users.contains(user2));
		assertEquals("New Username", users.get(1).getUsername());
		assertTrue(users.contains(user3));
		assertEquals("New Username", users.get(2).getUsername());

		accessUser.updateUser(user1);
		accessUser.updateUser(user2);
		accessUser.updateUser(user3);

		Services.closeDataAccess();

		System.out.println("Finished Integration test of AccessUser to persistence");
	}
}