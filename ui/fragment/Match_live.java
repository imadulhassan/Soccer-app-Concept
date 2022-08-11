package com.soccer.ui.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.material.snackbar.Snackbar;
import com.soccer.R;
import com.soccer.TeamMactaches;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.DetectConnection;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.ResponseFixture;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Match_live extends Fragment {


    RecyclerView recyclerView;
    MatchesAdapter adapter;
    ProgressBar bar;
    SwipeRefreshLayout refreshLayout;

    // List of MenuItems and native ads that populate the RecyclerView.
    private ArrayList<Object> mRecyclerViewItems = new ArrayList<>();



    ImageView empty;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       final View root = inflater.inflate(R.layout.frag_live, container, false);
         refreshLayout= root.findViewById(R.id.swipelayout);
        bar= root.findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));
        empty= root.findViewById(R.id.image_empty);
        bar.setIndeterminateDrawable(doubleBounce);

        recyclerView= root.findViewById(R.id.rv_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
             getRequest();

             refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                 @Override
                 public void onRefresh() {
                     empty.setVisibility(View.GONE);
                     mRecyclerViewItems.clear();
                 if(DetectConnection.checkInternetConnection(getContext())) {
                     getRequest();
                 }else{
                     Snackbar.make(root,"No Internet Connection ",Snackbar.LENGTH_LONG).show();
                 }
                 }
             });
        return root;
    }


    void getRequest(){

        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getFixtureLive();
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {

                bar.setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: " + response.body().toString());
                    if(response.body().getApi().getFixtures()!=null)

                         mRecyclerViewItems.addAll(response.body().getApi().getFixtures());
               loadmenu();

                }
                else{
                    empty.setVisibility(View.VISIBLE);
                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());

                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {
              bar.setVisibility(View.INVISIBLE);
                empty.setVisibility(View.VISIBLE);
                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }





    void loadmenu(){
        adapter = new MatchesAdapter(getContext(), mRecyclerViewItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}