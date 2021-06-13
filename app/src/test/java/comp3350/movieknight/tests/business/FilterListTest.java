package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import comp3350.movieknight.business.FilterList;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;

public class FilterListTest extends TestCase {
    public FilterListTest(String arg0)
    {
        super(arg0);
    }


    public void testNullShowingForFS(){
        System.out.println("starting test null Showing to filter showing by date");

        ArrayList<Showing> showingArrayList=new ArrayList<Showing>();
        showingArrayList.add(null);
        FilterList.filterShowingsByDate(showingArrayList);
        assertTrue(showingArrayList.isEmpty());

        System.out.println("finished  test null Showing to filter showing by date\n");
    }

    public void testEmptyListForFS(){
        System.out.println("starting test empty ShowingList to filter showing by date");

        ArrayList<Showing> showingArrayList=new ArrayList<Showing>();
        FilterList.filterShowingsByDate(showingArrayList);
        assertTrue(showingArrayList.isEmpty());//still empty

        System.out.println("finished test empty ShowingList to filter showing by date\n");
    }


    public void testNullListForFS(){
        System.out.println("starting test null List to filter showing by date");

        ArrayList<Showing> showingArrayList=null;
        FilterList.filterShowingsByDate(showingArrayList);
        assertNull(showingArrayList);

        System.out.println("finished test null List to filter showing by date\n");
    }

    public void testAllTodayMovieListForFS(){
        System.out.println("starting test all Showing on today to filter showing by date");

        Calendar toDay=Calendar.getInstance();

        ArrayList<Showing> showingArrayList=new ArrayList<Showing>();

        Showing showing1=new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10);
        showingArrayList.add(showing1);
        Showing showing2=new Showing(4,5,6,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),0,0);
        showingArrayList.add(showing2);
        Showing showing3=new Showing(7,8,9,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),12,59);
        showingArrayList.add(showing3);

        FilterList.filterShowingsByDate(showingArrayList);

        FilterList.filterShowingsByDate(showingArrayList);
        assertEquals(3,showingArrayList.size());

        Iterator<Showing> iterator=showingArrayList.iterator();

        assertEquals(showing1,iterator.next());
        assertEquals(showing2,iterator.next());
        assertEquals(showing3,iterator.next());

        System.out.println("finished test all Showing on today to filter showing by date\n");

    }

    public void testAllNotTodayMovieListForFS(){
        System.out.println("starting test all Showing not on today to filter showing by date");

        Calendar toDay=Calendar.getInstance();

        ArrayList<Showing> showingArrayList=new ArrayList<Showing>();

        showingArrayList.add(new Showing(1,2,3,2000,toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),1,toDay.get(Calendar.DATE),8,10));
        int notToday;
        if(toDay.get(Calendar.DATE)<15){
            notToday=20;
        }
        else {
            notToday=10;
        }
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,notToday,8,10));

        FilterList.filterShowingsByDate(showingArrayList);

        assertTrue(showingArrayList.isEmpty());

        System.out.println("finished test all Showing not on today to filter showing by date\n");

    }

    public void testFilterShowingsByDate(){

        System.out.println("starting FilterShowingsByDate test");

        Calendar toDay=Calendar.getInstance();

        ArrayList<Showing> showingArrayList=new ArrayList<Showing>();
        //correct
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        //different year
        showingArrayList.add(new Showing(1,2,3,1999,toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),8,10));
        //correct
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),12,59));
        //different month
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH),toDay.get(Calendar.DATE),8,10));
        //correct
        showingArrayList.add(new Showing(4,5,6,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE),0,0));
        //different date
        int notToday;
        if(toDay.get(Calendar.DATE)<15){
            notToday=20;
        }
        else {
            notToday=10;
        }
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,notToday,8,10));


        FilterList.filterShowingsByDate(showingArrayList);
        assertEquals(3,showingArrayList.size());
        //there are three showing today.

        Iterator<Showing> iterator=showingArrayList.iterator();

        while (iterator.hasNext()){
            Showing sh=iterator.next();

            assertEquals( sh.getShowingDate().get(Calendar.YEAR),toDay.get(Calendar.YEAR));
            assertEquals( sh.getShowingDate().get(Calendar.MONTH),toDay.get(Calendar.MONTH));
            assertEquals( sh.getShowingDate().get(Calendar.DATE),toDay.get(Calendar.DATE));
            System.out.println("\t"+sh);
        }
        System.out.println("\tshowing today");

        System.out.println("finished FilterShowingsByDate test\n");
    }

}