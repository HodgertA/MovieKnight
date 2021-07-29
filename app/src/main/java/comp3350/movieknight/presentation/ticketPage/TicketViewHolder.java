package comp3350.movieknight.presentation.ticketPage;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class TicketViewHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle, ticketDate, showingTime;
    private Button tickeButton;

    public TicketViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        movieTitle = itemView.findViewById(R.id.ticket_movie_title);
        ticketDate = itemView.findViewById(R.id.ticket_date);
        showingTime = itemView.findViewById(R.id.ticket_showing_time);
        tickeButton = itemView.findViewById(R.id.send_tickets_button);
    }

    public TextView getMovieTitle(){
        return movieTitle;
    }

    public TextView getTicketDate(){
        return ticketDate;
    }

    public TextView getShowingTime(){
        return showingTime;
    }

    public Button getTickeButton() { return tickeButton; }
}
