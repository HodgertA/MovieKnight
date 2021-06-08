package comp3350.movieknight.presentation.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.presentation.MovieItemViewHolder;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<MovieItemViewHolder>{

    private Context context;
    private ArrayList<Movie> movies;

    public MovieListRecyclerViewAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_item_card, parent, false);
        return new MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
        holder.getMovieTitle().setText(movies.get(position).getTitle());
        holder.getMovieCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the card is clicked, do stuff here
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
