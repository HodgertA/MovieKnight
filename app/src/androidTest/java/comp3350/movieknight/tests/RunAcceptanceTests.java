package comp3350.movieknight.tests;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import comp3350.movieknight.tests.acceptance.PurchaseTicketsAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ReserveSeatsAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ViewTicketAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ViewMoviesAcceptanceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ViewMoviesAcceptanceTest.class, ViewTicketAcceptanceTest.class, ReserveSeatsAcceptanceTest.class, PurchaseTicketsAcceptanceTest.class})
public class RunAcceptanceTests
{
    public RunAcceptanceTests()
    {
        System.out.println("Sample Acceptance tests");
    }
}
