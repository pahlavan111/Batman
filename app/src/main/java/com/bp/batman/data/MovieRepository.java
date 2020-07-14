package com.bp.batman.data;

import android.content.Context;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class MovieRepository implements MovieDataSource {

    ServerDataSource serverDataSource;
    LocalDataSource localDataSource;

    public MovieRepository(Context context) {
        localDataSource= new LocalDataSource(context);
        serverDataSource=new ServerDataSource();
    }




    @Override
    public Single<ResponseModel> getResponseModel(String movie_title, String api_key) {
        return serverDataSource.getResponseModel(movie_title,api_key);
    }

    @Override
    public Single<Movie> getMovieDetails(String imdbId, String api_key) {
        return serverDataSource.getMovieDetails(imdbId,api_key);
    }

    @Override
    public Single<Long> saveMovie(Movie movie) {
        return localDataSource.saveMovie(movie);
    }

}
