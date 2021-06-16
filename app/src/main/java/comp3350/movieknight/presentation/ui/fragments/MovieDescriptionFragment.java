package comp3350.movieknight.presentation.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import comp3350.movieknight.R;


public class MovieDescriptionFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

        String title = getArguments().getString("movieTitle");
        String poster = getArguments().getString("moviePoster");
        String description = getArguments().getString("movieDesc");

        textViewMovieTitle.setText(title);
        textViewMovieDesc.setText(description);
        Glide.with(this).load(poster).into(imageViewMovieImage);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            Fragment fragment = MovieDescriptionFragment.this.getParentFragment(); // getParentFragment() is a built-in method in Android, this method can return a fragment
            MovieListFragment frag = (MovieListFragment) fragment; // Note that this type conversion must be performed to make the fragment generic into a specific parent fragment
            frag.finishMyChild();

            Toast.makeText(getActivity(), "OnBAckPressed Works", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}