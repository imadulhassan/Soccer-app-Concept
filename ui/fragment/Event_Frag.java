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
import com.soccer.adapter.OddAdapterMain;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.event.EventResponse;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.oddfix.OddResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Event_Frag extends Fragment {


    RecyclerView recyclerView;
    EventAdapter adapter;
    FixturesItem  item;
    ProgressBar bar;
    ImageView empty;
    AdView madAdView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_events, container, false);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        recyclerView= root.findViewById(R.id.event_recyle);
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
        Call<EventResponse> call = RetrofitClientt.getInstance().getApi().getFixtureEvent(item.getFixtureId()+"");
        call.enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getEvents()!=null) {
                            if(response.body().getApi().getEvents().size()>0) {
                                   Log.d("Response", "onResponse: Event " + response.body().toString());

                                    adapter = new EventAdapter(getContext(), response.body().getApi().getEvents());
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
            public void onFailure(Call<EventResponse> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}