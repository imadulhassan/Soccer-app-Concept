package com.soccer.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.soccer.adapter.OddAdapterMain;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.oddfix.OddResponce;
import com.soccer.pojo.prediction.Away;
import com.soccer.pojo.prediction.Comparison;
import com.soccer.pojo.prediction.Home;
import com.soccer.pojo.prediction.PredictionResponce;
import com.soccer.pojo.prediction.PredictionsItem;
import com.soccer.pojo.prediction.Teams;
import com.soccer.pojo.teamstat.Statistics;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Prediction_Frag extends Fragment {


    FixturesItem  item;
    ProgressBar bar;

    LinearLayout  heading ;
    TextView   matchplayed,uderover , goal_home , goal_away,
    advice ,  win_hompprect, win_awayprect, win_drawprect,
       detail_home,detail_away ,detail_home_mp , detail_home_mdraw,detail_home_mwin,detail_home_mlose,
    detail_away_mp , detail_away_mwin, detail_away_mlose ,detail_away_mdraw,
    detail_away_gfor , detail_away_gagainst , detail_away_gforavg ,detail_away_gagainst_avg
        ,detail_home_gfor,detail_home_gaginst, detail_home_gforavg, detail_home_gagaints_avg,
       frome_home ,frome_away,att_home,att_away,
            def_home , def_away, fishlaw_home , fishlaw_away,
           h2h_home, h2h_away , goalh2h_home , goalh2h_away;


 ImageView empty ;
 AdView madAdView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_prediction, container, false);
        bar= root.findViewById(R.id.bar);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));
        init(root);
        bar.setIndeterminateDrawable(doubleBounce);
        empty= root.findViewById(R.id.image_empty);
        if(getArguments()!=null){
             item= (FixturesItem) getArguments().getSerializable("Obj");
             getRequest();

        }
        return root;
    }

    void init(View  itemView){


    heading = itemView.findViewById(R.id.heading);

// Match Details

        detail_away =       itemView.findViewById(R.id.detail_awayteam);
        detail_away_mp =       itemView.findViewById(R.id.tv_detail_awayteam_mp);
        detail_away_mwin =       itemView.findViewById(R.id.tv_detail_awayteam_mwin);
        detail_away_mlose =       itemView.findViewById(R.id.tv_detail_awayteam_mlose);
        detail_away_mdraw =       itemView.findViewById(R.id.tv_detail_awayteam_mdraw);
        detail_away_gfor =       itemView.findViewById(R.id.tv_detail_awayteam_gf);
        detail_away_gforavg =       itemView.findViewById(R.id.tv_detail_awayteam_gfavg);
        detail_away_gagainst_avg =       itemView.findViewById(R.id.tv_detail_awayteam_gaavg);
        detail_away_gagainst =       itemView.findViewById(R.id.tv_detail_awayteam_ga);


        detail_home =       itemView.findViewById(R.id.detail_home);
        detail_home_mp =       itemView.findViewById(R.id.tv_pred_hometeam_mp);
        detail_home_mwin =       itemView.findViewById(R.id.tv_pred_hometeam_mwin);
        detail_home_mlose =       itemView.findViewById(R.id.tv_pred_hometeam_mlose);
        detail_home_mdraw =       itemView.findViewById(R.id.tv_pred_hometeam_mdraw);
        detail_home_gfor =       itemView.findViewById(R.id.tv_detail_hometeam_gf);
        detail_home_gaginst =       itemView.findViewById(R.id.tv_detail_hometeam_ga);
        detail_home_gagaints_avg=       itemView.findViewById(R.id.tv_detail_hometeam_gaavg);
        detail_home_gforavg =       itemView.findViewById(R.id.tv_detail_hometeam_gfavg);

        //Comparsion
        frome_away= itemView.findViewById(R.id.tv_forme_away);
        frome_home= itemView.findViewById(R.id.tv_forme_home);

        att_away= itemView.findViewById(R.id.tv_att_away);
        att_home= itemView.findViewById(R.id.tv_att_home);


        def_away= itemView.findViewById(R.id.tv_def_away);
        def_home= itemView.findViewById(R.id.tv_def_home);

        fishlaw_away= itemView.findViewById(R.id.tv_fishlaw_away);
        fishlaw_home= itemView.findViewById(R.id.tv_fishlaw_home);

        h2h_away= itemView.findViewById(R.id.tv_h2h_away);
        h2h_home= itemView.findViewById(R.id.tv_h2h_home);

        goalh2h_away= itemView.findViewById(R.id.tv_goalh2h_away);
        goalh2h_home= itemView.findViewById(R.id.tv_goalh2h_home);

        matchplayed= itemView.findViewById(R.id.tv_matchplayed);
        uderover= itemView.findViewById(R.id.tv_underover);


        goal_away= itemView.findViewById(R.id.tv_awayteam);
        goal_home= itemView.findViewById(R.id.tv_hometeam);


        advice= itemView.findViewById(R.id.tv_advice);


        win_awayprect= itemView.findViewById(R.id.tv_awayperent);

        win_hompprect= itemView.findViewById(R.id.tv_homeperent);

        win_drawprect= itemView.findViewById(R.id.tv_drawperent);


    }


    void getRequest(){
        Call<PredictionResponce> call = RetrofitClientt.getInstance().getApi().getFixturePrediction(item.getFixtureId()+"");
        call.enqueue(new Callback<PredictionResponce>() {
            @Override
            public void onResponse(Call<PredictionResponce> call, Response<PredictionResponce> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: ODDD " + response.body().toString());
                    if(response.body().getApi().getResults()==1)
                        if(response.body().getApi().getPredictions()!=null) {
                            if(response.body().getApi().getPredictions().size()>0)
                            if(response.body().getApi().getPredictions().get(0)!=null) {
                                PredictionsItem item =  response.body().getApi().getPredictions().get(0);

                                heading.setVisibility(View.VISIBLE);

                                advice.setText(item.getAdvice()+"");
                                if(item.getUnderOver()!=null) {
                                    uderover.setText(item.getUnderOver() + "");
                                }
                                if(item.getGoalsAway()!=null) {

                                    goal_away.setText(item.getGoalsAway() + "");
                                }
                                if(item.getGoalsHome()!=null) {

                                    goal_home.setText(item.getGoalsHome() + "");
                                }
                                if(item.getMatchWinner()!=null) {

                                    matchplayed.setText(item.getMatchWinner() + "");
                                }
                                if(item.getWinningPercent().getAway()!=null) {

                                    win_awayprect.setText(item.getWinningPercent().getAway() + "");
                                }
                                if(item.getWinningPercent().getHome()!=null) {

                                    win_hompprect.setText(item.getWinningPercent().getHome() + "");
                                }
                                if(item.getWinningPercent().getDraws()!=null){

                                    win_drawprect.setText(item.getWinningPercent().getDraws() + "");
                                }
                                Home home=  item.getTeams().getHome();
                               if(home!=null) {
                                   detail_home.setText(home.getTeamName()+"");

                                   detail_home_mp.setText(home.getAllLastMatches().getMatchs().getMatchsPlayed().getTotal() + "");
                                   detail_home_mwin.setText(home.getAllLastMatches().getMatchs().getWins().getTotal() + "");
                                   detail_home_mlose.setText(home.getAllLastMatches().getMatchs().getLoses().getTotal() + "");
                                   detail_home_mdraw.setText(home.getAllLastMatches().getMatchs().getDraws().getTotal() + "");

                                   detail_home_gfor.setText(home.getAllLastMatches().getGoals().getGoalsFor().getTotal() + "");
                                   detail_home_gforavg.setText(home.getAllLastMatches().getGoalsAvg().getGoalsFor().getTotal() + "");
                                   detail_home_gaginst.setText(home.getAllLastMatches().getGoals().getGoalsAgainst().getTotal() + "");
                                   detail_home_gagaints_avg.setText(home.getAllLastMatches().getGoalsAvg().getGoalsAgainst().getTotal() + "");
                               }

                                Away away =  item.getTeams().getAway();


                                if(away!=null){
                                    detail_away.setText(away.getTeamName()+"");
                                detail_away_mp.setText(away.getAllLastMatches().getMatchs().getMatchsPlayed().getTotal()+"");
                                detail_away_mwin.setText(away.getAllLastMatches().getMatchs().getWins().getTotal()+"");
                                detail_away_mlose.setText(away.getAllLastMatches().getMatchs().getLoses().getTotal()+"");
                                detail_away_mdraw.setText(away.getAllLastMatches().getMatchs().getDraws().getTotal()+"");

                                detail_away_gfor.setText(away.getAllLastMatches().getGoals().getGoalsFor().getTotal()+"");
                                detail_away_gforavg.setText(away.getAllLastMatches().getGoalsAvg().getGoalsFor().getTotal()+"");
                                detail_away_gagainst.setText(away.getAllLastMatches().getGoals().getGoalsAgainst().getTotal()+"");
                                detail_away_gagainst_avg.setText(away.getAllLastMatches().getGoalsAvg().getGoalsAgainst().getTotal()+"");
                            }


                                Comparison comparison = item.getComparison();
                                if(comparison!=null){

                                    frome_away.setText(comparison.getForme().getAway()+"");
                                    frome_home.setText(comparison.getForme().getHome()+"");

                                    h2h_away.setText(comparison.getH2h().getAway()+"");
                                    h2h_home.setText(comparison.getH2h().getHome()+"");

                                    att_away.setText(comparison.getAtt().getAway()+"");
                                    att_home.setText(comparison.getAtt().getHome()+"");

                                    def_away.setText(comparison.getDef().getAway()+"");
                                    def_home.setText(comparison.getDef().getHome()+"");

                                    goalh2h_away.setText(comparison.getGoalsH2h().getAway()+"");
                                    goalh2h_home.setText(comparison.getGoalsH2h().getHome()+"");

                                    fishlaw_away.setText(comparison.getFishLaw().getAway()+"");
                                    fishlaw_home.setText(comparison.getFishLaw().getHome()+"");


                                }










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
            public void onFailure(Call<PredictionResponce> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);

                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }


}