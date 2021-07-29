package comp3350.movieknight.presentation.movieDetailsPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.presentation.MainActivity;
import comp3350.movieknight.presentation.MoviesActivity.MoviesActivity;
import comp3350.movieknight.presentation.movieListPage.MovieListFragment;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "movieTitle";
    private static final String ARG_PARAM2 = "moviePoster";
    private static final String ARG_PARAM3 = "movieDesc";
    private static final String ARG_PARAM4 = "movieId";
    private static final String ARG_PARAM5 = "userId";

    private static String movieTitle;
    private int moviePoster;
    private String movieDesc;
    private int movieID;
    private static int userID;
    private static Bundle chosenShowing;

    private TextView textViewMovieTitle;
    private ImageView imageViewMovieImage;
    private TextView textViewMovieDesc;

    private AccessShowing accessShowing;
    private ArrayList<Showing> showings;
    private RecyclerView showingTimeRecyclerView;
    private DatePickerDialog datePicker;
    private Button dateButton;
    private static Calendar selectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle chosenMovie = MovieListFragment.getChosenMovie();
        if(chosenMovie != null) {
            movieTitle = chosenMovie.getString(ARG_PARAM1);
            moviePoster = chosenMovie.getInt(ARG_PARAM2);
            movieDesc = chosenMovie.getString(ARG_PARAM3);
            movieID = chosenMovie.getInt(ARG_PARAM4);
            userID = chosenMovie.getInt(ARG_PARAM5);
        }

        selectDate = Calendar.getInstance();
        accessShowing = new AccessShowing();

        showings = new ArrayList<>();
        String result = accessShowing.getShowingForMovieByDate(showings, movieID, selectDate);

        if (result == null) {
            showingTimeRecyclerView= findViewById(R.id.show_time_recycler_view);
            showingTimeRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        }

        ShowtimeRecyclerViewAdapter adapter = new ShowtimeRecyclerViewAdapter(this, showings);
        showingTimeRecyclerView.setAdapter(adapter);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
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

        datePicker=new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener, selectDate.get(Calendar.YEAR),selectDate.get(Calendar.MONTH),selectDate.get(Calendar.DATE));
        datePicker.getDatePicker().setMinDate(selectDate.getTimeInMillis());
        datePicker.getDatePicker().setX(105);
        datePicker.getDatePicker().setY(20);
        datePicker.getDatePicker().setScaleY(1.1f);
        datePicker.getDatePicker().setScaleX(1.1f);


        selectDate.add(Calendar.DATE,6);
        datePicker.getDatePicker().setMaxDate(selectDate.getTimeInMillis());
        dateButton = findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show();
            }
        });

        initializeView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
            case R.id.action_logout:
                Intent intent= new Intent(MovieDetailsActivity.this, MainActivity.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    private void initializeView() {
        textViewMovieTitle = findViewById(R.id.textViewMovieTitle);
        imageViewMovieImage = findViewById(R.id.imageViewMovieImage);
        textViewMovieDesc = findViewById(R.id.textViewMovieDesc);

        textViewMovieTitle.setText(movieTitle);
        textViewMovieDesc.setText(movieDesc);
        imageViewMovieImage.setImageResource(moviePoster);
    }

    public static void openSeatsPage(Showing showing) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String selectedDate = dateFormat.format(selectDate.getTime());

        chosenShowing = new Bundle();
        chosenShowing.putInt("showingId", showing.getShowingID());
        chosenShowing.putInt("numSeats", showing.getSeats());
        chosenShowing.putInt("userId", userID);

        // parse movie info to next screen
        chosenShowing.putString("movieTitle", movieTitle);
        chosenShowing.putString("movieTime", showing.getShowingHour() + ":" + showing.getShowingMinute());
        chosenShowing.putString("movieDate", selectedDate);
    }

    public static Bundle getChosenSeats() {
        return chosenShowing;
    }
}