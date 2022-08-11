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
import com.soccer.adapter.PlayerStatAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.coaches.CoachsItem;
import com.soccer.pojo.coaches.CochesResponse;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.fixture.HomeTeam;
import com.soccer.pojo.playerStat.PlayerStatictics;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamCoaches_Frag extends Fragment {


    ProgressBar bar;
    ImageView empty;
    AdView madAdView;
    HomeTeam  item;

    TextView  name  , frist ,  last , dob , place , nationality , team ;
    LinearLayout layout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_coches_team, container, false);
        madAdView= root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        bar= root.findViewById(R.id.bar);
        empty= root.findViewById(R.id.image_empty);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);

        if(getArguments()!=null){
             item= (HomeTeam) getArguments().getSerializable("Obj");
             getRequest();

        }

        init(root);
        return root;
    }


    void getRequest(){
       // item.getFixtureId()
        Call<CochesResponse> call = RetrofitClientt.getInstance().getApi().getTeamCoach(item.getTeamId()+"");
        call.enqueue(new Callback<CochesResponse>() {
            @Override
            public void onResponse(Call<CochesResponse> call, Response<CochesResponse> response) {
                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: Event " + response.body().toString());
                    if(response.body().getApi().getResults()!=0)
                        if(response.body().getApi().getCoachs()!=null) {
                            if(response.body().getApi().getCoachs().size()>0) {
                                   Log.d("Response", "onResponse: Event " + response.body().toString());
                                            setData(response.body().getApi().getCoachs().get(0));

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
            public void onFailure(Call<CochesResponse> call, Throwable t) {
                bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Response", "onResponse: Odds" + t.getMessage());

            }
        });


    }

    void init(View view){
        layout=view.findViewById(R.id.ll_coaches);
        name= view.findViewById(R.id.coaches_name);
        dob= view.findViewById(R.id.coaches_dob);
        frist= view.findViewById(R.id.coaches_frist);
        last= view.findViewById(R.id.coaches_last);
        nationality= view.findViewById(R.id.coaches_nationality);
        team= view.findViewById(R.id.coaches_team);
        place= view.findViewById(R.id.coaches_place);


    }



    void setData(CoachsItem item){
        layout.setVisibility(View.VISIBLE);
        if(item.getName()==null){
             name.setText("-");
        }else {
             name.setText(item.getName() + "");
        }
        if(item.getBirthDate()==null){
             dob.setText("-");
        }else {
             dob.setText(item.getBirthDate() + "");
        }

        if(item.getBirthPlace()==null){
             place.setText("-");
        }else {
             place.setText(item.getBirthPlace()+"");
        }
        if(item.getNationality()==null){
             nationality.setText("-");
        }else {
             nationality.setText(item.getNationality()+"");

        }

        if(item.getLastname()==null){
             last.setText("-");
        }else {
             last.setText(item.getLastname()+"");

        }

        if(item.getFirstname()==null){
            frist.setText("-");
        }else {
            frist.setText(item.getFirstname()+"");

        }



        if(item.getTeam()==null){
            team.setText("-");
        }else {
            team.setText(item.getTeam().getName()+"");

        }


    }

}