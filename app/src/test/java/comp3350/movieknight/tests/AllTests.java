package comp3350.movieknight.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp3350.movieknight.tests.business.AccessMoviesTest;
import comp3350.movieknight.tests.business.AccessTheatreTest;
import comp3350.movieknight.tests.business.FilterMoviesTest;
import comp3350.movieknight.tests.business.FilterShowingsTest;
import comp3350.movieknight.tests.business.FindAvailableSeatsTest;
import comp3350.movieknight.tests.objects.*;
import comp3350.movieknight.tests.persistence.DataAccessTest;

public class AllTests
{
	public static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        testPersistence();
        return suite;
    }

    private static void testObjects()
    {
        suite.addTestSuite(MovieTest.class);
        suite.addTestSuite(ShowingTest.class);
        suite.addTestSuite(TheatreTest.class);
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite(UserTest.class);
    }

    private static void testBusiness()
    {
        suite.addTestSuite(FilterShowingsTest.class);
        suite.addTestSuite(FilterMoviesTest.class);
        suite.addTestSuite(FindAvailableSeatsTest.class);
        suite.addTestSuite(AccessMoviesTest.class);
        suite.addTestSuite(AccessTheatreTest.class);
    }

    private static void testPersistence()
    {
        suite.addTestSuite(DataAccessTest.class);
    }
}
