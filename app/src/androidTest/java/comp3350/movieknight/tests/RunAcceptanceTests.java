package comp3350.movieknight.tests;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import comp3350.movieknight.tests.acceptance.ViewMoviesAcceptanceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ViewMoviesAcceptanceTest.class})
public class RunAcceptanceTests
{
    public RunAcceptanceTests()
    {
        System.out.println("Sample Acceptance tests");
    }
}
