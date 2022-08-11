package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.pojo.fixturestat.Statistics;
import com.soccer.pojo.leauge.LeaguesItem;


import java.util.ArrayList;

public class FixtureStatistAdapter extends RecyclerView.Adapter<FixtureStatistAdapter.MatchHolder>  {

    Context context ;
    Statistics statistics ;

    String[] list={"Shots on Goal","Shots off Goal"
    ,"Total Shots","Bloacked  Shots"
            ,"Shots Insidebox","Foul"
            ,"Corner Kids","Off Sides"
            ,"Balls Possession","Yellow Card"
            ,"Red Card"
            ,"Goal keeper Saves","Total Passes"

    };


    public FixtureStatistAdapter(Context context, Statistics statistics) {
        this.context = context;
        this.statistics = statistics;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.fixturestat_recyle,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {

        holder.heading.setText(list[position]);

        switch(position){

            case 0:
               if(  statistics.getShotsOnGoal().getAway()!=null){
                  holder.awaytext.setText(statistics.getShotsOnGoal().getAway()+"");
               }

                if(  statistics.getShotsOnGoal().getHome()!=null){
                    holder.hometext.setText(statistics.getShotsOnGoal().getHome()+"");
                }

                break;
            case 1:

                if(  statistics.getShotsOffGoal().getAway()!=null){
                    holder.awaytext.setText(statistics.getShotsOffGoal().getAway()+"");
                }

                if(  statistics.getShotsOffGoal().getHome()!=null){
                    holder.hometext.setText(statistics.getShotsOffGoal().getHome()+"");
                }

                break;


            case 2:

                if(  statistics.getTotalShots().getAway()!=null){
                    holder.awaytext.setText(statistics.getTotalShots().getAway()+"");
                }

                if(  statistics.getTotalShots().getHome()!=null){
                    holder.hometext.setText(statistics.getTotalShots().getHome()+"");
                }

                break;

            case 3:

                if(  statistics.getBlockedShots().getAway()!=null){
                    holder.awaytext.setText(statistics.getBlockedShots().getAway()+"");
                }

                if(  statistics.getBlockedShots().getHome()!=null){
                    holder.hometext.setText(statistics.getBlockedShots().getHome()+"");
                }

                break;

            case 4:

                if(  statistics.getShotsInsidebox().getAway()!=null){
                    holder.awaytext.setText(statistics.getShotsInsidebox().getAway()+"");
                }

                if(  statistics.getShotsInsidebox().getHome()!=null){
                    holder.hometext.setText(statistics.getShotsInsidebox().getHome()+"");
                }

                break;

            case 5:

                if(  statistics.getFouls().getAway()!=null){
                    holder.awaytext.setText(statistics.getFouls().getAway()+"");
                }

                if(  statistics.getFouls().getHome()!=null){
                    holder.hometext.setText(statistics.getFouls().getHome()+"");
                }

                break;

            case 6:

                if(  statistics.getCornerKicks().getAway()!=null){
                    holder.awaytext.setText(statistics.getCornerKicks().getAway()+"");
                }

                if(  statistics.getCornerKicks().getHome()!=null){
                    holder.hometext.setText(statistics.getCornerKicks().getHome()+"");
                }

                break;


            case 7:

                if(  statistics.getOffsides().getAway()!=null){
                    holder.awaytext.setText(statistics.getOffsides().getAway()+"");
                }

                if(  statistics.getOffsides().getHome()!=null){
                    holder.hometext.setText(statistics.getOffsides().getHome()+"");
                }

                break;

            case 8:

                if(  statistics.getBallPossession().getAway()!=null){
                    holder.awaytext.setText(statistics.getBallPossession().getAway()+"");
                }

                if(  statistics.getBallPossession().getHome()!=null){
                    holder.hometext.setText(statistics.getBallPossession().getHome()+"");
                }

                break;

            case 9:

                if(  statistics.getYellowCards().getAway()!=null){
                    holder.awaytext.setText(statistics.getYellowCards().getAway()+"");
                }

                if(  statistics.getYellowCards().getHome()!=null){
                    holder.hometext.setText(statistics.getYellowCards().getHome()+"");
                }

                break;

            case 10:

                if(  statistics.getRedCards().getAway()!=null){
                    holder.awaytext.setText(statistics.getRedCards().getAway()+"");
                }

                if(  statistics.getRedCards().getHome()!=null){
                    holder.hometext.setText(statistics.getRedCards().getHome()+"");
                }

                break;

            case 11:

                if(  statistics.getGoalkeeperSaves().getAway()!=null){
                    holder.awaytext.setText(statistics.getGoalkeeperSaves().getAway()+"");
                }

                if(  statistics.getGoalkeeperSaves().getHome()!=null){
                    holder.hometext.setText(statistics.getGoalkeeperSaves().getHome()+"");
                }

                break;

            case 12:

                if(  statistics.getTotalPasses().getAway()!=null){
                    holder.awaytext.setText(statistics.getTotalPasses().getAway()+"");
                }

                if(  statistics.getTotalPasses().getHome()!=null){
                    holder.hometext.setText(statistics.getTotalPasses().getHome()+"");
                }

                break;



        }





    }




    @Override
    public int getItemCount() {
        return list.length;
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView   heading ,  hometext , awaytext ;

                ;





        public MatchHolder(@NonNull View itemView) {
            super(itemView);


            //Images
             heading =       itemView.findViewById(R.id.stat_heading);
             hometext=itemView.findViewById(R.id.stat_home);
             awaytext=itemView.findViewById(R.id.stat_away);



        }
 }
}
