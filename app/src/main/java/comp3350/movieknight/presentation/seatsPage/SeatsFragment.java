package comp3350.movieknight.presentation.seatsPage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDescriptionFragment;

public class SeatsFragment extends Fragment {

    private static final int ITEMS_PER_ROW = 6;

    private Context context;
    private RecyclerView seatsRecyclerView;
    private ImageButton backButton;
    RecyclerView.LayoutManager layoutManager;
    private int showingID;
    private int userID;
    private int numberOfSeats;
    private boolean[] seats;

    private static final String ARG_PARAM1 = "showingId";
    private static final String ARG_PARAM2 = "numSeats";
    private static final String ARG_PARAM3 = "userId";

    private AccessTickets accessTickets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            showingID = getArguments().getInt(ARG_PARAM1);
            numberOfSeats = getArguments().getInt(ARG_PARAM2);
            userID = getArguments().getInt(ARG_PARAM3);
        }
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        context = requireContext();

        accessTickets = new AccessTickets();

        seats = accessTickets.compileSeatAvailability(showingID, numberOfSeats);

        seatsRecyclerView = view.findViewById(R.id.seats_recycler_view);
        layoutManager = new GridLayoutManager(context, ITEMS_PER_ROW);
        seatsRecyclerView.setLayoutManager(layoutManager);

        SeatViewAdapter adapter = new SeatViewAdapter(context,this, seats);
        seatsRecyclerView.setAdapter(adapter);

        backButton = view.findViewById(R.id.seats_select_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().popBackStack();
                Fragment fragment = SeatsFragment.this.getParentFragment();
                MovieDescriptionFragment frag = (MovieDescriptionFragment) fragment;
                frag.finishMyChild();
            }
        });
        return view;
    }
}
