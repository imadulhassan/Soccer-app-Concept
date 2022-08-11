package com.soccer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.PlayerStatDetails;
import com.soccer.R;
import com.soccer.pojo.playerStat.PlayersItem;

import java.util.List;

public class PlayerStatAdapter extends RecyclerView.Adapter<PlayerStatAdapter.MatchHolder>  {

    Context context ;
    List<PlayersItem> playersItems;


    public PlayerStatAdapter(Context context, List<PlayersItem> PlayersItem) {
        this.context = context;
        this.playersItems = PlayersItem;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.playerstat_recyle_view,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final PlayersItem PlayersItem = playersItems.get(position);
        if(PlayersItem.getTeamName()==null){
            holder.team.setText("-");
        }else {
            holder.team.setText(PlayersItem.getTeamName() + "");
        }
        if(PlayersItem.getPlayerName()==null){
            holder.player.setText("-");
        }else {
            holder.player.setText(PlayersItem.getPlayerName() + "");
        }

        if(PlayersItem.getPosition()==null){
            holder.postion.setText("-");
        }else {
            holder.postion.setText(PlayersItem.getPosition()+"");
        }
            holder.number.setText(PlayersItem.getNumber()+"");

        if(PlayersItem.getRating()==null){
            holder.rating.setText("-");
        }else {
            holder.rating.setText(PlayersItem.getRating()+"");

        }

            holder.min_played.setText(PlayersItem.getMinutesPlayed()+"");

        if(PlayersItem.getCaptain()!=null){
            if(PlayersItem.getCaptain().equals("true")){
                holder.captainlayout.setVisibility(View.VISIBLE);
            }
        }
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, PlayerStatDetails.class);
                intent.putExtra("Obj",PlayersItem);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


    }




    @Override
    public int getItemCount() {
        return playersItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView team, player , postion, number, rating, min_played;
        LinearLayout captainlayout;
        CardView mainLayout;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            mainLayout= itemView.findViewById(R.id.cv_playertstatadapter);
            team = itemView.findViewById(R.id.playerstat_team);
            player = itemView.findViewById(R.id.playerstat_player);
            postion = itemView.findViewById(R.id.playerstat_position);
            number = itemView.findViewById(R.id.playerstat_number);
            rating = itemView.findViewById(R.id.playerstat_rating);
            min_played = itemView.findViewById(R.id.playerstat_minplayed);

            //caption image layout
            captainlayout= itemView.findViewById(R.id.captain_layout);

        }
 }
}
