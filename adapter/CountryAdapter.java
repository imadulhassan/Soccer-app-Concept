package com.soccer.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.soccer.CountryLeagues;
import com.soccer.R;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.countries.CountriesItem;
import com.soccer.pojo.leauge.ResponseLeauge;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MatchHolder>  {

    Context context ;
    List<CountriesItem>  countries ;
   InterstitialAd interstitial;

    public CountryAdapter(Context context, List<CountriesItem> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.league,parent,false);


        return  new MatchHolder(view);
    }
    LeaugeAdapter adapter;
    @Override
    public void onBindViewHolder(@NonNull final MatchHolder holder, int position) {
       final CountriesItem countriesItem = countries.get(position);


        holder.leagueslist.setVisibility(View.GONE);
        holder.countryname.setText(countriesItem.getCountry());
       // Picasso.with(context).load(countriesItem.getFlag()).into(holder.iv_league);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.leagueslist.setLayoutManager(linearLayoutManager);



     if(countriesItem.getFlag()!=null) {
            GlideToVectorYou
                    .init()
                    .with(context)
                    .load(Uri.parse(countriesItem.getFlag()), holder.iv_league);
        }
//        else {
//            holder.iv_league.setBackgroundColor(Color.GREEN);
//        }


        holder.insideMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(holder.leagueslist.getVisibility()==View.GONE) {
                   holder.leagueslist.setVisibility(View.VISIBLE);
                   Call<ResponseLeauge> call = RetrofitClientt.getInstance().getApi().getAvailavleLeaugesFromCountry(countriesItem.getCountry() + "");
                   call.enqueue(new Callback<ResponseLeauge>() {
                       @Override
                       public void onResponse(Call<ResponseLeauge> call, Response<ResponseLeauge> response) {

                           if (response.isSuccessful()) {

                               Log.d("Response", "Countries: " + response.body().toString());
                               adapter = new LeaugeAdapter(context, response.body().getApi().getLeagues());
                               holder.leagueslist.setAdapter(adapter);
                               adapter.notifyDataSetChanged();

                           } else {

                               Log.d("Response", "onResponse: Faliure Fixture" + response.message());
                           }
                       }


                       @Override
                       public void onFailure(Call<ResponseLeauge> call, Throwable t) {

                           Log.d("Responce", "Error: " + t.toString());

                       }
                   });
               }else{
                   holder.leagueslist.setVisibility(View.GONE);
               }

//                interstitial = new InterstitialAd(context);
//                interstitial.setAdUnitId(context.getResources().getString(R.string.intertialid));
//                AdRequest adRequest = new AdRequest.Builder().build();
//                interstitial.loadAd(adRequest);
//                interstitial.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdFailedToLoad(int i) {
//                        super.onAdFailedToLoad(i);
//                        Intent intent=  new Intent(context, CountryLeagues.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent.putExtra("Obj",countriesItem);
//                        context.startActivity(intent);
//
//                    }
//
//                    public void onAdLoaded() {
//                        if (interstitial.isLoaded()) {
//                            interstitial.show();
//                        }
//                    }
//
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        Intent intent=  new Intent(context, CountryLeagues.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent.putExtra("Obj",countriesItem);
//                        context.startActivity(intent);
//                    }
//                });


            }
        });



    }




    void getRequest(RecyclerView recyclerView , LeaugeAdapter adapter , final Context context , CountriesItem item){



    }


    @Override
    public int getItemCount() {
        return countries.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

       LinearLayout insideMain;
//
//
//
//        TextView country_name;
//
//                ;
         RecyclerView  leagueslist;
         TextView countryname;
         ImageView  iv_league;



        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            insideMain= itemView.findViewById(R.id.ll_inside_main);
//
//
//            //Images
//
//            country_name=itemView.findViewById(R.id.country_name);

            iv_league =       itemView.findViewById(R.id.leaque_image);
            countryname =itemView.findViewById(R.id.leauge_name);
            leagueslist= itemView.findViewById(R.id.inside_recyle_league);



        }
 }
}
