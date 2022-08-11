package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.pojo.event.EventsItem;
import com.soccer.pojo.transfer.TransfersItem;

import java.util.List;

public class TransferAdapter extends RecyclerView.Adapter<TransferAdapter.MatchHolder>  {

    Context context ;
    List<TransfersItem> transfersItems;


    public TransferAdapter(Context context, List<TransfersItem> TransfersItem) {
        this.context = context;
        this.transfersItems = TransfersItem;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyle_transfer,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
        final TransfersItem item = transfersItems.get(position);
        if(item.getTeamIn()==null){
            holder.teamin.setText("-");
        }else {
            holder.teamin.setText(item.getTeamIn().getTeamName() + "");
        }
        if(item.getPlayerName()==null){
            holder.player.setText("-");
        }else {
            holder.player.setText(item.getPlayerName() + "");
        }

        if(item.getType()==null){
            holder.type.setText("-");
        }else {
            holder.type.setText(item.getType()+"");
        }
        if(item.getTeamOut()==null){
            holder.teamout.setText("-");
        }else {
            holder.teamout.setText(item.getTeamOut().getTeamName()+"");

        }

        if(item.getTransferDate()==null){
            holder.date.setText("-");
        }else {
            holder.date.setText(item.getTransferDate()+"");

        }


    }




    @Override
    public int getItemCount() {
        return transfersItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        TextView teamin, player , type , teamout, date;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            teamin = itemView.findViewById(R.id.transfer_teamin);
            player = itemView.findViewById(R.id.transfer_player);
            type = itemView.findViewById(R.id.transfer_type);
            teamout = itemView.findViewById(R.id.transfer_teamout);
            date = itemView.findViewById(R.id.transfer_date);

        }
 }
}
