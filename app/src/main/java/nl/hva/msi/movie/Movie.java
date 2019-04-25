package nl.hva.msi.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;


    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("vote_average")
    @Expose
    private float rating;

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getPosterPath() {
        return posterPath;
    }


    public String getReleaseDate() {
        return releaseDate;
    }


    public float getRating() {
        return rating;
    }

    public String getBackdropPath(){
        return backdrop_path;
    }

    public String getOverview(){
        return overview;
    }
    public List<Integer> getGenreIds() {
        return genreIds;
    }
}
