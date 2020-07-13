package com.bp.batman.data;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataSource {

    Single<ResponseMpdel> getMy(String movie_title, String api_key);

}
