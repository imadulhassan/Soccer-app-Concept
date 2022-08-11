package com.soccer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.ResponseFixture;
import com.soccer.pojo.leauge.LeaguesItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueMatches extends AppCompatActivity {

    RecyclerView recyclerView;
    MatchesAdapter adapter;
    LeaguesItem leaguesItem;
    TextView league;
    ImageView bkimage;
    ProgressBar bar;
    public static final int NUMBER_OF_ADS = 3;

    // The AdLoader used to load ads.
    private AdLoader adLoader;

    // List of MenuItems and native ads that populate the RecyclerView.
    private ArrayList<Object> mRecyclerViewItems = new ArrayList<>();

    // List of native ads that have been successfully loaded.
    private ArrayList<UnifiedNativeAd> mNativeAds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_matches);
        bkimage = findViewById(R.id.back_btn);
        league= findViewById(R.id.leauge_name);
        bar= findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);
        recyclerView= findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if(getIntent()!=null){
        leaguesItem = (LeaguesItem) getIntent().getSerializableExtra("Obj");
           getRequest();
           loadNativeAds();
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

        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getLeagueMatches(leaguesItem.getLeagueId()+"");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                bar.setVisibility(View.INVISIBLE);
                 if (response.isSuccessful()) {

                    Log.d("Response", "onResponse: " + response.body().toString());
                    if (response.body().getApi().getFixtures() != null)
                        mRecyclerViewItems.addAll(response.body().getApi().getFixtures());


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



    private void loadNativeAds() {

        AdLoader.Builder builder = new AdLoader.Builder(this, getResources().getString(R.string.nativebnn));
        adLoader = builder.forUnifiedNativeAd(
                new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        // A native ad loaded successfully, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        mNativeAds.add(unifiedNativeAd);
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).withAdListener(
                new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // A native ad failed to load, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        Log.e("MainActivity", "The previous native ad failed to load. Attempting to"
                                + " load another.");
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).build();

        // Load the Native ads.
        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
    }





    private void insertAdsInMenuItems() {
        if (mNativeAds.size() <= 0) {
            return;
        }

        int offset = (mRecyclerViewItems.size() / mNativeAds.size()) + 1;
        int index = 0;
        for (UnifiedNativeAd ad : mNativeAds) {
            mRecyclerViewItems.add(index, ad);
            index = index + offset;
        }
        loadmenu();

    }


    void loadmenu(){
        adapter = new MatchesAdapter(getApplicationContext(), mRecyclerViewItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
