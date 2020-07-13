package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;

public class MovieRepository implements MovieDataSource {

    ServerDataSource serverDataSource;

    public MovieRepository() {
        serverDataSource=new ServerDataSource();
    }


    @Override
    public Single<ResponseMpdel> getMy(String movie_title, String api_key) {
        return serverDataSource.getMy(movie_title,api_key);
    }
}
