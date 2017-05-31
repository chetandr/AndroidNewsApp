package com.example.formulaone.recycleagain;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by chetan_rane on 5/30/2017.
 */

public interface ApiInterface {
    @GET("sources")
    Call<Sources> getSources(@Query("apiKey") String apiKey);
}
