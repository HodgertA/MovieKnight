package comp3350.movieknight.presentation.seatsPage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.presentation.cartFragment.CartFragment;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDescriptionFragment;

public class SeatsFragment extends Fragment {

    private static final int ITEMS_PER_ROW = 6;

    private Context context;
    private RecyclerView seatsRecyclerView;
    private ImageButton backButton;
    private TextView screenText;
    RecyclerView.LayoutManager layoutManager;
    private int showingID;
    private int userID;
    private int numberOfSeats;
    private boolean[] seats;
    private String movieTitle;
    private String showTime;
    private String showDate;

    private static final String ARG_PARAM1 = "showingId";
    private static final String ARG_PARAM2 = "numSeats";
    private static final String ARG_PARAM3 = "userId";
    private static final String ARG_PARAM4 = "movieTitle";
    private static final String ARG_PARAM5 = "movieTime";
    private static final String ARG_PARAM6 = "movieDate";

    private AccessTickets accessTickets;
    private CartFragment childFragment;
    private Button btnCheckout;
    private SeatViewAdapter adapter;

    public SeatsFragment() { }

    public static SeatsFragment newInstance (int showingId, int numberOfSeats, int userID) {
        SeatsFragment fragment = new SeatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, showingId);
        args.putInt(ARG_PARAM2, numberOfSeats);
        args.putInt(ARG_PARAM3, userID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            showingID = getArguments().getInt(ARG_PARAM1);
            numberOfSeats = getArguments().getInt(ARG_PARAM2);
            userID = getArguments().getInt(ARG_PARAM3);

            // retrieve the movie title and show time from movieDescriptionFragment
            movieTitle = getArguments().getString(ARG_PARAM4);
            showTime = getArguments().getString(ARG_PARAM5);
            showDate = getArguments().getString(ARG_PARAM6);
        }
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        context = requireContext();

        accessTickets = new AccessTickets();

        seats = accessTickets.compileSeatAvailability(showingID, numberOfSeats);
        screenText = view.findViewById(R.id.screen_textView);

        seatsRecyclerView = view.findViewById(R.id.seats_recycler_view);
        layoutManager = new GridLayoutManager(context, ITEMS_PER_ROW);
        seatsRecyclerView.setLayoutManager(layoutManager);

        adapter = new SeatViewAdapter(context, seats);
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

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCheckout = view.findViewById(R.id.btn_checkout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelectedSeats().size() > 0) {
                    openCartPage();
                } else {
                    Toast.makeText(context,"No seats selected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openCartPage() {
        ArrayList<Integer> selectedSeats = adapter.getSelectedSeats();
        backButton.setVisibility(View.GONE);
        seatsRecyclerView.setVisibility(View.GONE);
        screenText.setVisibility(View.GONE);
        btnCheckout.setVisibility(View.GONE);

        this.getParentFragment().setMenuVisibility(false);
        childFragment = new CartFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("showingId", showingID);
        bundle.putInt("numSeats", selectedSeats.size());
        bundle.putIntegerArrayList("selectedSeats", selectedSeats);
        bundle.putInt("userId", userID);

        // parse movie info to next screen
        bundle.putString("movieTitle", movieTitle);
        bundle.putString("movieTime", showTime);
        bundle.putString("movieDate", showDate);

        childFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.seat_fragment_container, childFragment).addToBackStack(null).commit();
    }
}
