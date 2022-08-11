package com.soccer.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.button.MaterialButton;
import com.soccer.Details;
import com.soccer.LeagueDetails;
import com.soccer.LeagueMatches;
import com.soccer.R;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.FixturesItem;
import com.soccer.pojo.leauge.LeaguesItem;
import com.soccer.pojo.prediction.Away;
import com.soccer.pojo.prediction.Comparison;
import com.soccer.pojo.prediction.Home;
import com.soccer.pojo.prediction.PredictionResponce;
import com.soccer.pojo.prediction.PredictionsItem;
import com.soccer.pojo.teamstat.Statistics;
import com.soccer.pojo.teamstat.TeamStat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder>  {
    private static final int MENU_ITEM_VIEW_TYPE = 0;
    private static final int UNIFIED_NATIVE_AD_VIEW_TYPE = 1;



    Context context ;
    ArrayList<Object>  fixturesItems ;
    InterstitialAd interstitial;
    MatchHolder visbleholder=null;
    int visoblepostion=-1;
    public static final int NUMBER_OF_ADS = 5;

    // The AdLoader used to load ads.
    private AdLoader adLoader;


    // List of native ads that have been successfully loaded.
    private ArrayList<UnifiedNativeAd> mNativeAds = new ArrayList<>();


    private void loadNativeAds() {
        if(context!=null) {
            AdLoader.Builder builder = new AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110");
            adLoader = builder.forUnifiedNativeAd(
                    new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                        @Override
                        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                            // A native ad loaded successfully, check if the ad loader has finished loading
                            // and if so, insert the ads into the list.
                            mNativeAds.add(unifiedNativeAd);
                            if (!adLoader.isLoading()) {
                                insertAdsInMenuItems();
                            }
                        }
                    }).withAdListener(
                    new AdListener() {
                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            // A native ad failed to load, check if the ad loader has finished loading
                            // and if so, insert the ads into the list.
                            Log.e("MainActivity", "The previous native ad failed to load. Attempting to"
                                    + " load another.");
                            if (!adLoader.isLoading()) {
                                insertAdsInMenuItems();
                            }
                        }
                    }).build();

            // Load the Native ads.
            adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
        }
    }





    private void insertAdsInMenuItems() {
        if (mNativeAds.size() <= 0) {
            return;
        }

        int offset = (fixturesItems.size() / mNativeAds.size()) + 1;
        int index = 5;
        for (UnifiedNativeAd ad : mNativeAds) {
            if(fixturesItems.size()>index)
            fixturesItems.add(index, ad);
            index = index + offset;
        }
      notifyDataSetChanged();

    }


    public MatchesAdapter(Context context, ArrayList<Object> fixturesItems) {
        this.context = context;
        this.fixturesItems = fixturesItems;
        loadNativeAds();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case UNIFIED_NATIVE_AD_VIEW_TYPE:
                View unifiedNativeLayoutView = LayoutInflater.from(
                        context).inflate(R.layout.ad_unified,
                        parent, false);
                return new UnifiedNativeAdViewHolder(unifiedNativeLayoutView);
            case MENU_ITEM_VIEW_TYPE:
                // Fall through.

                View view = LayoutInflater.from(context)
                        .inflate(R.layout.match_recyle,parent,false);


                return  new MatchHolder(view);

            default:
           }
         return null;
}

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case UNIFIED_NATIVE_AD_VIEW_TYPE:
                UnifiedNativeAd nativeAd = (UnifiedNativeAd) fixturesItems.get(position);
                populateNativeAdView(nativeAd, ((UnifiedNativeAdViewHolder) holder).getAdView());
                break;
            case MENU_ITEM_VIEW_TYPE:
                // fall through
                populatematch( (MatchHolder) holder,position);
            default:
                populatematch( (MatchHolder) holder,position);


        }
    }

    void populatematch(final MatchHolder holder, final int position){

        final FixturesItem fixturesItem = (FixturesItem) fixturesItems.get(position);
         holder.insideMain.setVisibility(View.GONE);
        holder.openDetai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visbleholder != null && visoblepostion != position) {
                    visbleholder.insideMain.setVisibility(View.GONE);
                    visbleholder = null;
                    visoblepostion =-1;

                }
              if (holder.insideMain.getVisibility() == View.GONE) {
                    visbleholder = holder;
                    visoblepostion = position;
                  Toast.makeText(context, "Position ", Toast.LENGTH_SHORT).show();

                    holder.insideMain.setVisibility(View.VISIBLE);
                } else {
                    holder.insideMain.setVisibility(View.GONE);

                }

            }
        });

        holder.tv_league_name.setText(fixturesItem.getLeague().getName());
        //Picasso.with(context).load().into();
        if (fixturesItem.getLeague().getFlag() != null) {
//            SvgLoader.pluck()
//                    .
//                    .load(url, image);
            GlideToVectorYou
                    .init()
                    .with(context)
                    .load(Uri.parse(fixturesItem.getLeague().getFlag()), holder.iv_league);


        } else {

        }

        holder.iv_league.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeaguesItem item = new LeaguesItem();
                item.setLeagueId(fixturesItem.getLeagueId());
                item.setName(fixturesItem.getLeague().getName());
                item.setCountry(fixturesItem.getLeague().getCountry());
                item.setCountry(fixturesItem.getLeague().getCountry());
                item.setFlag(fixturesItem.getLeague().getFlag());

             Intent intent = new Intent(context, LeagueDetails.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             intent.putExtra("Obj",item);
             context.startActivity(intent);

            }
        });

        holder.tv_mth_status.setText(fixturesItem.getStatusShort());

        holder.tv_hometeam.setText(fixturesItem.getHomeTeam().getTeamName());
        Picasso.with(context).load(fixturesItem.getHomeTeam().getLogo()).into(holder.iv_home);
        holder.tv_gl_home.setText("" + fixturesItem.getGoalsHomeTeam());

        holder.tv_awayteam.setText(fixturesItem.getAwayTeam().getTeamName());
        Picasso.with(context).load(fixturesItem.getAwayTeam().getLogo()).into(holder.iv_away);
        holder.tv_gl_away.setText(fixturesItem.getGoalsAwayTeam() + "");

        if (fixturesItem.getScore().getHalftime() != null) {
            holder.tv_hf_time.setText("" + fixturesItem.getScore().getHalftime());
        }

        if (fixturesItem.getScore().getFulltime() != null) {

            holder.tv_fl_time.setText("" + fixturesItem.getScore().getFulltime());
        }

        holder.detail_away.setText(fixturesItem.getAwayTeam().getTeamName());
        holder.detail_home.setText(fixturesItem.getHomeTeam().getTeamName());

        getTeamStatRequest(fixturesItem.getHomeTeam().getTeamId() + "", fixturesItem.getLeagueId() + "", holder, true);
        getTeamStatRequest(fixturesItem.getAwayTeam().getTeamId() + "", fixturesItem.getLeagueId() + "", holder, false);

        holder.viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interstitial = new InterstitialAd(context);
                interstitial.setAdUnitId(context.getResources().getString(R.string.intertialid));
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitial.loadAd(adRequest);
                interstitial.setAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);

                        Intent intent = new Intent(context, Details.class);
                        intent.putExtra("Obj", fixturesItem);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }

                    public void onAdLoaded() {
                        if (interstitial.isLoaded()) {
                            interstitial.show();
                        }
                    }

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        Intent intent = new Intent(context, Details.class);
                        intent.putExtra("Obj", fixturesItem);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);


                    }
                });
            }
        });

        getAdviceRequest(fixturesItem, holder);
    }


    @Override
    public int getItemViewType(int position) {

        Object recyclerViewItem = fixturesItems.get(position);
        if (recyclerViewItem instanceof UnifiedNativeAd) {
            return UNIFIED_NATIVE_AD_VIEW_TYPE;
        }
        return MENU_ITEM_VIEW_TYPE;
    }


    private void populateNativeAdView(UnifiedNativeAd nativeAd,
                                      UnifiedNativeAdView adView) {
        // Some assets are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        NativeAd.Image icon = nativeAd.getIcon();

        if (icon == null) {
            adView.getIconView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(icon.getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAd);
    }

    void getAdviceRequest(FixturesItem item , final MatchHolder  holder) {
        Call<PredictionResponce> call = RetrofitClientt.getInstance().getApi().getFixturePrediction(item.getFixtureId() + "");
        call.enqueue(new Callback<PredictionResponce>() {
            @Override
            public void onResponse(Call<PredictionResponce> call, Response<PredictionResponce> response) {
                if (response.isSuccessful()) {

                    Log.d("Response", "onResponse: ODDD " + response.body().toString());
                    if (response.body().getApi().getResults() == 1)
                        if (response.body().getApi().getPredictions() != null) {
                            if (response.body().getApi().getPredictions().size() > 0)
                                if (response.body().getApi().getPredictions().get(0) != null) {
                                    PredictionsItem item = response.body().getApi().getPredictions().get(0);

                                   if(!item.getAdvice().isEmpty()) {
                                       holder.advice.setVisibility(View.VISIBLE);
                                       holder.advice.setText(item.getAdvice() + "");
                                   }

                                   holder. win_awayprect.setText(item.getWinningPercent().getAway()+"");
                                   holder. win_hompprect.setText(item.getWinningPercent().getHome()+"");
                                   holder. win_drawprect.setText(item.getWinningPercent().getDraws()+"");

                                }
                        } else {


                        }

                } else {

                }
            }

            @Override
            public void onFailure(Call<PredictionResponce> call, Throwable t) {

            }
        });

    }


        void getTeamStatRequest(String  team_id , String leauge_id , final MatchHolder holder, final boolean team){

        Call<TeamStat> call = RetrofitClientt.getInstance().getApi().getTeamStatistics(team_id,leauge_id);
        call.enqueue(new Callback<TeamStat>() {
            @Override
            public void onResponse(Call<TeamStat> call, Response<TeamStat> response) {
                if(response.isSuccessful()) {
                     if(response.body().getApi().getStatistics()!=null) {
                         Log.d("Response", "onResponse: " + response.body().toString());
                         if(team){
                           Statistics statistics= response.body().getApi().getStatistics();

                             holder.detail_home_mp.setText(statistics.getMatchs().getMatchsPlayed().getTotal()+"");
                             holder.detail_home_mwin.setText(statistics.getMatchs().getWins().getTotal()+"");
                             holder.detail_home_mlose.setText(statistics.getMatchs().getLoses().getTotal()+"");
                             holder.detail_home_mdraw.setText(statistics.getMatchs().getDraws().getTotal()+"");

                             holder.detail_home_gfor.setText(statistics.getGoals().getGoalsFor().getTotal()+"");
                             holder.detail_home_gforavg.setText(statistics.getGoalsAvg().getGoalsFor().getTotal()+"");
                             holder.detail_home_gaginst.setText(statistics.getGoals().getGoalsAgainst().getTotal()+"");
                             holder.detail_home_gagaints_avg.setText(statistics.getGoalsAvg().getGoalsAgainst().getTotal()+"");


                         }else if(!team){
                             Statistics statistics= response.body().getApi().getStatistics();

                             holder.detail_away_mp.setText(statistics.getMatchs().getMatchsPlayed().getTotal()+"");
                             holder.detail_away_mwin.setText(statistics.getMatchs().getWins().getTotal()+"");
                             holder.detail_away_mlose.setText(statistics.getMatchs().getLoses().getTotal()+"");
                             holder.detail_away_mdraw.setText(statistics.getMatchs().getDraws().getTotal()+"");

                             holder.detail_away_gfor.setText(statistics.getGoals().getGoalsFor().getTotal()+"");
                             holder.detail_away_gforavg.setText(statistics.getGoalsAvg().getGoalsFor().getTotal()+"");
                             holder.detail_away_gagainst.setText(statistics.getGoals().getGoalsAgainst().getTotal()+"");
                             holder.detail_away_gagainst_avg.setText(statistics.getGoalsAvg().getGoalsAgainst().getTotal()+"");
                         }

                     }

                }
            }

            @Override
            public void onFailure(Call<TeamStat> call, Throwable t) {
                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }



    @Override
    public int getItemCount() {
        return fixturesItems.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder{

        LinearLayout insideMain,openDetai;


        ImageView  iv_league,iv_home,iv_away;
        TextView  tv_mth_status,tv_league_name,tv_hometeam, tv_awayteam,
                 tv_gl_home , tv_gl_away, tv_hf_time , tv_fl_time
               , detail_home,detail_away ,detail_home_mp , detail_home_mdraw,detail_home_mwin,detail_home_mlose,
                 detail_away_mp , detail_away_mwin, detail_away_mlose ,detail_away_mdraw,
                 detail_away_gfor , detail_away_gagainst , detail_away_gforavg ,detail_away_gagainst_avg
        ,detail_home_gfor,detail_home_gaginst, detail_home_gforavg, detail_home_gagaints_avg
                ,advice
                ,win_awayprect,win_hompprect,win_drawprect;

        MaterialButton viewmore;
                ;





        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            insideMain= itemView.findViewById(R.id.ll_inside_main);
            openDetai=itemView.findViewById(R.id.open_detail);


            //Images
            iv_league =       itemView.findViewById(R.id.leaque_image);
            iv_home =       itemView.findViewById(R.id.team_home_image);
            iv_away =       itemView.findViewById(R.id.team_away_image);
            advice= itemView.findViewById(R.id.tv_advice);

            //   Basic

            tv_league_name =       itemView.findViewById(R.id.leauge_name);
            tv_hometeam =       itemView.findViewById(R.id.home_team);
            tv_awayteam =       itemView.findViewById(R.id.away_team);
            tv_gl_away =       itemView.findViewById(R.id.goalawayteam);
            tv_gl_home =       itemView.findViewById(R.id.goalhometeam);
            tv_hf_time =       itemView.findViewById(R.id.tv_hf);
            tv_fl_time =       itemView.findViewById(R.id.tv_full);

            tv_mth_status =       itemView.findViewById(R.id.match_status);

            // Match Details

            detail_away =       itemView.findViewById(R.id.tv_detail_awayteam);
            detail_away_mp =       itemView.findViewById(R.id.tv_detail_awayteam_mp);
            detail_away_mwin =       itemView.findViewById(R.id.tv_detail_awayteam_mwin);
            detail_away_mlose =       itemView.findViewById(R.id.tv_detail_awayteam_mlose);
            detail_away_mdraw =       itemView.findViewById(R.id.tv_detail_awayteam_mdraw);
            detail_away_gfor =       itemView.findViewById(R.id.tv_detail_awayteam_gf);
            detail_away_gforavg =       itemView.findViewById(R.id.tv_detail_awayteam_gfavg);
            detail_away_gagainst_avg =       itemView.findViewById(R.id.tv_detail_awayteam_gaavg);
            detail_away_gagainst =       itemView.findViewById(R.id.tv_detail_awayteam_ga);


            detail_home =       itemView.findViewById(R.id.tv_detail_hometeam);
            detail_home_mp =       itemView.findViewById(R.id.tv_detail_hometeam_mp);
            detail_home_mwin =       itemView.findViewById(R.id.tv_detail_hometeam_mwin);
            detail_home_mlose =       itemView.findViewById(R.id.tv_detail_hometeam_mlose);
            detail_home_mdraw =       itemView.findViewById(R.id.tv_detail_hometeam_mdraw);
            detail_home_gfor =       itemView.findViewById(R.id.tv_detail_hometeam_gf);
            detail_home_gaginst =       itemView.findViewById(R.id.tv_detail_hometeam_ga);
            detail_home_gagaints_avg=       itemView.findViewById(R.id.tv_detail_hometeam_gaavg);
            detail_home_gforavg =       itemView.findViewById(R.id.tv_detail_hometeam_gfavg);

            // Material Button


            viewmore =       itemView.findViewById(R.id.mb_viewmore);


            win_awayprect= itemView.findViewById(R.id.tv_awayperent);

            win_hompprect= itemView.findViewById(R.id.tv_homeperent);

            win_drawprect= itemView.findViewById(R.id.tv_drawperent);



        }
 }
}
