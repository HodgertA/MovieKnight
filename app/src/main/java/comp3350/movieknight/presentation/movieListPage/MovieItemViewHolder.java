package comp3350.movieknight.presentation.movieListPage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import comp3350.movieknight.R;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle;
    private ImageView moviePoster;
    private CardView movieCard;

    public MovieItemViewHolder(@NonNull View itemView) {
        super(itemView);

        movieTitle = itemView.findViewById(R.id.movie_title);
        moviePoster = itemView.findViewById(R.id.movie_poster);
        movieCard = itemView.findViewById(R.id.movie_card);
    }

    public TextView getMovieTitle() {
        return movieTitle;
    }

    public ImageView getMoviePoster() {
        return moviePoster;
    }

    public CardView getMovieCard() {
        return movieCard;
    }
}
