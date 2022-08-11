package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.soccer.R;
import com.soccer.adapter.EventAdapter;
import com.soccer.adapter.PlayerStatAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.event.EventResponse;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.playerStat.PlayerStatictics;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerStatistics_Frag extends Fragment {


    RecyclerView recyclerView;
    PlayerStatAdapter adapter;
    FixturesItem  item;
    ProgressBar bar;
    ImageView empty;
    AdView madAdView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_player_stat, container, false);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        recyclerView= root.findViewById(R.id.player_stat_recyle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        bar= root.findViewById(R.id.bar);
        empty= root.findViewById(R.id.image_empty);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);

        if(getArguments()!=null){
             item= (FixturesItem) getArguments().getSerializable("Obj");
             getRequest();

        }
        return root;
    }


    void getRequest(){
       // item.getFixtureId()
        Call<PlayerStatictics> call = RetrofitClientt.getInstance().getApi().getFixturePlayerStatistics(item.getFixtureId()+"");
        call.enqueue(new Callback<PlayerStatictics>() {
            @Override
            public void onResponse(Call<PlayerStatictics> call, Response<PlayerStatictics> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getPlayers()!=null) {
                            if(response.body().getApi().getPlayers().size()>0) {
                                   Log.d("Response", "onResponse: Event " + response.body().toString());

                                    adapter = new PlayerStatAdapter(getContext(), response.body().getApi().getPlayers());
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();

                            }else{
                                Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                             empty.setVisibility(View.VISIBLE);
                            }
                        }else{
                            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                            empty.setVisibility(View.VISIBLE);

                        }

                }
                else{
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure EVENt  Fixture" + response.message());
                    empty.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<PlayerStatictics> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}