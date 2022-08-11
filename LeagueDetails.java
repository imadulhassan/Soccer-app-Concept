package com.soccer;

import android.net.Uri;
import android.os.Bundle;
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

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.google.android.material.tabs.TabLayout;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.ui.fragment.League_Standing_Frag;
import com.soccer.ui.fragment.League_Table_Frag;
import com.soccer.ui.fragment.Leaguefixtures_Frag;
import com.soccer.ui.fragment.TeamCoaches_Frag;
import com.soccer.ui.fragment.TeamLastfixtures_Frag;
import com.soccer.ui.fragment.TeamLeague_Frag;
import com.soccer.ui.fragment.TeamPlayer_Frag;
import com.soccer.ui.fragment.TeamStatistics_Frag;
import com.soccer.ui.fragment.TeamTransfer_Frag;
import com.soccer.ui.fragment.Teamfixtures_Frag;

public class LeagueDetails extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView league_flag;

    TextView league_name;

    ImageView bkimage;
     LeaguesItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_details);
        bkimage = findViewById(R.id.back_btn);

        bkimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        bkimage = findViewById(R.id.back_btn);

        league_flag = findViewById(R.id.iv_league_home);
        league_name = findViewById(R.id.tv_league_name);
        bkimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        if(getIntent()!=null){
            item= (LeaguesItem) getIntent().getSerializableExtra("Obj");


        }

        if(item!=null){

            league_name.setText(item.getName());
            GlideToVectorYou
                    .init()
                    .with(getApplicationContext())
                    .load(Uri.parse(item.getFlag().toString()), league_flag);
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
                    fragment= new League_Table_Frag();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Obj",item);
                    fragment.setArguments(bundle);

                    break;
//                case 1:
//                    fragment= new League_Standing_Frag();
//                    Bundle bundle2 = new Bundle();
//                    bundle2.putSerializable("Obj",item);
//                    fragment.setArguments(bundle2);
//
//                    break;
                case 1:
                    fragment= new Leaguefixtures_Frag();
                    Bundle bundle3 = new Bundle();
                    bundle3.putSerializable("Obj",item);
                    fragment.setArguments(bundle3);

                    break;



            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title="";
            switch (position){
                case 0:

                    title="Table";
                    break;
//                case 1:
//
//                    title="Standing";
//
//                    break;
                case 1:

                    title="Matches";

                    break;



            }

            return title;
        }
    }

}
