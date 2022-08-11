package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import  com.soccer.pojo.standing.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;


import com.squareup.picasso.Picasso;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.MatchHolder>  {

    Context context ;
    List<StandingsItemItem> items;


    public TableAdapter(Context context, List<StandingsItemItem> item) {
        this.context = context;
        this.items = item;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyler_league_table,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final StandingsItemItem obj = items.get(position);

            holder.rank.setText( obj.getRank() + "");
        if(obj.getTeamName()==null){
            holder.team.setText("-");
        }else {
            holder.team.setText(obj.getTeamName() + "");
        }

        if(obj.getGroup()==null){
            holder.group.setText("-");
        }else {
            holder.group.setText(obj.getGroup()+"");
        }
        if(obj.getAll()==null){
            holder.win.setText("-");
        }else {
            holder.win.setText(obj.getAll().getWin()+"");

        }

        if(obj.getAll()==null){
            holder.matchplayed.setText("-");
        }else {
            holder.matchplayed.setText(obj.getAll().getMatchsPlayed()+"");

        }
        if(obj.getAll()==null){
            holder.draw.setText("-");
        }else {
        holder.draw.setText(obj.getAll().getDraw()+"");

        }

            holder.points.setText(obj.getPoints()+"");

        if(obj.getAll()==null){
            holder.goalagainst.setText("-");
        }else {
            holder.goalagainst.setText(obj.getAll().getGoalsAgainst()+"");

        }
        if(obj.getAll()==null){
            holder.goalfor.setText("-");
        }else {
            holder.goalfor.setText(obj.getAll().getGoalsFor()+"");

        }

            holder.goaldiff.setText(obj.getGoalsDiff()+"");






}




    @Override
    public int getItemCount() {
        return items.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView rank, team, group, win, draw, matchplayed;
        TextView points, goaldiff,goalagainst,goalfor;


        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.leg_table_rank);
            team = itemView.findViewById(R.id.leg_table_team);
            group = itemView.findViewById(R.id.leg_table_group);
            win = itemView.findViewById(R.id.leg_table_win);
            draw = itemView.findViewById(R.id.leg_table_draw);
            matchplayed = itemView.findViewById(R.id.leg_table_mp);
            points = itemView.findViewById(R.id.leg_table_gpoints);
            goalagainst = itemView.findViewById(R.id.leg_table_ga);
            goalfor = itemView.findViewById(R.id.leg_table_gf);
            goaldiff= itemView.findViewById(R.id.leg_table_diff);

        }
 }
}
