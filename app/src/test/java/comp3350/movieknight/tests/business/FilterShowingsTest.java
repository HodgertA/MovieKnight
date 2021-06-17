package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.business.FilterList;
import comp3350.movieknight.objects.Showing;

public class FilterShowingsTest extends TestCase {

    public FilterShowingsTest(String arg0)
    {
        super(arg0);
    }

    public void testNullItem() {
        System.out.println("Starting filter movies test: testNullItem");

        ArrayList<Showing> showings = new ArrayList<Showing>();
        showings.add(null);
        FilterList.filterShowingsByDate(showings);
        assertTrue(showings.isEmpty());

        System.out.println("Finished filter movies test: testNullList");
    }

    public void testEmptyList(){
        System.out.println("Starting filter movies test: testEmptyList");

        ArrayList<Showing> showings = new ArrayList<Showing>();
        FilterList.filterShowingsByDate(showings);
        assertTrue(showings.isEmpty());//still empty

        System.out.println("Finished filter movies test: testEmptyList");
    }

    public void testNullList(){
        System.out.println("Starting filter movies test: testNullList");

        ArrayList<Showing> showings = null;
        FilterList.filterShowingsByDate(showings);
        assertNull(showings);

        System.out.println("Finished filter movies test: testNullList");
    }

    public void testAllMoviesShowingToday(){
        System.out.println("Starting filter movies test: testAllMoviesShowingToday");

        Calendar today = Calendar.getInstance();
        ArrayList<Showing> showings = new ArrayList<Showing>();

        Showing showing1 = new Showing(1,2,3, 10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),8,10);
        showings.add(showing1);
        Showing showing2 = new Showing(4,5,6,10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),0,0);
        showings.add(showing2);
        Showing showing3 = new Showing(7,8,9,10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),12,59);
        showings.add(showing3);

        FilterList.filterShowingsByDate(showings);

        assertEquals(3,showings.size());

        assertTrue(showings.contains(showing1));
        assertTrue(showings.contains(showing2));
        assertTrue(showings.contains(showing3));

        System.out.println("Finished filter movies test: testAllMoviesShowingToday");

    }

    public void testNoMoviesShowingToday(){
        System.out.println("Starting filter movies test: testNoMoviesShowingToday");

        Calendar differentDay=Calendar.getInstance();
        differentDay.add(Calendar.DATE,1);
        Calendar differentMonth=Calendar.getInstance();
        differentMonth.add(Calendar.MONTH,1);
        Calendar differentYear=Calendar.getInstance();
        differentYear.add(Calendar.YEAR,1);

        ArrayList<Showing> showings = new ArrayList<Showing>();

        showings.add(new Showing(1,2,3,10,differentDay.get(Calendar.YEAR),differentDay.get(Calendar.MONTH)+1,differentDay.get(Calendar.DATE),8,10));
        showings.add(new Showing(1,2,3,10,differentMonth.get(Calendar.YEAR),differentMonth.get(Calendar.MONTH)+1,differentMonth.get(Calendar.DATE),8,10));
        showings.add(new Showing(1,2,3,10,differentYear.get(Calendar.YEAR),differentYear.get(Calendar.MONTH)+1,differentYear.get(Calendar.DATE),8,10));

        FilterList.filterShowingsByDate(showings);
        assertTrue(showings.isEmpty());

        System.out.println("Finished filter movies test: testNoMoviesShowingToday");

    }

    public void testNormalCase(){

        System.out.println("Starting filter movies test: testNormalCase");

        Calendar today=Calendar.getInstance();

        Calendar differentDay=Calendar.getInstance();
        differentDay.add(Calendar.DATE,1);
        Calendar differentMonth=Calendar.getInstance();
        differentMonth.add(Calendar.MONTH,1);
        Calendar differentYear=Calendar.getInstance();
        differentYear.add(Calendar.YEAR,1);

        ArrayList<Showing> showings = new ArrayList<Showing>();
        //correct
        Showing showing1 = new Showing(1,2,3, 10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),8,10);
        showings.add(showing1);

        //different Day
        showings.add(new Showing(1,2,3, 10,differentDay.get(Calendar.YEAR),differentDay.get(Calendar.MONTH)+1,differentDay.get(Calendar.DATE),8,10));

        //correct
        Showing showing2 = new Showing(4,5,6,10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),0,0);
        showings.add(showing2);

        //different Month
        showings.add(new Showing(1,2,3, 10,differentMonth.get(Calendar.YEAR),differentMonth.get(Calendar.MONTH)+1,differentMonth.get(Calendar.DATE),8,10));

        //correct
        Showing showing3 = new Showing(7,8,9,10,today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DATE),12,59);
        showings.add(showing3);

        //different year
        showings.add(new Showing(1,2,3, 10,differentYear.get(Calendar.YEAR),differentYear.get(Calendar.MONTH)+1,differentYear.get(Calendar.DATE),8,10));

        FilterList.filterShowingsByDate(showings);
        assertEquals(3,showings.size());
        assertTrue(showings.contains(showing1));
        assertTrue(showings.contains(showing2));
        assertTrue(showings.contains(showing3));

        System.out.println("Finished filter movies test: testNormalCase");
    }

}