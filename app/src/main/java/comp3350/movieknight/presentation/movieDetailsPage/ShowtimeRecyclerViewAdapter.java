package comp3350.movieknight.presentation.movieDetailsPage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.presentation.seatsPage.SeatsActivity;

public class ShowtimeRecyclerViewAdapter extends RecyclerView.Adapter<ShowtimeHolder> {

    private Context context;
    private ArrayList<Showing> showings;

    public ShowtimeRecyclerViewAdapter(Context context, ArrayList<Showing> showings){
        this.context = context;
        this.showings = showings;
    }

    @NonNull
    @Override
    public ShowtimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.show_time_card, parent, false);
        return new ShowtimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowtimeHolder holder, int position) {
        String showHour = String.valueOf(showings.get(position).getShowingHour());
        String showMinute = String.valueOf(showings.get(position).getShowingMinute());

        if (Integer.parseInt(showMinute) < 10) {
            showMinute = "0" + showMinute;
        }

        holder.getShowtime().setText(showHour + ":" + showMinute);
        holder.getShowtime().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetailsActivity.openSeatsPage(showings.get(position));
                Intent seatActivityIntent = new Intent(context, SeatsActivity.class);
                context.startActivity(seatActivityIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return showings.size();
    }
}
