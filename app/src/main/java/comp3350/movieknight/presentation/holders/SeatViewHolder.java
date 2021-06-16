package comp3350.movieknight.presentation.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class SeatViewHolder extends RecyclerView.ViewHolder{
    private TextView seatView;

    public SeatViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        seatView = itemView.findViewById(R.id.seatView);
    }

    public TextView getSeatView() {
        return seatView;
    }
}