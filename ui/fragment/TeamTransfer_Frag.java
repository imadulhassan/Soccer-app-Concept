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
import com.soccer.adapter.PlayerStatAdapter;
import com.soccer.adapter.TransferAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.playerStat.PlayerStatictics;
import com.soccer.pojo.transfer.TransferResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.soccer.pojo.fixture.HomeTeam;
public class TeamTransfer_Frag extends Fragment {


    RecyclerView recyclerView;
    TransferAdapter adapter;
    ProgressBar bar;
    ImageView empty;
    AdView madAdView;
     HomeTeam item;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_transfer_team, container, false);
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
             item= (HomeTeam) getArguments().getSerializable("Obj");
             getRequest();

        }
        getRequest();
        return root;
    }


    void getRequest(){
       // item.getFixtureId()
        Call<TransferResponse> call = RetrofitClientt.getInstance().getApi().getTeamTransfer(item.getTeamId() +"");
        call.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getTransfers()!=null) {
                            if(response.body().getApi().getTransfers().size()>0) {
                                   Log.d("Response", "onResponse: Event " + response.body().toString());

                                    adapter = new TransferAdapter(getContext(), response.body().getApi().getTransfers());
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
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}