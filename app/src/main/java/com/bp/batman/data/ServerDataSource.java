package com.bp.batman.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements MovieDataSource {

    public  static final String BASE_URL ="http://www.omdbapi.com";
    private ApiService apiService;

    public ServerDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService=retrofit.create(ApiService.class);
    }


    @Override
    public Single<ResponseModel> getResponseModel(String movie_title, String api_key) {
        return apiService.getResponseModel(movie_title,api_key);
    }

    @Override
    public Single<Movie> getMovieDetails(String imdbId, String api_key) {
        return apiService.getMovieDetails(imdbId,api_key);
    }

    @Override
    public Single<Long> saveMovie(Movie movie) {
        return null;
    }

}
