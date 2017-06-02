package com.newsmeshinstant.formulaone.recycleagain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.newsmeshinstant.formulaone.recycleagain.R;
import com.newsmeshinstant.formulaone.recycleagain.adapters.ArticleAdapter;
import com.newsmeshinstant.formulaone.recycleagain.adapters.ChannelAdapter;
import com.newsmeshinstant.formulaone.recycleagain.apiclient.ApiClient;
import com.newsmeshinstant.formulaone.recycleagain.apiclient.ApiInterface;
import com.newsmeshinstant.formulaone.recycleagain.model.Article;
import com.newsmeshinstant.formulaone.recycleagain.model.Articles;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.LinearLayout.HORIZONTAL;
import static android.widget.LinearLayout.VERTICAL;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String mChannel = intent.getStringExtra(ChannelAdapter.ChannelViewHolder.SOURCE_CHANNEL);

        final RecyclerView articleView = (RecyclerView) findViewById(R.id.articleView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(VERTICAL);
        articleView.setLayoutManager(llm);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(articleView);

        ApiInterface apiClient = ApiClient.getClient().create(ApiInterface.class);

        Call<Articles> call = apiClient.getArticles(mChannel, MainActivity.API_KEY);

        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                Articles articles = response.body();
                List<Article> articleList = new ArrayList<Article>();

                if(articles != null) {
                    articleList = articles.getArticles();
                }
                ArticleAdapter articleAdapter = new ArticleAdapter(articleList);
                articleView.setAdapter(articleAdapter);
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {

            }
        });
    }

}
