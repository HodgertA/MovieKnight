package comp3350.movieknight.presentation.cartActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.presentation.MainActivity;
import comp3350.movieknight.presentation.MoviesActivity.MoviesActivity;
import comp3350.movieknight.presentation.seatsPage.SeatsActivity;

public class CartActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle chosenSeats = SeatsActivity.getChosenSeats();
        if (chosenSeats != null) {
            movieTitle = chosenSeats.getString(ARG_PARAM1);
            movieTime = chosenSeats.getString(ARG_PARAM2);
            numTickets = chosenSeats.getInt(ARG_PARAM3);
            showDate = chosenSeats.getString(ARG_PARAM4);
            userID = chosenSeats.getInt(ARG_PARAM5);
            showingID = chosenSeats.getInt(ARG_PARAM6);
            selectedSeats = chosenSeats.getIntegerArrayList(ARG_PARAM7);
        }
        initializeView();
    }

    private void initializeView() {
        accessTickets = new AccessTickets();

        textViewMovieName = findViewById(R.id.textViewMovieName);
        textViewMovieTime = findViewById(R.id.textViewMovieTime);
        textViewNumOfTickets = findViewById(R.id.textViewNumOfTickets);
        btn_paybill = findViewById(R.id.btn_paybill);
        textViewSelectedSeats = findViewById(R.id.textViewSeatID);

        textViewMovieTime.setText(showDate + " " + movieTime);
        textViewNumOfTickets.setText(numTickets + "");
        textViewMovieName.setText(movieTitle);
        // remove brackets for output
        textViewSelectedSeats.setText(selectedSeats.toString().substring(1, selectedSeats.toString().length() - 1) + "");

        btn_paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passToDatabase();
            }
        });
    }

    private void passToDatabase() {
        accessTickets.createTicket(userID, selectedSeats, showingID);
        navigateUpTo(new Intent(getBaseContext(), MoviesActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}