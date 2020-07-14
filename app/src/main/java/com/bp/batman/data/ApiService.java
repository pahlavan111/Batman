package com.bp.batman.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/")
    Single<ResponseModel> getResponseModel(@Query("s")String movie_title, @Query("apikey")String api_key);

    @GET("/")
    Single<Movie> getMovieDetails(@Query("i")String imdbId, @Query("apikey")String api_key);

}
