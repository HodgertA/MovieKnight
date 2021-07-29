package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.tests.persistence.DatabaseStub;

public class AccessShowingTest extends TestCase {
    public AccessShowingTest(String arg0) {
        super(arg0);
    }

    private static String dbName = Main.dbName;

    public void testGetShowingForMovieByDate() {
        System.out.println("\nStarting getShowingForMovieByDate tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessShowing accessShowing = new AccessShowing();
        ArrayList<Showing> showings = new ArrayList<>();

        Calendar day = Calendar.getInstance();

        for (int i = 0; i < 7; i++) {
            accessShowing.getShowingForMovieByDate(showings,1,day);
            assertEquals(2,showings.size());
            assertTrue(showings.contains(new Showing(1+i*12,1,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15)));
            assertTrue(showings.contains(new Showing(2+i*12,1,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35)));
            showings.clear();

            accessShowing.getShowingForMovieByDate(showings,2,day);
            assertEquals(4,showings.size());
            assertTrue(showings.contains(new Showing(3+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE),9, 55 )));
            assertTrue(showings.contains(new Showing(4+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55)));
            assertTrue(showings.contains(new Showing(5+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55)));
            assertTrue(showings.contains(new Showing(6+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE),12, 55 )));
            showings.clear();

            accessShowing.getShowingForMovieByDate(showings,3,day);
            assertEquals(3,showings.size());
            assertTrue(showings.contains(new Showing(7+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15)));
            assertTrue(showings.contains(new Showing(8+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE),10, 3 )));
            assertTrue(showings.contains(new Showing(9+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25)));
            showings.clear();

            accessShowing.getShowingForMovieByDate(showings,4,day);
            assertEquals(1,showings.size());
            assertTrue(showings.contains(new Showing(10+i*12,4,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35)));
            showings.clear();

            accessShowing.getShowingForMovieByDate(showings,5,day);
            assertEquals(2,showings.size());
            assertTrue(showings.contains(new Showing(11+i*12,5,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE),8, 45)));
            assertTrue(showings.contains(new Showing(12+i*12,5,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45)));
            showings.clear();

            day.add(Calendar.DATE, 1);
        }

        Services.closeDataAccess();
        System.out.println("\nFinished getShowingForMovieByDate tests (using stub)");

    }

    public void testGetShowing() {
        System.out.println("\nStarting getShowing tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessShowing accessShowing = new AccessShowing();
        Showing showing;

        Calendar day = Calendar.getInstance();

        for(int i = 0; i < 7; i++) {
            showing = accessShowing.getShowing(1+i*12);
            assertEquals(showing,new Showing(1+i*12,1,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15));

            showing = accessShowing.getShowing(2+i*12);
            assertEquals(showing,new Showing(2+i*12,1,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));

            showing = accessShowing.getShowing(3+i*12);
            assertEquals(showing,new Showing(3+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 55));

            showing = accessShowing.getShowing(4+i*12);
            assertEquals(showing,new Showing(4+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 55));

            showing = accessShowing.getShowing(5+i*12);
            assertEquals(showing,new Showing(5+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 55));

            showing = accessShowing.getShowing(6+i*12);
            assertEquals(showing,new Showing(6+i*12,2,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 12, 55));

            showing = accessShowing.getShowing(7+i*12);
            assertEquals(showing,new Showing(7+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 7, 15));

            showing = accessShowing.getShowing(8+i*12);
            assertEquals(showing,new Showing(8+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 10, 35));

            showing = accessShowing.getShowing(9+i*12);
            assertEquals(showing,new Showing(9+i*12,3,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 15, 25));

            showing = accessShowing.getShowing(10+i*12);
            assertEquals(showing,new Showing(10+i*12,4,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 20, 35));

            showing = accessShowing.getShowing(11+i*12);
            assertEquals(showing,new Showing(11+i*12,5,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 45));

            showing = accessShowing.getShowing(12+i*12);
            assertEquals(showing,new Showing(12+i*12,5,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 9, 45));

            day.add(Calendar.DATE, 1);
        }

        Services.closeDataAccess();
        System.out.println("\nFinished getShowing tests (using stub)");
    }

    public void testInsertShowing() {
        System.out.println("\nStarting insertShowing tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessShowing accessShowing = new AccessShowing();

        assertNull(accessShowing.getShowing(100));

        Showing newShowing = new Showing(100);
        accessShowing.insertShowing(newShowing);

        assertNotNull(accessShowing.getShowing(100));

        Services.closeDataAccess();
        System.out.println("\nFinished insertShowing tests (using stub)");
    }

    public void testUpdateShowing() {
        System.out.println("\nStarting updateShowing tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessShowing accessShowing = new AccessShowing();

        Calendar day = Calendar.getInstance();

        Showing oldShowing = new Showing(1,1,1,24,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 8, 15);

        assertEquals(oldShowing.getMovieID(),accessShowing.getShowing(1).getMovieID());
        assertEquals(oldShowing.getSeats(),accessShowing.getShowing(1).getSeats());
        assertEquals(oldShowing.getShowingID(),accessShowing.getShowing(1).getShowingID());
        assertEquals(oldShowing.getTheatreID(),accessShowing.getShowing(1).getTheatreID());
        assertEquals(oldShowing.getShowingHour(),accessShowing.getShowing(1).getShowingHour());
        assertEquals(oldShowing.getShowingMinute(),accessShowing.getShowing(1).getShowingMinute());

        Showing newShowing = new Showing(1,2,2,30,day.get(Calendar.YEAR),day.get(Calendar.MONTH)+1,day.get(Calendar.DATE), 11, 20);
        accessShowing.updateShowing(newShowing);

        assertEquals(newShowing.getMovieID(),accessShowing.getShowing(1).getMovieID());
        assertEquals(newShowing.getSeats(),accessShowing.getShowing(1).getSeats());
        assertEquals(newShowing.getShowingID(),accessShowing.getShowing(1).getShowingID());
        assertEquals(newShowing.getTheatreID(),accessShowing.getShowing(1).getTheatreID());
        assertEquals(newShowing.getShowingHour(),accessShowing.getShowing(1).getShowingHour());
        assertEquals(newShowing.getShowingMinute(),accessShowing.getShowing(1).getShowingMinute());

        Services.closeDataAccess();
        System.out.println("\nFinished updateShowing tests (using stub)");
    }

    public void testDeleteShowing() {
        System.out.println("\nStarting deleteShowing tests (using stub)");
        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessShowing accessShowing = new AccessShowing();
        Showing showing;
        for(int i = 1; i < 85; i++) {
            showing = accessShowing.getShowing(i);
            assertNotNull(showing);
            accessShowing.deleteShowing(showing);
            assertNull(accessShowing.getShowing(i));
        }
        Services.closeDataAccess();
        System.out.println("\nFinished deleteShowing tests (using stub)");
    }

}