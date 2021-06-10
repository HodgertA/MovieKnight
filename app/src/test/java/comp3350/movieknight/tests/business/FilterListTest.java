package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import comp3350.movieknight.business.FilterList;
import comp3350.movieknight.objects.Showing;

public class FilterListTest extends TestCase {
    public FilterListTest(String arg0)
    {
        super(arg0);
    }

    public void testFilterShowingsByDate(){

        System.out.println("start FilterShowingsByDate test\n");

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
        showingArrayList.add(new Showing(1,2,3,toDay.get(Calendar.YEAR),toDay.get(Calendar.MONTH)+1,toDay.get(Calendar.DATE)+1,8,10));




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
        System.out.println("\n\t showing today\n");

        System.out.println("finish FilterShowingsByDate test");
    }

}