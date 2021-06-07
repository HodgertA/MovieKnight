package comp3350.movieknight;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import comp3350.movieknight.ui.fragments.CartFragment;
import comp3350.movieknight.ui.fragments.MovieListFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_FRAGMENTS = 2;

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new MovieListFragment();
            case 1:
                return new CartFragment();
            default:
                return new MovieListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_FRAGMENTS;
    }
}
