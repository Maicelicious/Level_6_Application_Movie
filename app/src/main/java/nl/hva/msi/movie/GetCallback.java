package nl.hva.msi.movie;

import java.util.List;

public interface GetCallback {
    void onSuccess(List<Movie> movies);

    void onError();
}
