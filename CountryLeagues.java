package com.soccer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.soccer.adapter.CountryAdapter;
import com.soccer.adapter.LeaugeAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.countries.CountriesItem;
import com.soccer.pojo.countries.ResponseCountries;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.pojo.leauge.ResponseLeauge;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryLeagues extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaugeAdapter adapter;
    CountriesItem item;
    ImageView empty;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_leagues);

        recyclerView= findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        bar= findViewById(R.id.bar);
        empty= findViewById(R.id.image_empty);  Sprite doubleBounce = new DoubleBounce();
        doubleBounce.setColor(getResources().getColor(R.color.bar));
        bar.setIndeterminateDrawable(doubleBounce);
        if(getIntent()!=null) {
                item = (CountriesItem) getIntent().getSerializableExtra("Obj");
                if(item!=null) {
                    getRequest();
                }

        }


    }



    void getRequest(){

        Call<ResponseLeauge> call = RetrofitClientt.getInstance().getApi().getAvailavleLeaugesFromCountry(item.getCountry() +"");
        call.enqueue(new Callback<ResponseLeauge>() {
            @Override
            public void onResponse(Call<ResponseLeauge> call, Response<ResponseLeauge> response) {

                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "Countries: " + response.body().toString());
                    if(response.body().getApi().getLeagues()!=null)
                        adapter= new LeaugeAdapter(getApplicationContext(),response.body().getApi().getLeagues());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
                else{

                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());
                    empty.setVisibility(View.VISIBLE);
                }
            }



            @Override
            public void onFailure(Call<ResponseLeauge> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);

                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }
}
