package comp3350.movieknight.presentation.seatsPage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

import comp3350.movieknight.business.AccessTickets;

import comp3350.movieknight.presentation.movieListPage.MovieListFragment;

public class SeatsFragment extends Fragment {

    private static final int ITEMS_PER_ROW = 6;

    private Context context;
    private RecyclerView seatsRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    private int showingId;
    private int numberOfSeats;
    private boolean[] seats;

    private static final String ARG_PARAM1 = "showingId";
    private static final String ARG_PARAM2 = "numSeats";

    private AccessTickets accessTickets;


    public SeatsFragment() { }
    public static SeatsFragment newInstance(int showingId, int numberOfSeats) {
        SeatsFragment fragment = new SeatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, showingId);
        args.putInt(ARG_PARAM2, numberOfSeats);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            showingId = getArguments().getInt(ARG_PARAM1);
            numberOfSeats = getArguments().getInt(ARG_PARAM2);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        context = requireContext();

        accessTickets = new AccessTickets();

        seats = accessTickets.compileSeatReservations(showingId, numberOfSeats);

        seatsRecyclerView = view.findViewById(R.id.seats_recycler_view);
        layoutManager = new GridLayoutManager(context, ITEMS_PER_ROW);
        seatsRecyclerView.setLayoutManager(layoutManager);

        SeatViewAdapter adapter = new SeatViewAdapter(context,this, seats);
        seatsRecyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            Fragment fragment = SeatsFragment.this.getParentFragment();
            MovieListFragment frag = (MovieListFragment) fragment;
            frag.finishMyChild();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }
}
