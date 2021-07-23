package comp3350.movieknight.presentation.cartFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDescriptionFragment;
import comp3350.movieknight.presentation.movieListPage.MovieListFragment;
import comp3350.movieknight.presentation.seatsPage.SeatsFragment;

public class CartFragment extends Fragment {

    // the fragment initialization parameters
    private static final String ARG_PARAM1 = "movieTitle";
    private static final String ARG_PARAM2 = "movieTime";
    private static final String ARG_PARAM3 = "numSeats";
    private static final String ARG_PARAM4 = "movieDate";
    private static final String ARG_PARAM5 = "userId";
    private static final String ARG_PARAM6 = "showingId";
    private static final String ARG_PARAM7 = "selectedSeats";

    private String movieTitle;
    private String movieTime;
    private int numTickets;
    private String showDate;
    private int userID;
    private int showingID;
    private ArrayList<Integer> selectedSeats; // the seat id

    private TextView textViewMovieName;
    private TextView textViewMovieTime;
    private TextView textViewNumOfTickets;
    private Button btn_paybill;
    private AccessTickets accessTickets;
    private TextView textViewSelectedSeats;

    public CartFragment() { }

    public static CartFragment newInstance(String movieTitle, String movieTime, int numTickets) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, movieTitle);
        args.putString(ARG_PARAM2, movieTime);
        args.putInt(ARG_PARAM3, numTickets);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieTitle = getArguments().getString(ARG_PARAM1);
            movieTime = getArguments().getString(ARG_PARAM2);
            numTickets = getArguments().getInt(ARG_PARAM3);
            showDate = getArguments().getString(ARG_PARAM4);
            userID = getArguments().getInt(ARG_PARAM5);
            showingID = getArguments().getInt(ARG_PARAM6);
            selectedSeats = getArguments().getIntegerArrayList(ARG_PARAM7);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        accessTickets = new AccessTickets();

        textViewMovieName = view.findViewById(R.id.textViewMovieName);
        textViewMovieTime = view.findViewById(R.id.textViewMovieTime);
        textViewNumOfTickets = view.findViewById(R.id.textViewNumOfTickets);
        btn_paybill = view.findViewById(R.id.btn_paybill);
        textViewSelectedSeats = view.findViewById(R.id.textViewSeatID);

        textViewMovieTime.setText(showDate + " " + movieTime);
        textViewNumOfTickets.setText(numTickets + "");
        textViewMovieName.setText(movieTitle);
        // remove brackets for output
        textViewSelectedSeats.setText(selectedSeats.toString().substring(1, selectedSeats.toString().length() - 1) + "");

        btn_paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passToDatabase();
                backToMovieList();
            }
        });
    }
    public void backToMovieList(){

        Fragment fragment = getParentFragment();
        SeatsFragment seatsFragment = (SeatsFragment) fragment;

        fragment = fragment.getParentFragment();
        MovieDescriptionFragment movieDescriptionFragment=(MovieDescriptionFragment) fragment;

        fragment = fragment.getParentFragment();
        MovieListFragment movieListFragment=(MovieListFragment)fragment;

        seatsFragment.finishMyChild();
        movieDescriptionFragment.finishMyChild();
        movieListFragment.finishMyChild();


    }
    public void passToDatabase() {
        accessTickets.createTicket(userID, selectedSeats, showingID);
        getChildFragmentManager().popBackStack();
    }
}