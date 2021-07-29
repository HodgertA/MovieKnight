package comp3350.movieknight.tests.business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BusinessTests {
    public static TestSuite suite;

    public static Test suite() {
        suite = new TestSuite("Business tests");
        suite.addTestSuite(AccessMoviesTest.class);
        suite.addTestSuite(AccessShowingTest.class);
        suite.addTestSuite(AccessTicketsTest.class);
        suite.addTestSuite(AccessTheatreTest.class);
        suite.addTestSuite(FilterMoviesTest.class);
        suite.addTestSuite(FilterShowingsTest.class);
        suite.addTestSuite(FindAvailableSeatsTest.class);
        return suite;
    }
}
