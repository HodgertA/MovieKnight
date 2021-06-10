package comp3350.movieknight.presentation.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
}