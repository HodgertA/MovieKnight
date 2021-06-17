package comp3350.movieknight.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp3350.movieknight.tests.business.FilterMoviesTest;
import comp3350.movieknight.tests.business.FilterShowingsTest;
import comp3350.movieknight.tests.business.FindAvailableSeatsTest;
import comp3350.movieknight.tests.objects.*;

public class AllTests
{
	public static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
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
    }
}
