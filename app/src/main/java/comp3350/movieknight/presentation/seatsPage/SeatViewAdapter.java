package comp3350.movieknight.presentation.seatsPage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class SeatViewAdapter extends RecyclerView.Adapter<SeatViewHolder> {

    private boolean []seats;
    private SeatsFragment seatsFragment;
    private Context context;

    public SeatViewAdapter(Context context,SeatsFragment seatsFragment, boolean []seats) {
        this.seats = seats;
        this.context = context;
        this.seatsFragment = seatsFragment;
    }

    @NonNull
    @NotNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.seat_item_card,parent,false);
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
