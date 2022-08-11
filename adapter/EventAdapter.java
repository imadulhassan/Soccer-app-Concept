package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.pojo.event.EventsItem;
import com.soccer.pojo.oddfix.BetsItem;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MatchHolder>  {

    Context context ;
    List<EventsItem>  EventsItem ;


    public EventAdapter(Context context, List<EventsItem> EventsItem) {
        this.context = context;
        this.EventsItem = EventsItem;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.event_recyle_view,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final EventsItem eventsItem = EventsItem.get(position);
        if(eventsItem.getTeamName()==null){
            holder.team.setText("-");
        }else {
            holder.team.setText(eventsItem.getTeamName() + "");
        }
        if(eventsItem.getPlayer()==null){
            holder.player.setText("-");
        }else {
            holder.player.setText(eventsItem.getPlayer() + "");
        }

        if(eventsItem.getType()==null){
            holder.type.setText("-");
        }else {
            holder.type.setText(eventsItem.getType()+"");
        }
        if(eventsItem.getAssist()==null){
            holder.assist.setText("-");
        }else {
            holder.assist.setText(eventsItem.getAssist()+"");

        }

        if(eventsItem.getComments()==null){
            holder.comment.setText("-");
        }else {
            holder.comment.setText(eventsItem.getComments()+"");

        }

        if(eventsItem.getDetail()==null){
            holder.details.setText("-");
        }else {
            holder.details.setText(eventsItem.getDetail()+"");

        }
    }




    @Override
    public int getItemCount() {
        return EventsItem.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView team, player , type , assist, comment, details;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            team = itemView.findViewById(R.id.event_team);
            player = itemView.findViewById(R.id.event_player);
            type = itemView.findViewById(R.id.event_type);
            assist = itemView.findViewById(R.id.event_assist);
            comment = itemView.findViewById(R.id.event_comment);
            details= itemView.findViewById(R.id.event_detail);

        }
 }
}
