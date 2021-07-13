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

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
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
    private static final String ARG_PARAM5 = "userId";

    private String movieTitle;
    private int moviePoster;
    private String movieDesc;
    private int movieID;
    private int userID;

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
    private ImageButton backButton;

    public MovieDescriptionFragment() {
    }

    public static MovieDescriptionFragment newInstance(String movieTitle, int moviePoster, String movieDesc,int movieID, int userID) {
        MovieDescriptionFragment fragment = new MovieDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, movieTitle);
        args.putInt(ARG_PARAM2, moviePoster);
        args.putString(ARG_PARAM3, movieDesc);
        args.putInt(ARG_PARAM4,movieID);
        args.putInt(ARG_PARAM5,userID);
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
            movieID=getArguments().getInt(ARG_PARAM4);
            userID=getArguments().getInt(ARG_PARAM5);
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
        String result = accessShowing.getShowingForMovieByDate(showings,movieID,selectDate);


        if(result == null) {
            showingTimeRecyclerView= view.findViewById(R.id.show_time_recycler_view);
            showingTimeRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        }

        ShowtimeRecyclerViewAdapter adapter = new ShowtimeRecyclerViewAdapter(context,this, showings);
        showingTimeRecyclerView.setAdapter(adapter);

        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectDate.set(Calendar.YEAR,year);
                selectDate.set(Calendar.MONTH,month);
                selectDate.set(Calendar.DATE,dayOfMonth);
                showings.clear();
                accessShowing.getShowingForMovieByDate(showings,movieID,selectDate);
                adapter.notifyDataSetChanged();

            }
        };

        datePicker=new DatePickerDialog(context, AlertDialog.THEME_DEVICE_DEFAULT_DARK,dateSetListener,selectDate.get(Calendar.YEAR),selectDate.get(Calendar.MONTH),selectDate.get(Calendar.DATE));
        datePicker.getDatePicker().setMinDate(selectDate.getTimeInMillis());
        datePicker.getDatePicker().setX(105);
        datePicker.getDatePicker().setY(20);
        datePicker.getDatePicker().setScaleY(1.1f);
        datePicker.getDatePicker().setScaleX(1.1f);


        selectDate.add(Calendar.DATE,6);
        datePicker.getDatePicker().setMaxDate(selectDate.getTimeInMillis());
        dateButton= view.findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show();
            }
        });

        backButton = view.findViewById(R.id.movie_description_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().popBackStack();
                Fragment fragment = MovieDescriptionFragment.this.getParentFragment(); // getParentFragment() is a built-in method in Android, this method can return a fragment
                MovieListFragment frag = (MovieListFragment) fragment; // Note that this type conversion must be performed to make the fragment generic into a specific parent fragment
                frag.finishMyChild();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewMovieTitle = view.findViewById(R.id.textViewMovieTitle);
        imageViewMovieImage = view.findViewById(R.id.imageViewMovieImage);
        textViewMovieDesc = view.findViewById(R.id.textViewMovieDesc);

        textViewMovieTitle.setText(movieTitle);
        textViewMovieDesc.setText(movieDesc);
        imageViewMovieImage.setImageResource(moviePoster);
    }

    public void openSeatsPage(Showing showing) {
        showingTimeRecyclerView.setVisibility(View.GONE);
        textViewMovieTitle.setVisibility(View.GONE);
        imageViewMovieImage.setVisibility(View.GONE);
        textViewMovieDesc.setVisibility(View.GONE);
        dateButton.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String selectedDate = dateFormat.format(selectDate.getTime());

        this.getParentFragment().setMenuVisibility(false);
        childFragment = new SeatsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("showingId",showing.getShowingID());
        bundle.putInt("numSeats",showing.getSeats());
        bundle.putInt("userId",userID);

        // parse movie info to next screen
        bundle.putString("movieTitle", movieTitle);
        bundle.putString("movieTime", String.valueOf(showing.getShowingTime()));
        bundle.putString("movieDate", selectedDate);

        childFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.movie_description_fragment_container, childFragment).addToBackStack(null).commit();
    }

    //Remove child fragment (MovieDescriptionFragment) from stack of fragment to show parent fragment(MovieListFragment)
    public void finishMyChild(){
        showingTimeRecyclerView.setVisibility(View.VISIBLE);
        textViewMovieTitle.setVisibility(View.VISIBLE);
        imageViewMovieImage.setVisibility(View.VISIBLE);
        textViewMovieDesc.setVisibility(View.VISIBLE);
        dateButton.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(childFragment);
        transaction.commit();
    }
}