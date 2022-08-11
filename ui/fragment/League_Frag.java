package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.soccer.R;
import com.soccer.adapter.CountryAdapter;
import com.soccer.adapter.LeaugeAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.countries.ResponseCountries;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.leauge.ResponseLeauge;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class League_Frag extends Fragment {


    RecyclerView recyclerView;
    CountryAdapter adapter;

    FixturesItem item;
    ImageView empty;
    ProgressBar bar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_league, container, false);
        recyclerView= root.findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
               bar= root.findViewById(R.id.bar);
        empty= root.findViewById(R.id.image_empty);  Sprite doubleBounce = new DoubleBounce();
        doubleBounce.setColor(getResources().getColor(R.color.bar));
        bar.setIndeterminateDrawable(doubleBounce);

        getRequest();

        return root;
    }


    void getRequest(){

        Call<ResponseCountries> call = RetrofitClientt.getInstance().getApi().getAvailableCounries();
        call.enqueue(new Callback<ResponseCountries>() {
            @Override
            public void onResponse(Call<ResponseCountries> call, Response<ResponseCountries> response) {

                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "Countries: " + response.body().toString());
                    if(response.body().getApi().getCountries()!=null)
                    adapter= new CountryAdapter(getContext(),response.body().getApi().getCountries());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
                else{

                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());
        empty.setVisibility(View.VISIBLE);
                }
            }



            @Override
            public void onFailure(Call<ResponseCountries> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);

                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }


}