package comp3350.movieknight.presentation.ticketPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Ticket;
import comp3350.movieknight.presentation.movieListPage.MovieItemViewHolder;

public class TicketRecyclerViewAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    private ArrayList<Ticket> tickets;
    public TicketRecyclerViewAdapter(ArrayList<Ticket> tickets){
        this.tickets=tickets;
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
//        (tickets.get(position).get)
//
//        holder.getShowingTime().setText(tickets.get(position).);
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}
