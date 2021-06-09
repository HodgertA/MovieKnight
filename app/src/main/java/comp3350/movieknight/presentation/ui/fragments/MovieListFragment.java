package comp3350.movieknight.presentation.ui.fragments;

import android.content.Context;
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
import comp3350.movieknight.presentation.adapters.MovieListRecyclerViewAdapter;
import comp3350.movieknight.business.AccessMovies;

public class MovieListFragment extends Fragment {
    private static final int GRID_PER_ROW = 3;

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

        //movies = new ArrayList<>();

//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));
//        movies.add(new Movie("123", "A movie about a bee", "The Bee Movie", 95, 0, 0));

        movieListRecyclerView = view.findViewById(R.id.movie_list_recycler_view);
        MovieListRecyclerViewAdapter adapter = new MovieListRecyclerViewAdapter(context, movies);
        movieListRecyclerView.setLayoutManager(new GridLayoutManager(context, GRID_PER_ROW));
        movieListRecyclerView.setAdapter(adapter);
        return view;
    }

}