package comp3350.movieknight.persistence;

import java.sql.SQLWarning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class DataAccessObject implements DataAccess {

    private Statement st1, st2, st3, st4, st5;
    private Connection c1;
    private ResultSet rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10;

    private String dbName;
    private String dbType;

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
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath;
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();
            st2 = c1.createStatement();
            st3 = c1.createStatement();
            st4 = c1.createStatement();
            st5 = c1.createStatement();
        } catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("Opened " +dbType +" database " +dbPath);
    }

    @Override
    public void close() {
        try
        {
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
        Movie movie;
        int movieID, runtime;
        String description, title, poster;
        long lastShowDate;
        description = EOF;
        title = EOF;

        result = null;
        try {
            cmdString = "Select * from Movies";
            rs2 = st1.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs2.next())
            {
                movieID = rs2.getInt("MovieID");
                description = rs2.getString("Description");
                title = rs2.getString("Title");
                poster = rs2.getString("Poster");
                runtime = rs2.getInt("Runtime");
                lastShowDate = rs2.getLong("LastShowDate");

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(lastShowDate);

                movie = new Movie(movieID, description, title, poster, runtime, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
                movieResult.add(movie);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String insertMovie(Movie movie) {
        String values;

        result = null;
        try {
            values = movie.getMovieID() +
                    ", '" + movie.getDescription() +
                    "', '" + movie.getTitle() +
                    "', '" + movie.getPoster() +
                    "', " + movie.getRuntime() +
                    ", " + movie.getLastShowDate().getTimeInMillis();

            cmdString = "Insert into Movies " + " Values(" + values +")";
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String updateMovie(Movie movie) {
        String values;
        String where;

        result = null;
        try {
            values = "Description='" + movie.getDescription()
                    + "', Title='" + movie.getTitle()
                    + "', Poster='" + movie.getPoster()
                    + "', Runtime=" + movie.getRuntime()
                    + ", LastShowDate=" + movie.getLastShowDate().getTimeInMillis();
            where = "where MovieID=" + movie.getMovieID();

            cmdString = "Update Movies " + " Set " +values+ " "+where;
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String deleteMovie(Movie movie) {
        result = null;

        try {
            cmdString = "Delete from Movies where MovieID="+movie.getMovieID();
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        } catch (Exception e){
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String getAllTheatres(List<Theatre> theatreResult) {
        Theatre theatre;
        int theatreID, numSeats;

        result = null;
        try {
            cmdString = "Select * from Theatres";
            rs3 = st2.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs3.next())
            {
                theatreID = rs3.getInt("TheatreID");
                numSeats = rs3.getInt("NumSeats");

                theatre = new Theatre(theatreID, numSeats);
                theatreResult.add(theatre);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public Theatre getTheatre(Theatre theatre) {
        int theatreID, numSeats;

        Theatre result = null;
        try {
            cmdString = "Select * from Theatres where TheatreID=" + theatre.getTheatreID();
            rs4 = st2.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs5.next())
            {
                theatreID = rs4.getInt("TheatreID");
                numSeats = rs4.getInt("NumSeats");

                result = new Theatre(theatreID, numSeats);
            }
        } catch (Exception e) {
            processSQLError(e);
        }

        return result;
    }

    @Override
    public String insertTheatre(Theatre theatre) {
        String values;

        result = null;
        try {
            values = theatre.getTheatreID() +
                    ", " + theatre.getNumSeats();

            cmdString = "Insert into Theatres " +" Values(" + values +")";
            updateCount = st2.executeUpdate(cmdString);
            result = checkWarning(st2, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String updateTheatre(Theatre theatre) {
        String values;
        String where;

        result = null;
        try {
            values = "NumSeats= " + theatre.getNumSeats();
            where = "where TheatreID=" + theatre.getTheatreID();

            cmdString = "Update Theatres " + " Set " +values+ " " + where;
            updateCount = st2.executeUpdate(cmdString);
            result = checkWarning(st2, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String deleteTheatre(Theatre theatre) {
        result = null;

        try {
            cmdString = "Delete from Theatres where TheatreID=" + theatre.getTheatreID();
            updateCount = st2.executeUpdate(cmdString);
            result = checkWarning(st2, updateCount);
        } catch (Exception e){
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String getAllShowings(List<Showing> showingResult) {
        Showing showing;
        int showingID, movieID, theatreID, seats;
        long showingDate;
        double showingTime;

        result = null;
        try {
            cmdString = "Select * from Showings";
            rs4 = st3.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs4.next())
            {
                showingID = rs4.getInt("ShowingID");
                movieID = rs4.getInt("MovieID");
                theatreID = rs4.getInt("TheatreID");
                showingDate = rs4.getLong("ShowingDate");
                showingTime = rs4.getDouble("ShowingTime");
                seats = rs4.getInt("Seats");

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(showingDate);
                int hour = (int) Math.floor(showingTime);
                int minute = (int) showingTime - hour;

                showing = new Showing(showingID, movieID, theatreID, seats, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE), hour, minute);
                showingResult.add(showing);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String getMovieShowings(List<Showing> showingResult, int newMovieID) {

        Showing showing;
        int showingID, movieID, theatreID, seats;
        long showingDate;
        double showingTime;

        try {
            cmdString = "Select * from Showings where MovieID=" + newMovieID;
            rs5 = st3.executeQuery(cmdString);

        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs5.next())
            {
                showingID = rs5.getInt("ShowingID");
                movieID = rs5.getInt("MovieID");
                theatreID = rs5.getInt("TheatreID");
                showingDate = rs5.getLong("ShowingDate");
                showingTime = rs5.getDouble("ShowingTime");
                seats = rs5.getInt("Seats");

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(showingDate);
                int hour = (int) Math.floor(showingTime);
                int minute = (int) showingTime - hour;

                showing = new Showing(showingID, movieID, theatreID, seats, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE), hour, minute);
                showingResult.add(showing);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String getTheatreShowings(List<Showing> showingResult, int newTheatreID) {
        Showing showing;
        int showingID, movieID, theatreID, seats;
        long showingDate;
        double showingTime;

        try {
            cmdString = "Select * from Showings where TheatreID=" + newTheatreID;
            rs6 = st3.executeQuery(cmdString);

        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs6.next())
            {
                showingID = rs6.getInt("ShowingID");
                movieID = rs6.getInt("MovieID");
                theatreID = rs6.getInt("TheatreID");
                showingDate = rs6.getLong("ShowingDate");
                showingTime = rs6.getDouble("ShowingTime");
                seats = rs6.getInt("Seats");

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(showingDate);
                int hour = (int) Math.floor(showingTime);
                int minute = (int) showingTime - hour;

                showing = new Showing(showingID, movieID, theatreID, seats, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE), hour, minute);
                showingResult.add(showing);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String insertShowing(Showing showing) {
        String values;

        result = null;
        try {
            values = showing.getShowingID()
                    + ", " + showing.getMovieID()
                    + ", " + showing.getTheatreID()
                    + ", " + showing.getShowingDate().getTimeInMillis()
                    + ", " + showing.getShowingTime()
                    + ", " + showing.getSeats();

            cmdString = "Insert into Showings " +" Values(" + values + ")";
            updateCount = st3.executeUpdate(cmdString);
            result = checkWarning(st3, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String updateShowing(Showing showing) {
        String values;
        String where;

        result = null;
        try {
            values = "MovieID=" + showing.getMovieID() + ", "
                    + "TheatreID=" + showing.getTheatreID() + ", "
                    + "ShowingDate=" + showing.getShowingDate().getTimeInMillis() + ", "
                    + "ShowingTime=" + showing.getShowingTime() + ", "
                    + "Seats=" + showing.getSeats();
            where = "where ShowingID=" + showing.getShowingID();

            cmdString = "Update Showings " + " Set " +values+ " "+where;
            updateCount = st3.executeUpdate(cmdString);
            result = checkWarning(st3, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String deleteShowing(Showing showing) {
        result = null;

        try {
            cmdString = "Delete from Showings where ShowingID="+ showing.getShowingID();
            updateCount = st3.executeUpdate(cmdString);
            result = checkWarning(st3, updateCount);
        } catch (Exception e){
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String getAllUsers(List<User> userResult) {
        User user;
        int userID;
        String username = EOF;

        result = null;
        try {
            cmdString = "Select * from Users";
            rs7 = st4.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs7.next())
            {
                userID = rs7.getInt("UserID");
                username = rs7.getString("Username");

                user = new User(userID, username);
                userResult.add(user);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String insertUser(User user) {
        String values;

        result = null;
        try {
            values =  user.getUserID() +
                    ", '" + user.getUsername() +
                    "'";

            cmdString = "Insert into Users " +" Values(" + values +")";
            updateCount = st4.executeUpdate(cmdString);
            result = checkWarning(st4, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        String values;
        String where;

        result = null;
        try {
            values = "Username= '" + user.getUsername() + "'";
            where = "where UserID=" + user.getUserID();

            cmdString = "Update Users " + " Set " +values+ " "+where;
            updateCount = st4.executeUpdate(cmdString);
            result = checkWarning(st4, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String deleteUser(User user) {
        result = null;

        try {
            cmdString = "Delete from Users where UserID="+user.getUserID();
            updateCount = st4.executeUpdate(cmdString);
            result = checkWarning(st4, updateCount);
        } catch (Exception e){
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String getAllTickets(List<Ticket> ticketResult) {
        Ticket ticket;
        int userID, showingID, seatNum;

        result = null;
        try {
            cmdString = "Select * from Tickets";
            rs8 = st5.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs8.next())
            {
                userID = rs8.getInt("UserID");
                showingID = rs8.getInt("ShowingID");
                seatNum = rs8.getInt("SeatNum");

                ticket = new Ticket(userID, showingID, seatNum);
                ticketResult.add(ticket);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String getShowingTickets(List<Ticket> ticketResult, int newShowingID) {
        Ticket ticket;
        int userID, showingID, seatNum;

        result = null;
        try {
            cmdString = "Select * from Tickets where ShowingID= " + newShowingID;
            rs9 = st5.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs9.next())
            {
                userID = rs9.getInt("UserID");
                showingID = rs9.getInt("ShowingID");
                seatNum = rs9.getInt("SeatNum");

                ticket = new Ticket(userID, showingID, seatNum);
                ticketResult.add(ticket);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String getUserTickets(List<Ticket> ticketResult, int newUserID) {
        Ticket ticket;
        int userID, showingID, seatNum;

        result = null;
        try {
            cmdString = "Select * from Tickets where UserID= " + newUserID;
            rs10 = st5.executeQuery(cmdString);
        } catch (Exception e) {
            processSQLError(e);
        }

        try {
            while (rs10.next())
            {
                userID = rs10.getInt("UserID");
                showingID = rs10.getInt("ShowingID");
                seatNum = rs10.getInt("SeatNum");

                ticket = new Ticket(userID, showingID, seatNum);
                ticketResult.add(ticket);
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }

        return result;
    }

    @Override
    public String insertTicket(Ticket ticket) {
        String values;

        result = null;
        try {
            values = ticket.getUserID() +
                    ", " + ticket.getShowingID() +
                    ", " + ticket.getSeatNum();

            cmdString = "Insert into Users " +" Values(" + values +")";
            updateCount = st5.executeUpdate(cmdString);
            result = checkWarning(st5, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String updateTicket(Ticket ticket) {
        String values;
        String where;

        result = null;
        try {
            values = "UserID=" + ticket.getUserID();
            where = "where ShowingID=" + ticket.getShowingID() +
                    "AND SeatNum=" + ticket.getSeatNum();

            cmdString = "Update Tickets " + " Set " +values+ " "+where;
            updateCount = st5.executeUpdate(cmdString);
            result = checkWarning(st5, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    @Override
    public String deleteTicket(Ticket ticket) {
        result = null;

        try {
            cmdString = "Delete from Tickets where ShowingID="+ ticket.getShowingID() + " AND SeatNum=" + ticket.getSeatNum();
            updateCount = st5.executeUpdate(cmdString);
            result = checkWarning(st5, updateCount);
        } catch (Exception e){
            result = processSQLError(e);
        }
        return result;
    }

    public String checkWarning(Statement st, int updateCount)
    {
        String result;

        result = null;
        try {
            SQLWarning warning = st.getWarnings();
            if (warning != null) {
                result = warning.getMessage();
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }
        if (updateCount != 1) {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    public String processSQLError(Exception e)
    {
        String result = "*** SQL Error: " + e.getMessage();
        e.printStackTrace();

        return result;
    }
}
