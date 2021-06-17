package comp3350.movieknight.presentation.movieListPage;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.presentation.movieDetailsPage.MovieDescriptionFragment;
import comp3350.movieknight.business.AccessMovies;

public class MovieListFragment extends Fragment {
    private static final int ITEMS_PER_ROW = 3;
    private Fragment childFragment;
    private Context context;
    private ArrayList<Movie> movies;
    private RecyclerView movieListRecyclerView;

    private AccessMovies accessMovies;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        context = requireContext();

        accessMovies = new AccessMovies();
        movies = new ArrayList<>();

        String result = accessMovies.getMoviesInTheatres(movies);
        if(result == null) {
            movieListRecyclerView = view.findViewById(R.id.movie_list_recycler_view);
            movieListRecyclerView.setLayoutManager(new GridLayoutManager(context, ITEMS_PER_ROW));
        }

        MovieListRecyclerViewAdapter adapter = new MovieListRecyclerViewAdapter(context,this, movies);
        movieListRecyclerView.setAdapter(adapter);

        return view;
    }

    public void openMovieDetailPage(Movie movie) {
        movieListRecyclerView.setVisibility(View.GONE);
        childFragment = new MovieDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putString("movieTitle",movie.getTitle());
        bundle.putInt("moviePoster",movie.getPoster());
        bundle.putString("movieDesc",movie.getDescription());
        bundle.putInt("movieId",movie.getMovieID());
        childFragment.setArguments(bundle);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();
    }

    //Remove child fragment (MovieDescriptionFragment) from stack of fragment to show parent fragment(MovieListFragment)
    public void finishMyChild(){
        movieListRecyclerView.setVisibility(View.VISIBLE);
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(childFragment);
        transaction.commit();
    }
}