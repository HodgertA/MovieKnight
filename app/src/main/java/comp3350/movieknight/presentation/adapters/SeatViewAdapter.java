package comp3350.movieknight.presentation.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.presentation.holders.SeatViewHolder;

public class SeatViewAdapter extends RecyclerView.Adapter<SeatViewHolder> {

    boolean []seats;

    public SeatViewAdapter(Showing showing) {
        AccessTickets accessTickets = new AccessTickets();
        this.seats = accessTickets.compileSeatReservations(showing);
    }

    @NonNull
    @NotNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seat_item_card,parent,false);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SeatViewHolder holder, int position) {
        String backround;

        if(seats[position])
        {
            backround = "@drawable/available_seat";
        }
        else
        {
            backround = "@drawable/reserved_seat";
        }

        holder.getSeatView().setBackground(Drawable.createFromPath(backround));
    }

    @Override
    public int getItemCount() {
        return seats.length;
    }
}
