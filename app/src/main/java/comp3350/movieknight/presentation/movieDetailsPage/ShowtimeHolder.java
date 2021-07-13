package comp3350.movieknight.presentation.movieDetailsPage;

import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import comp3350.movieknight.R;

public class ShowtimeHolder extends RecyclerView.ViewHolder {

    private Button showtime;

    public ShowtimeHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        showtime = itemView.findViewById(R.id.show_time_button);
    }

    public Button getShowtime() {
        return showtime;
    }
}
