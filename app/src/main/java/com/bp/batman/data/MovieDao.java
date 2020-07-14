package com.bp.batman.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Insert
    Single<Long> insertMovie(Movie movie);

    @Update
    Single<Integer> updateMovie(Movie movie);


    @Query(" SELECT * FROM movie ORDER BY id ")
    Single<List<Movie>> getMovieList();

}
