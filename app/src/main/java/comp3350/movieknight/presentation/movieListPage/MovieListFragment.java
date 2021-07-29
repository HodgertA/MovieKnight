package comp3350.movieknight.presentation.movieListPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.business.AccessMovies;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDetailsActivity;

public class MovieListFragment extends Fragment {
    private static final int ITEMS_PER_ROW = 2;
    private int userID;
    private Context context;
    private ArrayList<Movie> movies;
    private RecyclerView movieListRecyclerView;
    private static Bundle chosenMovie;

    private AccessMovies accessMovies;

    public MovieListFragment(int userID){
        this.userID = userID;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        context = requireContext();

        accessMovies = new AccessMovies();
        movies = new ArrayList<>();

        String result = accessMovies.getMoviesInTheatres(movies);
        if (result == null) {
            movieListRecyclerView = view.findViewById(R.id.movie_list_recycler_view);
            movieListRecyclerView.setLayoutManager(new GridLayoutManager(context, ITEMS_PER_ROW));
        }

        MovieListRecyclerViewAdapter adapter = new MovieListRecyclerViewAdapter(context, this, movies);
        movieListRecyclerView.setAdapter(adapter);

        return view;
    }

    public void openMovieDetailPage(Movie movie) {
        Bundle bundle = new Bundle();
        bundle.putString("movieTitle",movie.getTitle());
        bundle.putInt("moviePoster", getResources().getIdentifier(movie.getPoster() , "drawable", getActivity().getPackageName()));
        bundle.putString("movieDesc",movie.getDescription());
        bundle.putInt("movieId",movie.getMovieID());
        bundle.putInt("userId",userID);
        chosenMovie = bundle;

        Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
        movieDetailsIntent.putExtras(bundle);
        context.startActivity(movieDetailsIntent);
    }

    public static Bundle getChosenMovie() {
        return chosenMovie;
    }
}