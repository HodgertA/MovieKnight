package comp3350.movieknight.presentation.movieDetailsPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Showing;

public class ShowtimeRecyclerViewAdapter extends RecyclerView.Adapter<ShowtimeHolder>{

    private Context context;
    private ArrayList<Showing> showings;
    private MovieDescriptionFragment movieDescriptionFragment;
    public ShowtimeRecyclerViewAdapter(Context context, MovieDescriptionFragment movieDescriptionFragment, ArrayList<Showing> showings){
        this.context=context;
        this.showings=showings;
        this.movieDescriptionFragment = movieDescriptionFragment;

    }
//

    @NonNull
    @Override
    public ShowtimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.show_time_card, parent, false);
        return new ShowtimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowtimeHolder holder, int position) {
        String showtime=String.valueOf(showings.get(position).getShowingTime());

        String time[]=showtime.split("\\.");

        holder.getShowtime().setText( time[0] + ":" + time[1]);

//        holder.getMovieTitle().setText(movies.get(position).getTitle());
//        holder.getMoviePoster().setImageResource(movies.get(position).getPoster());
//        holder.getMovieCard().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //when the card is clicked, do stuff here
//                movieListFragment.openMovieDetailPage(movies.get(position));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return showings.size();
    }
}
