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
import comp3350.movieknight.objects.Seat;

public class SeatViewAdapter extends RecyclerView.Adapter<SeatViewHolder> {

    private ArrayList<Seat> seats;
    private Context context;

    public SeatViewAdapter(Context context, ArrayList<Seat> seats) {
        this.seats = seats;
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
        if(seats.get(position).isSelected()) {
            seat.setEnabled(false);
            seat.setAlpha(64);
            seat.setImageDrawable(context.getResources().getDrawable(R.drawable.reserved_seat));
        } else {
            seat.setImageDrawable(context.getResources().getDrawable(R.drawable.available_seat));
        }
        holder.getSeatView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seats.get(position).setSelected(true);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return seats.size();
    }
}
