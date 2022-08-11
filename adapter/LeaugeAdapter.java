package com.soccer.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.button.MaterialButton;
import com.soccer.Details;
import com.soccer.LeagueDetails;
import com.soccer.LeagueMatches;
import com.soccer.R;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.pojo.teamstat.Statistics;
import com.soccer.pojo.teamstat.TeamStat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaugeAdapter extends RecyclerView.Adapter<LeaugeAdapter.MatchHolder>  {

    Context context ;
    ArrayList<LeaguesItem>  LeaguesItems ;
   InterstitialAd interstitial;

    public LeaugeAdapter(Context context, ArrayList<LeaguesItem> LeaguesItems) {
        this.context = context;
        this.LeaguesItems = LeaguesItems;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.countries,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
       final LeaguesItem LeaguesItem = LeaguesItems.get(position);


       if(LeaguesItem.getName()!=null)
        holder.tv_league_name.setText(LeaguesItem.getName()+"");
//        Picasso.with(context).load(LeaguesItem.getLogo()).into(holder.iv_league);
//        if(LeaguesItem.getLeague().getFlag()!=null) {
//            GlideToVectorYou
//                    .init()
//                    .with(context)
//                    .load(Uri.parse(LeaguesItem.getLeague().getFlag()), holder.iv_league);
//        }
//        else {
//            holder.iv_league.setBackgroundColor(Color.GREEN);
//        }


        holder.insideMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interstitial = new InterstitialAd(context);
                interstitial.setAdUnitId(context.getResources().getString(R.string.intertialid));
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitial.loadAd(adRequest);
                interstitial.setAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                        Intent intent=  new Intent(context, LeagueDetails.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("Obj",LeaguesItem);
                        context.startActivity(intent);

                    }

                    public void onAdLoaded() {
                        if (interstitial.isLoaded()) {
                            interstitial.show();
                        }
                    }

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        Intent intent=  new Intent(context, LeagueDetails.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("Obj",LeaguesItem);
                        context.startActivity(intent);
                    }
                });


            }
        });



    }




    @Override
    public int getItemCount() {
        return LeaguesItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        LinearLayout insideMain;

        TextView tv_league_name;

                ;





        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            insideMain= itemView.findViewById(R.id.ll_inside_main);


            //Images
            tv_league_name=itemView.findViewById(R.id.league_name);



        }
 }
}
