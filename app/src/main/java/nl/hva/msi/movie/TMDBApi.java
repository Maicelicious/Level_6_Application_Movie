package nl.hva.msi.movie;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBApi {
    @GET("discover/movie")
    Call<MovieResponse> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("primary_release_year") int ReleaseYear,
            @Query("language") String language,
            @Query("page") int page
    );
}
