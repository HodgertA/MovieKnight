package comp3350.movieknight.presentation.ticketPage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessMovies;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.business.AccessUser;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.objects.User;

public class TicketRecyclerViewAdapter extends RecyclerView.Adapter<TicketViewHolder> implements AdapterView.OnItemSelectedListener {
    String showingTime;
    String ticketDate;
    String movieName;
    private ArrayList<Ticket> tickets;
    private AccessShowing accessShowing;
    private AccessMovies accessMovies;
    private AccessTickets accessTickets;
    private AccessUser accessUser;
    private int userID;
    private int selectFriend;
    private Context context;
    private Activity activity;

    public TicketRecyclerViewAdapter(int userID, FragmentManager fragmentManager, Activity activity, Context context) {
        tickets = new ArrayList<Ticket>();
        this.userID = userID;
        accessShowing = new AccessShowing();
        accessMovies = new AccessMovies();
        accessTickets = new AccessTickets();
        accessTickets.getUserTickets(tickets,userID);
        accessUser = new AccessUser();
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @NotNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ticket_card, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TicketViewHolder holder, int position) {
        setupString(position);

        holder.getTicketDate().setText(ticketDate);
        holder.getShowingTime().setText(showingTime);
        holder.getMovieTitle().setText(movieName);
        holder.getTickeButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(position);
            }
        });
    }

    public void openDialog(int position) {
        Spinner selectfriendSpinner;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.send_ticket_dialog,null);
        setupString(position);
        ((TextView)view.findViewById(R.id.ticket_date)).setText(ticketDate);
        ((TextView)view.findViewById(R.id.ticket_showing_time)).setText(showingTime);
        ((TextView)view.findViewById(R.id.ticket_movie_title)).setText(movieName);
        selectfriendSpinner = view.findViewById(R.id.select_user_spinner);

        ArrayList<User> friends =new ArrayList<>();
        accessUser.getAllFriends(friends,new User(userID,null));

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(context,R.layout.friend_spinner,friends);
        selectfriendSpinner.setAdapter(adapter);
        selectfriendSpinner.setOnItemSelectedListener(this);

        alertDialog.setView(view).setPositiveButton("YES!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Ticket friendTicket = new Ticket(selectFriend,tickets.get(position).getShowingID(),tickets.get(position).getSeatNum());
                accessTickets.updateTicket(friendTicket);
                updateTickets();
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });
        alertDialog.show();

    }
    public void setupString(int position) {
        Showing showing = accessShowing.getShowing(tickets.get(position).getShowingID());
        ticketDate = (showing.getShowingDate().get(Calendar.MONTH)+1)+"/"+showing.getShowingDate().get(Calendar.DATE);

        String showingHour = String.valueOf(showing.getShowingHour());
        String showingMinute = String.valueOf(showing.getShowingMinute());

        if (Integer.parseInt(showingMinute) < 10) {
            showingMinute = "0" + showingMinute;
        }
        showingTime = showingHour + ":" + showingMinute;
        Movie movie = accessMovies.getMovie(showing.getMovieID());
        movieName = movie.getTitle();
    }

    public void updateTickets() {
        tickets.clear();
        accessTickets.getUserTickets(tickets,userID);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectFriend = ((User) parent.getItemAtPosition(position)).getUserID();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
