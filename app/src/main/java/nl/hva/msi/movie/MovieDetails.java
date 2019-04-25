package nl.hva.msi.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class MovieDetails extends AppCompatActivity implements Serializable {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    ImageView topImage;
    ImageView coverImage;
    TextView title;
    TextView overview;
    TextView rating;
    TextView release;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        topImage = findViewById(R.id.top_image);
        coverImage = findViewById(R.id.cover_image);
        title = findViewById(R.id.title);
        overview = findViewById(R.id.overview);
        rating = findViewById(R.id.rating);
        release = findViewById(R.id.release);

        Intent intent = getIntent();
        final Movie movie = (Movie) intent.getSerializableExtra("movie");

        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
        rating.setText(String.valueOf(movie.getRating()));
        release.setText(movie.getReleaseDate());

        String TopImageUrl = IMAGE_BASE_URL + movie.getBackdropPath();
        String coverUrl = IMAGE_BASE_URL + movie.getPosterPath();

        Glide.with(topImage).load(TopImageUrl).into(topImage);
        Glide.with(coverImage).load(coverUrl).into(coverImage);

        overview.setMovementMethod(new ScrollingMovementMethod());
    }
}
