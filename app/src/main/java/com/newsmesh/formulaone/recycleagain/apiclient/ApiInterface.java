package com.newsmesh.formulaone.recycleagain.apiclient;


import com.newsmesh.formulaone.recycleagain.model.Article;
import com.newsmesh.formulaone.recycleagain.model.Articles;
import com.newsmesh.formulaone.recycleagain.model.Sources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by chetan_rane on 5/30/2017.
 */

public interface ApiInterface {
    @GET("sources")
    Call<Sources> getSources(@Query("apiKey") String apiKey);

    @GET("articles")
    Call<Articles> getArticles(@Query("source") String source, @Query("apiKey") String apiKey);
}
