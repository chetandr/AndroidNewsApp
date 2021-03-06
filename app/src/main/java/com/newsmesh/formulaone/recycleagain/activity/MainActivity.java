package com.newsmesh.formulaone.recycleagain.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.newsmesh.formulaone.recycleagain.apiclient.ApiClient;
import com.newsmesh.formulaone.recycleagain.apiclient.ApiInterface;
import com.newsmesh.formulaone.recycleagain.adapters.ChannelAdapter;
import com.newsmesh.formulaone.recycleagain.R;
import com.newsmesh.formulaone.recycleagain.model.Source;
import com.newsmesh.formulaone.recycleagain.model.Sources;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    public final static String API_KEY = "0ea0143e1a7c42b5a2c47cce7a956424";

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rv = (RecyclerView)findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Sources> call = apiService.getSources(API_KEY);
        call.enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(Call<Sources> call, Response<Sources> response) {
                Sources sources = response.body();
                List<Source> sourceList = new ArrayList<Source>();
                Log.d(TAG, "Source " + sources);
                if(sources != null) {
                     sourceList = sources.getSources();
                }

                ChannelAdapter adapter = new ChannelAdapter(sourceList);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Sources> call, Throwable t) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
