package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.business.AccessTheatre;
import comp3350.movieknight.objects.Theatre;
import comp3350.movieknight.tests.persistence.DatabaseStub;

public class AccessTheatreTest extends TestCase {
    private static String dbName = Main.dbName;

    public AccessTheatreTest(String arg0) {
        super(arg0);
    }

    public void testGetTheatre() {
        System.out.println("\nStarting getTheatre tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTheatre accessTheatre = new AccessTheatre();
        Theatre theatre = new Theatre(1, 24);

        assertEquals(theatre, accessTheatre.getTheatre(1));

        Services.closeDataAccess();

        System.out.println("\nFinished getTheatre tests (using stub)");
    }

    public void testDeleteTheatre() {
        System.out.println("\nStarting deleteTheatre tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTheatre accessTheatre = new AccessTheatre();

        Theatre theatre = new Theatre(1, 24);
        assertEquals(theatre, accessTheatre.getTheatre(1));

        accessTheatre.deleteTheatre(theatre);
        assertNull(accessTheatre.getTheatre(1));

        Services.closeDataAccess();
        System.out.println("\nFinished deleteTheatre tests (using stub)");
    }

    public void testInsertTheatre() {
        System.out.println("\nStarting insertTheatre tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTheatre accessTheatre = new AccessTheatre();

        Theatre theatre = new Theatre(2, 24);
        assertNull(accessTheatre.getTheatre(2));

        accessTheatre.insertTheatre(theatre);
        assertEquals(theatre, accessTheatre.getTheatre(2));

        Services.closeDataAccess();
        System.out.println("\nFinished insertTheatre tests (using stub)");
    }

    public void testUpdateTheatre() {
        System.out.println("\nStarting updateTheatre tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessTheatre accessTheatre = new AccessTheatre();

        Theatre theatre = new Theatre(1, 200);
        assertEquals(24, accessTheatre.getTheatre(1).getNumSeats());

        accessTheatre.updateTheatre(theatre);
        assertEquals(200, accessTheatre.getTheatre(1).getNumSeats());

        Services.closeDataAccess();
        System.out.println("\nFinished updateTheatre tests (using stub)");
    }
}
