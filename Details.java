package com.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.teamstat.Statistics;
import com.soccer.pojo.teamstat.TeamStat;
import com.soccer.ui.fragment.Event_Frag;
import com.soccer.ui.fragment.FixtureMatches_Frag;
import com.soccer.ui.fragment.Fixture_stat;
import com.soccer.ui.fragment.Matches_frag;
import com.soccer.ui.fragment.Odd_Frag;
import com.soccer.ui.fragment.PlayerStatistics_Frag;
import com.soccer.ui.fragment.Prediction_Frag;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Details extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FixturesItem item;

    ImageView  homeflag,awyflag;

    TextView home , away ;

      TextView   detail_home,detail_away ,detail_home_mp , detail_home_mdraw,detail_home_mwin,detail_home_mlose,
    detail_away_mp , detail_away_mwin, detail_away_mlose ,detail_away_mdraw,
    detail_away_gfor , detail_away_gagainst , detail_away_gforavg ,detail_away_gagainst_avg
        ,detail_home_gfor,detail_home_gaginst, detail_home_gforavg, detail_home_gagaints_avg;

    TextView league;
    ImageView bkimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailscreen);
        bkimage = findViewById(R.id.back_btn);
        league= findViewById(R.id.leauge_name);
        homeflag= findViewById(R.id.iv_home);
        awyflag= findViewById(R.id.iv_away);
        home= findViewById(R.id.home_team);
        away=findViewById(R.id.away_team);

        detail_away =       findViewById(R.id.tv_detail_awayteam);
        detail_away_mp =       findViewById(R.id.tv_detail_awayteam_mp);
        detail_away_mwin =       findViewById(R.id.tv_detail_awayteam_mwin);
        detail_away_mlose =       findViewById(R.id.tv_detail_awayteam_mlose);
        detail_away_mdraw =       findViewById(R.id.tv_detail_awayteam_mdraw);
        detail_away_gfor =       findViewById(R.id.tv_detail_awayteam_gf);
        detail_away_gforavg =       findViewById(R.id.tv_detail_awayteam_gfavg);
        detail_away_gagainst_avg =       findViewById(R.id.tv_detail_awayteam_gaavg);
        detail_away_gagainst =       findViewById(R.id.tv_detail_awayteam_ga);


        detail_home =       findViewById(R.id.tv_detail_hometeam);
        detail_home_mp =       findViewById(R.id.tv_detail_hometeam_mp);
        detail_home_mwin =       findViewById(R.id.tv_detail_hometeam_mwin);
        detail_home_mlose =       findViewById(R.id.tv_detail_hometeam_mlose);
        detail_home_mdraw =       findViewById(R.id.tv_detail_hometeam_mdraw);
        detail_home_gfor =       findViewById(R.id.tv_detail_hometeam_gf);
        detail_home_gaginst =       findViewById(R.id.tv_detail_hometeam_ga);
        detail_home_gagaints_avg=       findViewById(R.id.tv_detail_hometeam_gaavg);
        detail_home_gforavg =       findViewById(R.id.tv_detail_hometeam_gfavg);


        bkimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        if(getIntent()!=null){
            item= (FixturesItem) getIntent().getSerializableExtra("Obj");

           }

           if(item!=null){

               home.setText(item.getHomeTeam().getTeamName());
               Picasso.with(getApplicationContext()).load(item.getHomeTeam().getLogo()).into(homeflag);
              //tv_gl_home.setText(""+fixturesItem.getGoalsHomeTeam());
               league.setText(item.getLeague().getName());
               away.setText(item.getAwayTeam().getTeamName());
               Picasso.with(getApplicationContext()).load(item.getAwayTeam().getLogo()).into(awyflag);
             // tv_gl_away.setText(fixturesItem.getGoalsAwayTeam()+"");

               detail_away.setText(item.getAwayTeam().getTeamName());
               detail_home.setText(item.getHomeTeam().getTeamName());


               getTeamStatRequest(item.getHomeTeam().getTeamId()+"",item.getLeagueId()+"",true);
               getTeamStatRequest(item.getAwayTeam().getTeamId()+"",item.getLeagueId()+"",false);


           }

           homeflag.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent= new Intent(getApplicationContext(),TeamDetails.class);
                   intent.putExtra("Obj",item);
                   intent.putExtra("Home",true);
                   startActivity(intent);
                   overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

               }
           });

        awyflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),TeamDetails.class);
                intent.putExtra("Obj",item);
                intent.putExtra("Home",false);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });

            tabLayout = findViewById(R.id.tabs);
            viewPager = findViewById(R.id.viewpager);
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),0);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);


    }


    void getTeamStatRequest(String  team_id , String leauge_id ,  final boolean team){

        Call<TeamStat> call = RetrofitClientt.getInstance().getApi().getTeamStatistics(team_id,leauge_id);
        call.enqueue(new Callback<TeamStat>() {
            @Override
            public void onResponse(Call<TeamStat> call, Response<TeamStat> response) {
                if(response.isSuccessful()) {
                    if(response.body().getApi().getStatistics()!=null) {
                        Log.d("Response", "onResponse: " + response.body().toString());
                        if(team){
                            Statistics statistics= response.body().getApi().getStatistics();

                            detail_home_mp.setText(statistics.getMatchs().getMatchsPlayed().getTotal()+"");
                            detail_home_mwin.setText(statistics.getMatchs().getWins().getTotal()+"");
                            detail_home_mlose.setText(statistics.getMatchs().getLoses().getTotal()+"");
                            detail_home_mdraw.setText(statistics.getMatchs().getDraws().getTotal()+"");

                            detail_home_gfor.setText(statistics.getGoals().getGoalsFor().getTotal()+"");
                            detail_home_gforavg.setText(statistics.getGoalsAvg().getGoalsFor().getTotal()+"");
                            detail_home_gaginst.setText(statistics.getGoals().getGoalsAgainst().getTotal()+"");
                            detail_home_gagaints_avg.setText(statistics.getGoalsAvg().getGoalsAgainst().getTotal()+"");


                        }else if(!team){
                            Statistics statistics= response.body().getApi().getStatistics();

                            detail_away_mp.setText(statistics.getMatchs().getMatchsPlayed().getTotal()+"");
                            detail_away_mwin.setText(statistics.getMatchs().getWins().getTotal()+"");
                            detail_away_mlose.setText(statistics.getMatchs().getLoses().getTotal()+"");
                            detail_away_mdraw.setText(statistics.getMatchs().getDraws().getTotal()+"");

                            detail_away_gfor.setText(statistics.getGoals().getGoalsFor().getTotal()+"");
                            detail_away_gforavg.setText(statistics.getGoalsAvg().getGoalsFor().getTotal()+"");
                            detail_away_gagainst.setText(statistics.getGoals().getGoalsAgainst().getTotal()+"");
                            detail_away_gagainst_avg.setText(statistics.getGoalsAvg().getGoalsAgainst().getTotal()+"");
                        }

                    }

                }
            }

            @Override
            public void onFailure(Call<TeamStat> call, Throwable t) {
                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }



    class  PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                  fragment= new Odd_Frag();
                  Bundle bundle = new Bundle();
                  bundle.putSerializable("Obj",item);
                  fragment.setArguments(bundle);

                    break;
                case 1:
                   fragment= new Fixture_stat();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("Obj",item);
                    fragment.setArguments(bundle2);

                    break;
                case 2:
                    fragment= new Prediction_Frag();
                    Bundle bundle3 = new Bundle();
                    bundle3.putSerializable("Obj",item);
                    fragment.setArguments(bundle3);

                    break;
                case 3:
                    fragment= new Event_Frag();
                    Bundle bundle4 = new Bundle();
                    bundle4.putSerializable("Obj",item);
                    fragment.setArguments(bundle4);

                    break;

                case 4:
                    fragment= new PlayerStatistics_Frag();
                    Bundle bundle5 = new Bundle();
                    bundle5.putSerializable("Obj",item);
                    fragment.setArguments(bundle5);

                    break;

                case 5:
                    fragment= new FixtureMatches_Frag();
                    Bundle bundle6 = new Bundle();
                    bundle6.putSerializable("Obj",item);
                    fragment.setArguments(bundle6);

                    break;


            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
           String title="";
           switch (position){
               case 0:

                   title="Odds";
                   break;
               case 1:

                   title="Statistcs";

                   break;
               case 2:

                   title="Prediction";

                   break;
               case 3:

                   title="Events";

                   break;

               case 4:

                   title="Player Statistcs";

                   break;

               case 5:

                   title="Matches";

                   break;



           }

            return title;
        }
    }
}
