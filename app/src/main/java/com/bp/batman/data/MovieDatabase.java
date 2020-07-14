package com.bp.batman.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class, Rating.class},version = 1,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
}
