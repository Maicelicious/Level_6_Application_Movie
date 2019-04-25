package nl.hva.msi.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MovieRepo moviesRepository;
    MovieRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    private List<Movie> movieList;
    TextView yearView;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRepository = MovieRepo.getInstance();
        yearView = findViewById(R.id.inputYear);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = yearView.getText().toString();
                int release = Integer.parseInt(value);

                moviesRepository.getMovies(new GetCallback() {
                    @Override
                    public void onSuccess(List<Movie> movies) {
                        movieList = movies;
                        updateUI();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this, "Some Error happened. You may check your Internet Connection.", Toast.LENGTH_SHORT).show();
                    }
                }, release);
            }
        });


        recyclerView = findViewById(R.id.recyclerv_view);
        int numberOfColums = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColums));
        recyclerView.addOnItemTouchListener(new RecyclerTouchViewListener(this, recyclerView, new RecyclerTouchViewListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                Movie movie = movieList.get(position);
                intent.putExtra("movie", movie);
                startActivityForResult(intent, 1);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new MovieRecyclerViewAdapter(movieList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.swapList(movieList);
        }
    }
}
