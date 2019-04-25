package nl.hva.msi.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    private List<Movie> mData;

    public MovieRecyclerViewAdapter(List<Movie> data) {
        this.mData = data;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView numberTextView;
        LinearLayout parentLayout;
        ImageView movieImage;

        ViewHolder(View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movieImageView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            parentLayout = itemView.findViewById(R.id.parentalLayout);
            parentLayout.setClickable(true);

        }

        void bind(Movie movie, int position) {

            numberTextView.setText(String.valueOf(position + 1) + ".");
            String url = IMAGE_BASE_URL + movie.getPosterPath();
            Glide.with(itemView).load(url).into(movieImage);
        }

    }

    @NonNull
    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(mData.get(i), i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void swapList(List<Movie> newList) {
        mData = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

}
