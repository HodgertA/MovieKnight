package comp3350.movieknight.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import comp3350.movieknight.objects.Ticket;

public class FindAvailableSeats {

    public static boolean[] compileAvailableSeats(ArrayList<Ticket> tickets, int numberOfSeats) {
        boolean[] result = new boolean[numberOfSeats];
        Arrays.fill(result, true);

        Iterator<Ticket> itr = tickets.iterator();
        while (itr.hasNext()) {
            Ticket ticket = itr.next();
            result[ticket.getSeatNum()] = false;
        }

        return result;
    }
}
