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
import com.soccer.pojo.oddfix.BetsItem;

import java.util.ArrayList;

public class OddAdapterMain extends RecyclerView.Adapter<OddAdapterMain.MatchHolder>  {

    Context context ;
    ArrayList<BetsItem>  BetsItems ;


    public OddAdapterMain(Context context, ArrayList<BetsItem> BetsItems) {
        this.context = context;
        this.BetsItems = BetsItems;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_ood_recyle,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
       final BetsItem BetsItem = BetsItems.get(position);


        holder.heading_text.setText(BetsItem.getLabelName());
        holder.heading_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        int size =  BetsItem.getValues().size();
        if(size>3) {
            holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
            holder.recyclerView.setBackgroundColor(context.getResources().getColor(R.color.grayprimary_dark));
        }
       else if(size<=3 && size!=0){
            holder.recyclerView.setLayoutManager(new GridLayoutManager(context, size));
            holder.recyclerView.setBackgroundColor(context.getResources().getColor(R.color.secondaryDarkColor));

        }
        ValueAdapter adapter = new ValueAdapter(context,BetsItem.getValues());
        holder.recyclerView.setAdapter(adapter);

    }




    @Override
    public int getItemCount() {
        return BetsItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        LinearLayout heading_layout;
        TextView heading_text;

                ;
        RecyclerView recyclerView;




        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            heading_layout = itemView.findViewById(R.id.ll_odd_heading);
            heading_text =itemView.findViewById(R.id.tv_odd_heading);
            recyclerView = itemView.findViewById(R.id.rv_odd_detail);


        }
 }
}
