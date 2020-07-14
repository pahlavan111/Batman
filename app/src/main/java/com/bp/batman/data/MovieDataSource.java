package com.bp.batman.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface MovieDataSource {

    Single<ResponseModel> getResponseModel(String movie_title, String api_key);

    Single<Movie> getMovieDetails(String imdbId, String api_key);

    Single<Long> saveMovie(Movie movie);


}
