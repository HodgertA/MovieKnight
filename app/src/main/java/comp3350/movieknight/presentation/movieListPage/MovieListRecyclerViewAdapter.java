package comp3350.movieknight.presentation.movieListPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;
    private MovieListFragment movieListFragment;

    public MovieListRecyclerViewAdapter(Context context, MovieListFragment movieListFragment, ArrayList<Movie> movies) {
        this.movieListFragment = movieListFragment;
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
        holder.getMoviePoster().setImageResource(context.getResources().getIdentifier(movies.get(position).getPoster() , "drawable", context.getPackageName()));
        holder.getMovieCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieListFragment.openMovieDetailPage(movies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
