package comp3350.movieknight.presentation.ticketPage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class TicketViewHolder extends RecyclerView.ViewHolder {
    private TextView moveTitle,theatreName,showingTime;



    public TicketViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        moveTitle=itemView.findViewById(R.id.ticket_movie_title);
        theatreName=itemView.findViewById(R.id.ticket_theatre_name);
        showingTime=itemView.findViewById(R.id.ticket_showing_time);

    }

    public TextView getMoveTitle(){
        return moveTitle;
    }

    public TextView getTheatreName(){
        return theatreName;
    }
    public TextView getShowingTime(){
        return showingTime;
    }
}
