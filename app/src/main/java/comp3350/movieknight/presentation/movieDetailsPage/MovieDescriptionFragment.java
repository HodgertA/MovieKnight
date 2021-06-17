package comp3350.movieknight.presentation.movieDetailsPage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Movie;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.business.AccessShowing;
import comp3350.movieknight.presentation.movieListPage.MovieListFragment;
import comp3350.movieknight.presentation.movieListPage.MovieListRecyclerViewAdapter;

public class MovieDescriptionFragment extends Fragment {

    private static final String ARG_PARAM1 = "movieTitle";
    private static final String ARG_PARAM2 = "moviePoster";
    private static final String ARG_PARAM3 = "movieDesc";
    private static final String ARG_PARAM4 = "movieId";

    private String movieTitle;
    private int moviePoster;
    private String movieDesc;
    private int movieId;


    private AccessShowing accessShowing;
    private ArrayList<Showing> showings;
    private RecyclerView showingTimeRecyclerView;
    private Context context;
    private Fragment childFragment;

    public MovieDescriptionFragment() {
    }

    public static MovieDescriptionFragment newInstance(String movieTitle, int moviePoster, String movieDesc,int movieId) {
        MovieDescriptionFragment fragment = new MovieDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, movieTitle);
        args.putInt(ARG_PARAM2, moviePoster);
        args.putString(ARG_PARAM3, movieDesc);
        args.putInt(ARG_PARAM4,movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieTitle = getArguments().getString(ARG_PARAM1);
            moviePoster = getArguments().getInt(ARG_PARAM2);
            movieDesc = getArguments().getString(ARG_PARAM3);
            movieId=getArguments().getInt(ARG_PARAM4);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_movie_description, container, false);
        context = requireContext();


        accessShowing=new AccessShowing();

        showings =new ArrayList<>();
        String result = accessShowing.getShowingForMovie(showings,movieId);


        if(result == null) {
            showingTimeRecyclerView= view.findViewById(R.id.show_time_recycler_view);
            showingTimeRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        }

        ShowtimeRecyclerViewAdapter adapter = new ShowtimeRecyclerViewAdapter(context,this, showings);
        showingTimeRecyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //for displaying back arrow
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);

        TextView textViewMovieTitle = view.findViewById(R.id.textViewMovieTitle);
        ImageView imageViewMovieImage = view.findViewById(R.id.imageViewMovieImage);
        TextView textViewMovieDesc = view.findViewById(R.id.textViewMovieDesc);

        textViewMovieTitle.setText(movieTitle);
        textViewMovieDesc.setText(movieDesc);
        imageViewMovieImage.setImageResource(moviePoster);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            Fragment fragment = MovieDescriptionFragment.this.getParentFragment(); // getParentFragment() is a built-in method in Android, this method can return a fragment
            MovieListFragment frag = (MovieListFragment) fragment; // Note that this type conversion must be performed to make the fragment generic into a specific parent fragment
            frag.finishMyChild();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }

    public void openSeatsPage(Showing showing) {
        showingTimeRecyclerView.setVisibility(View.GONE);
        childFragment = new MovieDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("showingId",showing.getShowingID());
        childFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.movie_description_fragment_container, childFragment).commit();
    }

    //Remove child fragment (MovieDescriptionFragment) from stack of fragment to show parent fragment(MovieListFragment)
    public void finishMyChild(){
        showingTimeRecyclerView.setVisibility(View.VISIBLE);
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(childFragment);
        transaction.commit();
    }
}