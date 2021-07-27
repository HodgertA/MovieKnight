package comp3350.movieknight.presentation.seatsPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import comp3350.movieknight.R;

public class SeatViewAdapter extends RecyclerView.Adapter<SeatViewHolder> {

    private boolean[] seats;
    private boolean[] unavailableSeats;
    private ArrayList<Integer> selectedSeats;
    private Context context;
    private final int FULL_OPACITY = 255;
    private final int QUARTER_OPACITY = 64;
    private final boolean DEFAULT_ENABLED = true;

    public SeatViewAdapter(Context context, boolean []seats) {
        this.seats = seats;
        unavailableSeats = seats.clone();
        this.selectedSeats = new ArrayList<>();
        this.context = context;
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
        ImageButton seat = holder.getSeatView();
        seat.setEnabled(DEFAULT_ENABLED);
        seat.setImageAlpha(FULL_OPACITY);
        if(!seats[position]) {
            if(!unavailableSeats[position]) {
                seat.setEnabled(!DEFAULT_ENABLED);
                seat.setImageAlpha(QUARTER_OPACITY);
            }
            seat.setImageDrawable(context.getResources().getDrawable(R.drawable.reserved_seat));
        } else {
            seat.setImageDrawable(context.getResources().getDrawable(R.drawable.available_seat));
        }

        holder.getSeatView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seats[position] = !seats[position];
                if(!seats[position] && !selectedSeats.contains(position)) {
                    selectedSeats.add(position);
                } else {
                    selectedSeats.remove((Integer) position);
                }
                notifyDataSetChanged();
            }
        });
    }

    public ArrayList getSelectedSeats() {
        return selectedSeats;
    }

    @Override
    public int getItemCount() {
        return seats.length;
    }
}