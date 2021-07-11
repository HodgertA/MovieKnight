package comp3350.movieknight.presentation.ticketPage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class TicketViewHolder extends RecyclerView.ViewHolder {
    private TextView moveTitle,ticketDate,showingTime;



    public TicketViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        moveTitle=itemView.findViewById(R.id.ticket_movie_title);
        ticketDate=itemView.findViewById(R.id.ticket_date);
        showingTime=itemView.findViewById(R.id.ticket_showing_time);

    }

    public TextView getMoveTitle(){
        return moveTitle;
    }

    public TextView getTicketDate(){
        return ticketDate;
    }
    public TextView getShowingTime(){
        return showingTime;
    }
}