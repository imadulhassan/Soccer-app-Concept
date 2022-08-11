package com.soccer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.soccer.CountryLeagues;
import com.soccer.R;
import com.soccer.pojo.teamPlayer.PlayersItem;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MatchHolder>  {

    Context context ;
    List<PlayersItem> playerList;
   InterstitialAd interstitial;

    public PlayerAdapter(Context context, List<PlayersItem> countries) {
        this.context = context;
        this.playerList = countries;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.player_recyle,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
       final PlayersItem item = playerList.get(position);

        holder.player_name.setText(item.getPlayerName()+"");
        holder.player_position.setText(item.getPosition()+"");
        holder.player_age.setText(item.getAge()+"");


    }




    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        LinearLayout insideMain;
        TextView player_name;
        TextView player_position;
        TextView player_age;

                ;





        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            insideMain= itemView.findViewById(R.id.ll_inside_main);
            //Images

            player_name =itemView.findViewById(R.id.player_name);
            player_position =itemView.findViewById(R.id.tv_playerposition);
            player_age =itemView.findViewById(R.id.tv_playerage);

        }
 }
}
