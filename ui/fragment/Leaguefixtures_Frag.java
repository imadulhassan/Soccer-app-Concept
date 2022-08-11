package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.ResponseFixture;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.pojo.round.RoundResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Leaguefixtures_Frag extends Fragment {


    RecyclerView lastmatches;
    MatchesAdapter lastAdapter;
    RecyclerView nextMacthes;
    MatchesAdapter nextAdapter;
    RecyclerView roundMatches;
    MatchesAdapter roundAdapter;
    LinearLayout last_layout, nextLayout, roundLayout;


    LeaguesItem item;


    private ArrayList<Object> lastItems = new ArrayList<>();
    private ArrayList<Object> nextItems = new ArrayList<>();
    private ArrayList<Object> roundItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_matches_leagues, container, false);

        if(getArguments()!=null){
            item= (LeaguesItem) getArguments().getSerializable("Obj");

        }

        lastmatches = root.findViewById(R.id.last_home_recyle);
        nextMacthes = root.findViewById(R.id.last_away_recyle);
        roundMatches = root.findViewById(R.id.last_h2h_recyle);

        nextLayout =root.findViewById(R.id.league_next_layout);
        last_layout =root.findViewById(R.id.league_last_layout);
        roundLayout =root.findViewById(R.id.league_round_layout);

        nextMacthes.setLayoutManager(new LinearLayoutManager(getContext()));
        lastmatches.setLayoutManager(new LinearLayoutManager(getContext()));
        roundMatches.setLayoutManager(new LinearLayoutManager(getContext()));
        nextLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nextMacthes.getVisibility()==View.VISIBLE){
                    nextMacthes.setVisibility(View.GONE);

                }else{
                    nextMacthes.setVisibility(View.VISIBLE);

                }


            }
        });
        getNextFixtures();
        getLastFixture();

        last_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastmatches.getVisibility()==View.VISIBLE){
                    lastmatches.setVisibility(View.GONE);

                }else{
                    lastmatches.setVisibility(View.VISIBLE);

                }
            }
        });
        getRoundRequest();
        roundLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roundMatches.getVisibility()==View.VISIBLE){
                    roundMatches.setVisibility(View.GONE);

                }else {
                    roundMatches.setVisibility(View.VISIBLE);
                }
            }
        });




        return root;
    }




    void getRoundRequest() {

        // item.getFixtureId()
        Call<RoundResponse> call = RetrofitClientt.getInstance().getApi().getCurrentRound(item.getLeagueId() + "");
        call.enqueue(new Callback<RoundResponse>() {
            @Override
            public void onResponse(Call<RoundResponse> call, Response<RoundResponse> response) {
                if (response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if (response.body().getApi().getResults() != 0)
                        if (response.body().getApi().getFixtures() != null) {
                            if (response.body().getApi().getFixtures().size() > 0) {
                                Log.d("Response", "onResponse: Round " + response.body().toString());
                                    getRoundFixtures(response.body().getApi().getFixtures().get(0));

                                    } else {
                                Toast.makeText(getContext(), "No RoundFound", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "No Round Found", Toast.LENGTH_SHORT).show();

                        }

                } else {
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "onResponse: Faliure EVENt  Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<RoundResponse> call, Throwable t) {

            }
        });
    }

            void getLastFixture(){
        // item.getFixtureId()
                lastItems.clear();
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getLastFixtureFromLeague(item.getLeagueId()+"","5");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                Log.d("Response", "onResponse: Event " + response.body().toString());


                                lastItems.addAll(response.body().getApi().getFixtures());
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




    void getRoundFixtures(String round){
        // item.getFixtureId()
        roundItems.clear();
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getRoundFixtureFromLeague(item.getLeagueId()+"",round);
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                Log.d("Response", "onResponse: Event " + response.body().toString());


                                roundItems.addAll(response.body().getApi().getFixtures());
                                RoundItem();                            }else{
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



    void getNextFixtures(){
        // item.getFixtureId()
        nextItems.clear();
        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getNextFixtureFromLeague(item.getLeagueId()+"","5");
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getFixtures()!=null) {
                            if(response.body().getApi().getFixtures().size()>0) {
                                Log.d("Response", "onResponse: Event " + response.body().toString());


                                nextItems.addAll(response.body().getApi().getFixtures());
                                lloadNextMenu();
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




    void lloadNextMenu(){
        nextAdapter = new MatchesAdapter(getContext(), nextItems);
        nextMacthes.setAdapter(nextAdapter);
        nextAdapter.notifyDataSetChanged();
    }



    void RoundItem(){
        roundAdapter = new MatchesAdapter(getContext(), roundItems);
        roundMatches.setAdapter(roundAdapter);
        roundAdapter.notifyDataSetChanged();
    }


    void loadmenu(){
        lastAdapter = new MatchesAdapter(getContext(), lastItems);
        lastmatches.setAdapter(lastAdapter);
        lastAdapter.notifyDataSetChanged();
    }





}