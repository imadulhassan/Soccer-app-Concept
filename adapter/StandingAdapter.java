package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.pojo.event.EventsItem;
import com.soccer.pojo.standing.StandingsItemItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingAdapter extends RecyclerView.Adapter<StandingAdapter.MatchHolder>  {

    Context context ;
    List<StandingsItemItem> items;


    public StandingAdapter(Context context, List<StandingsItemItem> item) {
        this.context = context;
        this.items = item;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyler_league_standing,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final StandingsItemItem obj = items.get(position);
        if(obj.getTeamName()==null){
            holder.rank.setText("-");
        }else {

            holder.rank.setText("Rank       " +obj.getTeamName() + "");
        }
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
        if(obj.getForme()==null){
            holder.forme.setText("-");
        }else {
            holder.forme.setText(obj.getForme()+"");

        }

//        if(obj.getPoints()==null){
//            holder.points.setText("-");
//        }else {
            holder.points.setText(obj.getPoints()+"");

        holder.goals.setText(obj.getGoalsDiff()+"");
        //}

        if(obj.getDescription()==null){
            holder.description.setText("-");
        }else {
            holder.description.setText(obj.getDescription()+"");

        }
        if(obj.getLogo()!=null){
            Picasso.with(context).load(obj.getLogo()).into(holder.logo);
        }
    }




    @Override
    public int getItemCount() {
        return items.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView rank, team, group, forme, points, description  ,goals;
        ImageView logo;


        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.standing_rant);
            team = itemView.findViewById(R.id.standing_teamname);
            group = itemView.findViewById(R.id.standing_group);
            forme = itemView.findViewById(R.id.standing_forme);
            points = itemView.findViewById(R.id.standing_points);
            goals = itemView.findViewById(R.id.standing_goal);
            description = itemView.findViewById(R.id.standing_description);

            logo= itemView.findViewById(R.id.standing_image);

        }
 }
}
