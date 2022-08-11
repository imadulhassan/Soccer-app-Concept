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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.soccer.R;
import com.soccer.adapter.PlayerStatAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixture.HomeTeam;
import com.soccer.pojo.playerStat.PlayerStatictics;
import com.soccer.pojo.teamstat.Statistics;
import com.soccer.pojo.teamstat.TeamStat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamStatistics_Frag extends Fragment {


    HomeTeam item;
    ProgressBar bar;
    ImageView empty;
    AdView madAdView;
    TextView  mp , win,draw ,lose , gf , ga , gfa  , gaa;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_stat_team, container, false);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        bar= root.findViewById(R.id.bar);
        empty= root.findViewById(R.id.image_empty);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);
        init(root);

        //
        if(getArguments()!=null){
             item= (HomeTeam) getArguments().getSerializable("Obj");
             getRequest();

        }

        return root;
    }

    void init(View view){
        mp =view.findViewById(R.id.teamgoal_mp);
        win =view.findViewById(R.id.teamgoal_win);
        lose=view.findViewById(R.id.teamgoal_lose);
        draw=view.findViewById(R.id.teamgoal_draw);
        gf =view.findViewById(R.id.teamgoal_gf);
        gfa =view.findViewById(R.id.teamgoal_gfa);
        gaa =view.findViewById(R.id.teamgoal_gaa);
        ga =view.findViewById(R.id.teamgoal_ga);

    }


    void getRequest(){
       // item.getFixtureId()
        Call<TeamStat> call = RetrofitClientt.getInstance().getApi().getTeamStatistics(item.getTeamId()+"",item.getLeague_id());
        call.enqueue(new Callback<TeamStat>() {
            @Override
            public void onResponse(Call<TeamStat> call, Response<TeamStat> response) {
                bar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if (response.body().getApi().getResults() != 0)
                        if (response.body().getApi().getStatistics() != null) {


                            Statistics statistics= response.body().getApi().getStatistics();

                            mp.setText(statistics.getMatchs().getMatchsPlayed().getTotal()+"");
                            win.setText(statistics.getMatchs().getWins().getTotal()+"");
                            lose.setText(statistics.getMatchs().getLoses().getTotal()+"");
                            draw.setText(statistics.getMatchs().getDraws().getTotal()+"");

                            gf.setText(statistics.getGoals().getGoalsFor().getTotal()+"");
                            gfa.setText(statistics.getGoalsAvg().getGoalsFor().getTotal()+"");
                            ga.setText(statistics.getGoals().getGoalsAgainst().getTotal()+"");
                            gaa.setText(statistics.getGoalsAvg().getGoalsAgainst().getTotal()+"");


                        } else {
                            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                            empty.setVisibility(View.VISIBLE);
                        }
                } else {
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    empty.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onFailure(Call<TeamStat> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}