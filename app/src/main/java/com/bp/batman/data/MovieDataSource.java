package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;

public interface MovieDataSource {
    Single<List<Movie>> getMovieList(String apiKey, String search);
}
