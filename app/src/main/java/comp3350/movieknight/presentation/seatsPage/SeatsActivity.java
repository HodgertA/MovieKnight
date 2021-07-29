package comp3350.movieknight.presentation.seatsPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.presentation.MainActivity;
import comp3350.movieknight.presentation.cartActivity.CartActivity;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDetailsActivity;

public class SeatsActivity extends AppCompatActivity {

    private static final int ITEMS_PER_ROW = 6;

    private RecyclerView seatsRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    private int showingID;
    private int userID;
    private int numberOfSeats;
    private boolean[] seats;
    private String movieTitle;
    private String showTime;
    private String showDate;
    private static Bundle chosenSeats;

    private static final String ARG_PARAM1 = "showingId";
    private static final String ARG_PARAM2 = "numSeats";
    private static final String ARG_PARAM3 = "userId";
    private static final String ARG_PARAM4 = "movieTitle";
    private static final String ARG_PARAM5 = "movieTime";
    private static final String ARG_PARAM6 = "movieDate";

    private AccessTickets accessTickets;
    private Button btnCheckout;
    private SeatViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle chosenShowing = MovieDetailsActivity.getChosenSeats();
        if (chosenShowing != null) {
            showingID = chosenShowing.getInt(ARG_PARAM1);
            numberOfSeats = chosenShowing.getInt(ARG_PARAM2);
            userID = chosenShowing.getInt(ARG_PARAM3);

            // retrieve the movie title and show time from movieDescriptionFragment
            movieTitle = chosenShowing.getString(ARG_PARAM4);
            showTime = chosenShowing.getString(ARG_PARAM5);
            showDate = chosenShowing.getString(ARG_PARAM6);
        }

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
                Intent intent= new Intent(SeatsActivity.this, MainActivity.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeView() {
        accessTickets = new AccessTickets();

        seats = accessTickets.compileSeatAvailability(showingID, numberOfSeats);

        seatsRecyclerView = findViewById(R.id.seats_recycler_view);
        layoutManager = new GridLayoutManager(this, ITEMS_PER_ROW);
        seatsRecyclerView.setLayoutManager(layoutManager);

        adapter = new SeatViewAdapter(this, seats);
        seatsRecyclerView.setAdapter(adapter);

        btnCheckout = findViewById(R.id.btn_checkout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelectedSeats().size() > 0) {
                    openCartPage();
                } else {
                    Toast.makeText(getApplicationContext(),"No seats selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    public void openCartPage() {
        ArrayList<Integer> selectedSeats = adapter.getSelectedSeats();

        chosenSeats = new Bundle();
        chosenSeats.putInt("showingId", showingID);
        chosenSeats.putInt("numSeats", selectedSeats.size());
        chosenSeats.putIntegerArrayList("selectedSeats", selectedSeats);
        chosenSeats.putInt("userId", userID);

        // parse movie info to next screen
        chosenSeats.putString("movieTitle", movieTitle);
        chosenSeats.putString("movieTime", showTime);
        chosenSeats.putString("movieDate", showDate);

        Intent cartActivttyIntent = new Intent(this, CartActivity.class);
        startActivity(cartActivttyIntent);
    }

    public static Bundle getChosenSeats() {
        return chosenSeats;
    }
}