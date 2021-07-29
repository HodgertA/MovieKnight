package comp3350.movieknight.tests;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import comp3350.movieknight.tests.acceptance.SendTicketAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ProfileAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ViewTicketAcceptanceTest;
import comp3350.movieknight.tests.acceptance.ViewMoviesAcceptanceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({viewMoviesAcceptanceTest.class, ViewTicketAcceptanceTest.class, ProfileAcceptanceTest.class, SendTicketAcceptanceTest.class, ReserveSeatsAcceptanceTest.class})

public class RunAcceptanceTests
{
    public RunAcceptanceTests()
    {
        System.out.println("Sample Acceptance tests");
    }
}
