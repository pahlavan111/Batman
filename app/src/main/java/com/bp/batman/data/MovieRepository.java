package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;

public class MovieRepository implements MovieDataSource {

    ServerDataSource serverDataSource;

    public MovieRepository(ServerDataSource serverDataSource) {
        this.serverDataSource = serverDataSource;
    }

    @Override
    public Single<List<Movie>> getMovieList(String apiKey, String search) {
        return serverDataSource.getMovieList(apiKey,search);
    }
}
