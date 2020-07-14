package com.bp.batman.data;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalDataSource implements MovieDataSource {

    private String DB_NAME = "db_name";
    private MovieDatabase movieDatabase;
    private Context context;

    public LocalDataSource(Context context) {

        this.context=context;

    }

    @Override
    public Single<ResponseModel> getResponseModel(String movie_title, String api_key) {
        return null;
    }

    @Override
    public Single<Movie> getMovieDetails(String imdbId, String api_key) {
        return null;
    }

    @Override
    public Single<Long> saveMovie(Movie movie) {
        movieDatabase = Room.databaseBuilder(context,MovieDatabase.class,DB_NAME).build();

            Single<Long> res=movieDatabase.movieDao().insertMovie(movie);

        return res;
    }


}
