package comp3350.movieknight.presentation.movieDetailsPage;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.R;

import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.presentation.movieListPage.MovieListFragment;

import comp3350.movieknight.presentation.seatsPage.SeatsFragment;


public class MovieDescriptionFragment extends Fragment {

    private static final String ARG_PARAM1 = "movieTitle";
    private static final String ARG_PARAM2 = "moviePoster";
    private static final String ARG_PARAM3 = "movieDesc";
    private static final String ARG_PARAM4 = "movieId";

    private String movieTitle;
    private int moviePoster;
    private String movieDesc;
    private int movieId;

    private TextView textViewMovieTitle;
    private ImageView imageViewMovieImage;
    private TextView textViewMovieDesc;


    private AccessShowing accessShowing;
    private ArrayList<Showing> showings;
    private RecyclerView showingTimeRecyclerView;
    private Context context;
    private Fragment childFragment;
    private DatePickerDialog datePicker;
    private Button dateButton;
    private Calendar selectDate;

    public MovieDescriptionFragment() {
    }

    public static MovieDescriptionFragment newInstance(String movieTitle, int moviePoster, String movieDesc,int movieId) {
        MovieDescriptionFragment fragment = new MovieDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, movieTitle);
        args.putInt(ARG_PARAM2, moviePoster);
        args.putString(ARG_PARAM3, movieDesc);
        args.putInt(ARG_PARAM4,movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieTitle = getArguments().getString(ARG_PARAM1);
            moviePoster = getArguments().getInt(ARG_PARAM2);
            movieDesc = getArguments().getString(ARG_PARAM3);
            movieId=getArguments().getInt(ARG_PARAM4);
            selectDate=Calendar.getInstance();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view=inflater.inflate(R.layout.fragment_movie_description, container, false);
        context = requireContext();

        accessShowing=new AccessShowing();

        showings =new ArrayList<>();
        String result = accessShowing.getShowingForMovieByDate(showings,movieId,selectDate);


        if(result == null) {
            showingTimeRecyclerView= view.findViewById(R.id.show_time_recycler_view);
            showingTimeRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        }

        ShowtimeRecyclerViewAdapter adapter = new ShowtimeRecyclerViewAdapter(context,this, showings);
        showingTimeRecyclerView.setAdapter(adapter);
        ///////-----------------------------------------

        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectDate.set(Calendar.YEAR,year);
                selectDate.set(Calendar.MONTH,month);
                selectDate.set(Calendar.DATE,dayOfMonth);
                showings.clear();
                accessShowing.getShowingForMovieByDate(showings,movieId,selectDate);
                adapter.notifyDataSetChanged();

            }
        };
        datePicker=new DatePickerDialog(context, AlertDialog.THEME_DEVICE_DEFAULT_DARK,dateSetListener,selectDate.get(Calendar.YEAR),selectDate.get(Calendar.MONTH),selectDate.get(Calendar.DATE));
        datePicker.getDatePicker().setMinDate(selectDate.getTimeInMillis());
        selectDate.add(Calendar.DATE,6);
        datePicker.getDatePicker().setMaxDate(selectDate.getTimeInMillis());
        dateButton= view.findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show();
            }
        });
///////-----------------------------------------



        return view;
    }





    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //for displaying back arrow
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);

        textViewMovieTitle = view.findViewById(R.id.textViewMovieTitle);
        imageViewMovieImage = view.findViewById(R.id.imageViewMovieImage);
        textViewMovieDesc = view.findViewById(R.id.textViewMovieDesc);

        textViewMovieTitle.setText(movieTitle);
        textViewMovieDesc.setText(movieDesc);
        imageViewMovieImage.setImageResource(moviePoster);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            Fragment fragment = MovieDescriptionFragment.this.getParentFragment(); // getParentFragment() is a built-in method in Android, this method can return a fragment
            MovieListFragment frag = (MovieListFragment) fragment; // Note that this type conversion must be performed to make the fragment generic into a specific parent fragment
            frag.finishMyChild();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }


    public void openSeatsPage(Showing showing) {
        showingTimeRecyclerView.setVisibility(View.GONE);
        textViewMovieTitle.setVisibility(View.GONE);
        imageViewMovieImage.setVisibility(View.GONE);
        textViewMovieDesc.setVisibility(View.GONE);
        dateButton.setVisibility(View.GONE);

        this.getParentFragment().setMenuVisibility(false);
        childFragment = new SeatsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("showingId",showing.getShowingID());
        bundle.putInt("numSeats",showing.getSeats());
        childFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.movie_description_fragment_container, childFragment).commit();
    }

    //Remove child fragment (MovieDescriptionFragment) from stack of fragment to show parent fragment(MovieListFragment)
    public void finishMyChild(){
        showingTimeRecyclerView.setVisibility(View.VISIBLE);
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(childFragment);
        transaction.commit();
    }
}