package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET()
    Single<List<Movie>> getMovieList(@Query("apikey") String apiKey,@Query("s") String search);
}
