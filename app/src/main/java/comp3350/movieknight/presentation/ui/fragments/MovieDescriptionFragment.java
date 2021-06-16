package comp3350.movieknight.presentation.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;

public class MovieDescriptionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "movieTitle";
    private static final String ARG_PARAM2 = "moviePoster";
    private static final String ARG_PARAM3 = "movieDesc";

    private String movieTitle;
    private int moviePoster;
    private String movieDesc;

    public MovieDescriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param movieTitle Parameter 1.
     * @param moviePoster Parameter 2.
     * @param movieDesc Parameter 3.
     * @return A new instance of fragment MovieDescriptionFragment.
     */
    public static MovieDescriptionFragment newInstance(String movieTitle, int moviePoster, String movieDesc) {
        MovieDescriptionFragment fragment = new MovieDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, movieTitle);
        args.putInt(ARG_PARAM2, moviePoster);
        args.putString(ARG_PARAM3, movieDesc);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_description, container, false);
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
}