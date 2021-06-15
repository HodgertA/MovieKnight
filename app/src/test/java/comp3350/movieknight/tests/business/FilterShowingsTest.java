package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import comp3350.movieknight.business.FilterList;
import comp3350.movieknight.objects.Showing;

public class FilterShowingsTest extends TestCase {
    public FilterShowingsTest(String arg0)
    {
        super(arg0);
    }


    public void testNullItem(){
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

        FilterList.filterShowingsByDate(showings);
        assertEquals(3,showings.size());

        Iterator<Showing> iterator = showings.iterator();

        assertEquals(showing1,iterator.next());
        assertEquals(showing2,iterator.next());
        assertEquals(showing3,iterator.next());

        System.out.println("Finished filter movies test: testAllMoviesShowingToday");

    }

    public void testNoMoviesShowingToday(){
        System.out.println("Starting filter movies test: testNoMoviesShowingToday");

        Calendar toDay=Calendar.getInstance();

        ArrayList<Showing> showings = new ArrayList<Showing>();

        showings.add(new Showing(1,2,3,10,2000,toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),1,toDay.get(Calendar.DATE),8,10));
        int notToday;
        if(toDay.get(Calendar.DATE)<15){
            notToday=20;
        }
        else {
            notToday=10;
        }
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,notToday,8,10));

        FilterList.filterShowingsByDate(showings);

        assertTrue(showings.isEmpty());

        System.out.println("Finished filter movies test: testNoMoviesShowingToday");

    }

    public void testNormalCase(){

        System.out.println("Starting filter movies test: testNormalCase");

        Calendar toDay=Calendar.getInstance();

        ArrayList<Showing> showings = new ArrayList<Showing>();
        //correct
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        //different year
        showings.add(new Showing(1,2,3,10,1999,toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        //correct
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),12,59));
        //different month
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH),toDay.get(Calendar.DATE),8,10));
        //correct
        showings.add(new Showing(4,5,6,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),0,0));
        //different date
        int notToday;
        if(toDay.get(Calendar.DATE)<15){
            notToday=20;
        }
        else {
            notToday=10;
        }
        showings.add(new Showing(1,2,3,10,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,notToday,8,10));


        FilterList.filterShowingsByDate(showings);
        assertEquals(3,showings.size());
        //there are three showing today.

        Iterator<Showing> iterator=showings.iterator();

        while (iterator.hasNext()){
            Showing sh=iterator.next();

            assertEquals( sh.getShowingDate().get(Calendar.YEAR),toDay.get(Calendar.YEAR));
            assertEquals( sh.getShowingDate().get(Calendar.MONTH),toDay.get(Calendar.MONTH));
            assertEquals( sh.getShowingDate().get(Calendar.DATE),toDay.get(Calendar.DATE));
            System.out.println("\t"+sh);
        }

        System.out.println("Finished filter movies test: testNormalCase");
    }

}