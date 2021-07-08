package comp3350.movieknight.presentation.ticketPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessMovies;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.presentation.movieListPage.MovieItemViewHolder;

public class TicketRecyclerViewAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    private ArrayList<Ticket> tickets;
    private AccessShowing accessShowing;
    private AccessMovies accessMovies;
    public TicketRecyclerViewAdapter(ArrayList<Ticket> tickets){
        this.tickets=tickets;
        accessShowing=new AccessShowing();
        accessMovies=new AccessMovies();
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
        ArrayList<Showing>showings=accessShowing.getShowingByID(tickets.get(position).getShowingID());
        if(showings.size()>0){
            String ticketDate=String.valueOf("Date: "+(showings.get(0).getShowingDate().get(Calendar.MONTH)+1)+"."+showings.get(0).getShowingDate().get(Calendar.DATE));
            holder.getTicketDate().setText(ticketDate);

            String showingTime=String.valueOf(showings.get(0).getShowingTime());
            String[] time=showingTime.split("\\.");

            if(time[1].length()<2){
                time[1]+='0';
            }
            holder.getShowingTime().setText(time[0] + ":" + time[1]);

            ArrayList<Movie> movies=accessMovies.getMovieByID(showings.get(0).getMovieID());
            if(movies.size()>0){
                holder.getMoveTitle().setText(movies.get(0).getTitle());
            }
        }
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}
