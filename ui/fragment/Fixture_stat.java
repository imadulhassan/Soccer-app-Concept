package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.soccer.R;
import com.soccer.adapter.FixtureStatistAdapter;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixture.ResponseFixture;
import com.soccer.pojo.fixturestat.FixtureStat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fixture_stat extends Fragment {


      RecyclerView recyclerView;
      FixtureStatistAdapter adapter;
      FixturesItem fixturesItem;
      ProgressBar bar;
      TextView empty;
       AdView madAdView;

     public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.statistisc_fixture, container, false);
         madAdView= root.findViewById(R.id.adView);
         AdRequest adRequest = new AdRequest.Builder().build();

         madAdView.loadAd(adRequest);

        bar= root.findViewById(R.id.bar);
        empty= root.findViewById(R.id.image_empty);
        Sprite doubleBounce = new DoubleBounce();
        doubleBounce.setColor(getResources().getColor(R.color.bar));
        bar.setIndeterminateDrawable(doubleBounce);

        recyclerView= root.findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(getArguments()!=null){
           fixturesItem= (FixturesItem) getArguments().getSerializable("Obj");
            getRequest();

        }
        return root;
    }

    void getRequest(){
        Log.d("Response", "onResponse: " + fixturesItem.getFixtureId());

        Call<FixtureStat> call = RetrofitClientt.getInstance().getApi().getFixtureStatistics(fixturesItem.getFixtureId()+"");
        call.enqueue(new Callback<FixtureStat>() {
            @Override
            public void onResponse(Call<FixtureStat> call, Response<FixtureStat> response) {


                bar
                        .setVisibility(View.INVISIBLE);
                    if(response.body()!=null){

                        Log.d("Response Stat", "onResponse: " + response.body().toString());

                        if(response.body().getApi()!=null) {

                    Log.d("Response Stat", "onResponse: " + response.body().toString());

                    if(response.body().getApi().getStatistics()!=null ) {


                            adapter = new FixtureStatistAdapter(getContext(), response.body().getApi().getStatistics());
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                                }else{
                        Toast.makeText(getContext(), "No Value Found ", Toast.LENGTH_SHORT).show();
                        empty.setVisibility(View.VISIBLE);

                    }

                }
                else{
                    Toast.makeText(getContext(), "No Value Found ", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());
                            empty.setVisibility(View.VISIBLE);

                        }
                    }else{
                        Toast.makeText(getContext(), "No Value Found ", Toast.LENGTH_SHORT).show();
                        empty.setVisibility(View.VISIBLE);

                    }
            }

            @Override
            public void onFailure(Call<FixtureStat> call, Throwable t) {
                bar
                        .setVisibility(View.INVISIBLE);
                Log.d("Responce Stat" , "Error: "+t.toString());
                empty.setVisibility(View.VISIBLE);

            }
        });


    }


}