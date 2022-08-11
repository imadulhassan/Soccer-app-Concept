package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixture.ResponseFixture;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FixtureMatches_Frag extends Fragment {


    RecyclerView home_recyler;
    MatchesAdapter home_adapter;
    RecyclerView away_recyle;
    MatchesAdapter away_adapter;

    RecyclerView h2h_recyle;
    MatchesAdapter h2h_adapter;

    LinearLayout home_layout , away_layout , h2h_layout;
    TextView awayheading , homeheading ;


    FixturesItem  item;
    private ArrayList<Object> mRecyclerViewItems = new ArrayList<>();
    private ArrayList<Object> mRecyclerViewItemsAway = new ArrayList<>();
    private ArrayList<Object> mRecyclerViewItemsH2h = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_matches_fixtue, container, false);
        home_recyler = root.findViewById(R.id.last_home_recyle);
        away_recyle= root.findViewById(R.id.last_away_recyle);
        h2h_recyle= root.findViewById(R.id.last_h2h_recyle);
        awayheading= root.findViewById(R.id.lastawaymatches);
        homeheading= root.findViewById(R.id.lasthomematches);
        if(getArguments()!=null){
            item= (FixturesItem) getArguments().getSerializable("Obj");
            awayheading.setText("Last 5 Matches of "+item.getAwayTeam().getTeamName());
            homeheading.setText("Last 5 Matches of "+item.getHomeTeam().getTeamName());

        }

        away_layout=root.findViewById(R.id.last_away__layout);
        home_layout=root.findViewById(R.id.last_home_layout);
        h2h_layout=root.findViewById(R.id.last_h2h__layout);


        away_recyle.setLayoutManager(new LinearLayoutManager(getContext()));
        home_recyler.setLayoutManager(new LinearLayoutManager(getContext()));
       h2h_recyle.setLayoutManager(new LinearLayoutManager(getContext()));
        getAwayRequest();
        getHomeRequest();
        getH2hRequest();

        away_layout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(away_recyle.getVisibility()==View.VISIBLE){
                   away_recyle.setVisibility(View.GONE);

               }else {
                   away_recyle.setVisibility(View.VISIBLE);
               }

           }
       });
        home_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(home_recyler.getVisibility()==View.VISIBLE){
                    home_recyler.setVisibility(View.GONE);

                }else {
                    home_recyler.setVisibility(View.VISIBLE);
                }

            }
        });
        h2h_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h2h_recyle.getVisibility()==View.VISIBLE){
                    h2h_recyle.setVisibility(View.GONE);

                }else {
                    h2h_recyle.setVisibility(View.VISIBLE);
                }


            }
        });




        return root;
    }


    void getHomeRequest(){
       // item.getFixtureId()
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getLastFixture(item.getHomeTeam().getTeamId()+"","5");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                   Log.d("Response", "onResponse: Event " + response.body().toString());


                                mRecyclerViewItems.addAll(response.body().getApi().getFixtures());
                                loadmenu();
                            }else{
                                Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();

                        }

                }
                else{
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure EVENt  Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }




    void getH2hRequest(){
        // item.getFixtureId()
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getFixtureH2h(item.getHomeTeam().getTeamId()+"",item.getAwayTeam().getTeamId()+"");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                Log.d("Response", "onResponse: Event " + response.body().toString());


                               mRecyclerViewItemsH2h.addAll(response.body().getApi().getFixtures());
                                loadh2hmenu();                            }else{
                                Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();

                        }

                }
                else{
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure EVENt  Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }



    void getAwayRequest(){
        // item.getFixtureId()
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getLastFixture(item.getAwayTeam().getTeamId()+"","5");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                Log.d("Response", "onResponse: Event " + response.body().toString());


                                mRecyclerViewItemsAway.addAll(response.body().getApi().getFixtures());
                                loadAwaymenu();
                            }else{
                                Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();

                        }

                }
                else{
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure EVENt  Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }




    void loadAwaymenu(){
        away_adapter = new MatchesAdapter(getContext(), mRecyclerViewItemsAway);
        away_recyle.setAdapter(away_adapter);
        away_adapter.notifyDataSetChanged();
    }



    void loadh2hmenu(){
        h2h_adapter = new MatchesAdapter(getContext(), mRecyclerViewItemsH2h);
        h2h_recyle.setAdapter(h2h_adapter);
        h2h_adapter.notifyDataSetChanged();
    }


    void loadmenu(){
        home_adapter = new MatchesAdapter(getContext(), mRecyclerViewItems);
        home_recyler.setAdapter(home_adapter);
        home_adapter.notifyDataSetChanged();
    }


}