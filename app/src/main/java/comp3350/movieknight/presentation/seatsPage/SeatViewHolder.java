package comp3350.movieknight.presentation.seatsPage;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class SeatViewHolder extends RecyclerView.ViewHolder {
    private ImageButton seatView;

    public SeatViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        seatView = itemView.findViewById(R.id.seatView);
    }

    public ImageButton getSeatView() {
        return seatView;
    }
}