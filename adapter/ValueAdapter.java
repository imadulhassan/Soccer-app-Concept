package com.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.R;
import com.soccer.pojo.oddfix.ValuesItem;
import com.soccer.pojo.oddfix.ValuesItem;

import java.util.ArrayList;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.MatchHolder>  {

    Context context ;
    ArrayList<ValuesItem>  ValuesItems ;


    public ValueAdapter(Context context, ArrayList<ValuesItem> ValuesItems) {
        this.context = context;
        this.ValuesItems = ValuesItems;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.valueadapter,parent,false);


        return  new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
       final ValuesItem ValuesItem = ValuesItems.get(position);


        holder.heading_text.setText(ValuesItem.getValue()+"");
        holder.value_text.setText(ValuesItem.getOdd()+"");


    }




    @Override
    public int getItemCount() {
        return ValuesItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        LinearLayout heading_layout;
        TextView heading_text , value_text;

                ;
        RecyclerView recyclerView;




        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            heading_text =itemView.findViewById(R.id.tv_heading);
             value_text= itemView.findViewById(R.id.tv_value);


        }
 }
}
