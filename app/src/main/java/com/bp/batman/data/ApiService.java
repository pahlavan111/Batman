package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/")
    Single<ResponseMpdel> getMy(@Query("s")String movie_title, @Query("apikey")String api_key);

}
