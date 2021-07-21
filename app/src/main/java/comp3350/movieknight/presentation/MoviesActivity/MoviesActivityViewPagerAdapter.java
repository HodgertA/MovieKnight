package comp3350.movieknight.presentation.MoviesActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import comp3350.movieknight.presentation.ticketPage.TicketFragment;
import comp3350.movieknight.presentation.movieListPage.MovieListFragment;

public class MoviesActivityViewPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_FRAGMENTS = 2;
    private TicketFragment ticketFragment;
    private int userID;

    public MoviesActivityViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int userID) {
        super(fragmentManager, lifecycle);
        this.userID = userID;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new MovieListFragment(userID);
            case 1:
                ticketFragment = new TicketFragment(userID);
                return ticketFragment;
            default:
                return new MovieListFragment(userID);
        }
    }

    @Override
    public int getItemCount() {
        return NUM_FRAGMENTS;
    }

    public void updateTicketFragment() {
        if(ticketFragment!=null)
        ticketFragment.updateTickets();
    }
}
