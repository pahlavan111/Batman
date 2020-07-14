package com.bp.batman.data;

import io.reactivex.Single;

public interface MovieDataSource {

    Single<ResponseModel> getResponseModel(String movie_title, String api_key);

    Single<Movie> getMovieDetails(String imdbId, String api_key);


}
