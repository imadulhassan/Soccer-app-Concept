package com.soccer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixture.HomeTeam;
import com.soccer.ui.fragment.TeamCoaches_Frag;
import com.soccer.ui.fragment.TeamLastfixtures_Frag;
import com.soccer.ui.fragment.TeamLeague_Frag;
import com.soccer.ui.fragment.TeamPlayer_Frag;
import com.soccer.ui.fragment.TeamStatistics_Frag;
import com.soccer.ui.fragment.TeamTransfer_Frag;
import com.soccer.ui.fragment.Teamfixtures_Frag;
import com.squareup.picasso.Picasso;

public class TeamDetails extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;
    FixturesItem item;
    ImageView teamflag;

    TextView teamname;

    ImageView bkimage;
    HomeTeam  myteam= new HomeTeam();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        bkimage = findViewById(R.id.back_btn);

        teamflag = findViewById(R.id.iv_team_home);
        teamname = findViewById(R.id.tv_team_name);
        bkimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        if(getIntent()!=null){
            item= (FixturesItem) getIntent().getSerializableExtra("Obj");
           boolean b=  getIntent().getBooleanExtra("Home",true);
          if(b){
              myteam=item.getHomeTeam();
              myteam.setLeague_id(item.getLeagueId()+"");
          }if(!b){
                myteam.setLogo(item.getAwayTeam().getLogo());
                myteam.setTeamId(item.getAwayTeam().getTeamId());
                myteam.setTeamName(item.getAwayTeam().getTeamName());
            }
        }

        if(item!=null){

            teamname.setText(myteam.getTeamName());
            Picasso.with(getApplicationContext()).load(myteam.getLogo()).into(teamflag);
            //tv_gl_home.setText(""+fixturesItem.getGoalsHomeTeam());




        }

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),0);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


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
                    fragment= new TeamTransfer_Frag();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle);

                    break;
                case 1:
                    fragment= new TeamCoaches_Frag();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle2);

                    break;
                case 2:
                    fragment= new TeamStatistics_Frag();
                    Bundle bundle3 = new Bundle();
                    bundle3.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle3);

                    break;
                case 3:
                    fragment= new TeamPlayer_Frag();
                    Bundle bundle4 = new Bundle();
                    bundle4.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle4);

                    break;

                case 4:
                    fragment= new TeamLeague_Frag();
                    Bundle bundle5 = new Bundle();
                    bundle5.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle5);

                    break;

                case 5:
                    fragment= new Teamfixtures_Frag();
                    Bundle bundle6 = new Bundle();
                    bundle6.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle6);

                    break;

                case 6:
                    fragment= new TeamLastfixtures_Frag();
                    Bundle bundle7 = new Bundle();
                    bundle7.putSerializable("Obj",myteam);
                    fragment.setArguments(bundle7);

                    break;


            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title="";
            switch (position){
                case 0:

                    title="Transfer";
                    break;
                case 1:

                    title="Coaches";

                    break;
                case 2:

                    title="Statistics";

                    break;
                case 3:

                    title="Players";

                    break;

                case 4:

                    title="League";

                    break;

                case 5:

                    title="UpComing ";

                    break;

                case 6:

                    title="Last";

                    break;


            }

            return title;
        }
    }
}
