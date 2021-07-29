package comp3350.movieknight.tests.objects;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ObjectTests {
    public static TestSuite suite;

    public static Test suite() {
        suite = new TestSuite("Object tests");
        suite.addTestSuite(MovieTest.class);
        suite.addTestSuite(ShowingTest.class);
        suite.addTestSuite(TheatreTest.class);
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite(UserTest.class);
        return suite;
    }
}
