package comp3350.movieknight.presentation.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.presentation.adapters.MovieListRecyclerViewAdapter;

public class MovieListFragment extends Fragment {

    private static final int GRID_PER_ROW = 3;

    private Context context;
    private ArrayList<Movie> movies;
    private RecyclerView movieListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        context = requireContext();
        movies = new ArrayList<>();

        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://nerdreactor.com/wp-content/uploads/2019/04/20190402_090648.jpg", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123", "https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png","A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));
        movies.add(new Movie("123","https://upload.wikimedia.org/wikipedia/en/e/e8/The_Conjuring_-_The_Devil_Made_Me_Do_It.png", "A movie about a bee", "The Bee Movie", 95, 0, 0));

        movieListRecyclerView = view.findViewById(R.id.movie_list_recycler_view);
        MovieListRecyclerViewAdapter adapter = new MovieListRecyclerViewAdapter(context,this, movies);
        movieListRecyclerView.setLayoutManager(new GridLayoutManager(context, GRID_PER_ROW));
        movieListRecyclerView.setAdapter(adapter);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        movieListRecyclerView.setVisibility(View.VISIBLE);
    }

    public void openMovieDetailPage(Movie movie) {
        movieListRecyclerView.setVisibility(View.GONE);
        Fragment childFragment = new MovieDescriptionFragment();
        Bundle bundle=new Bundle();
        bundle.putString("movieTitle",movie.getTitle());
        bundle.putString("moviePoster",movie.getPoster());
        bundle.putString("movieDesc",movie.getDescription());
        childFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();

    }


}