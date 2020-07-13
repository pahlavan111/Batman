package com.bp.batman.data;

import io.reactivex.Single;

public class MovieRepository implements MovieDataSource {

    ServerDataSource serverDataSource;

    public MovieRepository() {
        serverDataSource=new ServerDataSource();
    }


    @Override
    public Single<ResponseMpdel> getMyList(String movie_title, String api_key) {
        return serverDataSource.getMyList(movie_title,api_key);
    }

    @Override
    public Single<Movie> getMovieDetails(String imdbId, String api_key) {
        return serverDataSource.getMovieDetails(imdbId,api_key);
    }
}
