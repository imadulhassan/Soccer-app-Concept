package com.soccer.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.soccer.R;
import com.soccer.pojo.teamleagues.LeaguesItem;

import java.util.List;

public class TeamLeagueAdpater extends RecyclerView.Adapter<TeamLeagueAdpater.MatchHolder>  {

    Context context ;
    List<LeaguesItem> leagueitemm;


    public TeamLeagueAdpater(Context context, List<LeaguesItem> LeaguesItem) {
        this.context = context;
        this.leagueitemm = LeaguesItem;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyle_team_legue,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final LeaguesItem eventsItem = leagueitemm.get(position);
        if(eventsItem.getName()==null){
            holder.name.setText("-");
        }else {
            holder.name.setText(eventsItem.getName() + "");
        }
        if(eventsItem.getCountry()==null){
            holder.country.setText("-");
        }else {
            holder.country.setText(eventsItem.getCountry() + "");
        }

        if(eventsItem.getSeasonStart()==null){
            holder.start.setText("-");
        }else {
            holder.start.setText(eventsItem.getSeasonStart()+"");
        }
        if(eventsItem.getSeasonEnd()==null){
            holder.end.setText("-");
        }else {
            holder.end.setText(eventsItem.getSeasonEnd()+"");

        }

        //Picasso.with(context).load().into();
        if (eventsItem.getFlag() != null) {
//            SvgLoader.pluck()
//                    .
//                    .load(url, image);
            GlideToVectorYou
                    .init()
                    .with(context)
                    .load(Uri.parse(eventsItem.getFlag()),holder.leagueImage);


        }

    }




    @Override
    public int getItemCount() {
        return leagueitemm.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView name, country, start, end;
        ImageView leagueImage;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            leagueImage = itemView.findViewById(R.id.leaque_image);
            name = itemView.findViewById(R.id.leauge_name);
            country = itemView.findViewById(R.id.leauge_country);
            start = itemView.findViewById(R.id.leaque_start);
            end = itemView.findViewById(R.id.leaque_end);


        }
 }
}
