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

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.objects.Seat;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDescriptionFragment;

public class SeatsFragment extends Fragment {

    private static final int ITEMS_PER_ROW = 6;

    private Context context;
    private RecyclerView seatsRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    private int showingId;
    private ArrayList<Seat> seats;

    private static final String ARG_PARAM1 = "showingId";
    private static final String ARG_PARAM2 = "numSeats";
    private AccessTickets accessTickets;

    public SeatsFragment() { }

    public static SeatsFragment newInstance(int showingId) {
        SeatsFragment fragment = new SeatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, showingId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            showingId = getArguments().getInt(ARG_PARAM1);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        context = requireContext();

        accessTickets = new AccessTickets();

        seats = accessTickets.getShowingSeats(showingId);

        seatsRecyclerView = view.findViewById(R.id.seats_recycler_view);
        layoutManager = new GridLayoutManager(context, ITEMS_PER_ROW);
        seatsRecyclerView.setLayoutManager(layoutManager);

        SeatViewAdapter adapter = new SeatViewAdapter(context, seats);
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
            MovieDescriptionFragment frag = (MovieDescriptionFragment) fragment;
            frag.finishMyChild();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }
}
