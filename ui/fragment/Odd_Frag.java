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
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.soccer.R;
import com.soccer.adapter.FixtureStatistAdapter;
import com.soccer.adapter.OddAdapterMain;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixturestat.FixtureStat;
import com.soccer.pojo.oddfix.OddResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Odd_Frag extends Fragment {


    RecyclerView recyclerView;
    OddAdapterMain adapter;
    FixturesItem  item;
    ProgressBar bar;
    ImageView empty;
    AdView madAdView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.odd_frag, container, false);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        recyclerView= root.findViewById(R.id.rv_matches);
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
        Call<OddResponce> call = RetrofitClientt.getInstance().getApi().getFixtureOdds(item.getFixtureId()+"");
        call.enqueue(new Callback<OddResponce>() {
            @Override
            public void onResponse(Call<OddResponce> call, Response<OddResponce> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: ODDD " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getOdds()!=null) {
                            if(response.body().getApi().getOdds().size()>0) {
                                if (response.body().getApi().getOdds().get(0).getBookmakers() != null) {
                                    Log.d("Response", "onResponse: ODDD " + response.body().toString());

                                    adapter = new OddAdapterMain(getContext(), response.body().getApi().getOdds().get(0).getBookmakers().get(0).getBets());
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
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
                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());
                    empty.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<OddResponce> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);

                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}