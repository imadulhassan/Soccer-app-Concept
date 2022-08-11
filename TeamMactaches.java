package com.soccer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.ResponseFixture;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.pojo.searchpojo.TeamsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamMactaches extends AppCompatActivity {

    RecyclerView recyclerView;
    MatchesAdapter adapter;
    TeamsItem leaguesItem;
    TextView league;
    ImageView bkimage;
    ProgressBar bar;

    // List of MenuItems and native ads that populate the RecyclerView.
    private ArrayList<Object> mRecyclerViewItems = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_search);
        bkimage = findViewById(R.id.back_btn);
        league= findViewById(R.id.leauge_name);
        bar= findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);
        recyclerView= findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if(getIntent()!=null){
        leaguesItem = (TeamsItem) getIntent().getSerializableExtra("Obj");
           getRequest();

          league.setText(leaguesItem.getName());

        }
        bkimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }


    void getRequest() {

        //
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getFixtureFromteamid(leaguesItem.getTeamId()+"");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                bar.setVisibility(View.INVISIBLE);
                 if (response.isSuccessful()) {

                    Log.d("Response", "onResponse: " + response.body().toString());
                    if (response.body().getApi().getFixtures() != null)
                   mRecyclerViewItems.addAll(response.body().getApi().getFixtures());
loadmenu();


                } else {

                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {

                bar.setVisibility(View.INVISIBLE);
                Log.d("Responce", "Error: " + t.toString());

            }
        });
    }




    void loadmenu(){
        adapter = new MatchesAdapter(TeamMactaches.this, mRecyclerViewItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
