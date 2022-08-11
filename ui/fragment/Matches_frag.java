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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.soccer.R;
import com.soccer.adapter.MatchesAdapter;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixture.ResponseFixture;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Matches_frag extends Fragment {


    ImageView showCalender;
    RecyclerView recyclerView;
    DatePickerDialog.OnDateSetListener toListenr;
    MatchesAdapter adapter;
     ProgressBar bar;
     TextView date;
     ImageView empty;

    private ArrayList<Object> mRecyclerViewItems = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.frag_matches, container, false);
       recyclerView= root.findViewById(R.id.rv_matches);
        empty= root.findViewById(R.id.image_empty);
        date= root.findViewById(R.id.date);
        bar= root.findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce(); doubleBounce.setColor(getResources().getColor(R.color.bar));

        bar.setIndeterminateDrawable(doubleBounce);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.YEAR,+1);
        Calendar cal = Calendar.getInstance();
       // cal.add(Calendar.DATE, -1);
        final HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(root, R.id.calendarView)
                .range( startDate, endDate)
                .datesNumberOnScreen(7)// Number of Dates cells shown on screen (default to 5).
                .configure()
                .showTopText(true)
                .showBottomText(true)
                .end()
                .defaultSelectedDate(cal)    // Date to be selected at start (default to current day `Calendar.getInstance()`).
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
             ;
                 SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
                 String d= sm.format(  horizontalCalendar.getSelectedDate().getTime());
                empty.setVisibility(View.GONE);
                bar.setVisibility(View.VISIBLE);

                mRecyclerViewItems= new ArrayList<>();


                getRequest(d);



            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return true;
            }
        });
//        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
//            @Override
//            public void onDateSelected(Calendar date, int position) {
//                //do something
//                Calendar click=  horizontalCalendar.getDateAt(position);
//                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
//                SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
//                 String d= sm.format(click.getTime());
//                Toast.makeText(getContext(), ""+sm.format(click.getTime()), Toast.LENGTH_SHORT).show();
//
//                getRequest(d);
//            }
//        });
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        showCalender= root.findViewById(R.id.iv_datedialog);
        showCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDate();
            }
        });
        toListenr = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                Log.d(TAG, " To  onDateSet: dd-mm-yyyy: " + month + "-" + day + "-" + year);
                String dte =year+ "-" + month + "-" +day ;
         empty.setVisibility(View.GONE);
          bar.setVisibility(View.VISIBLE);
               mRecyclerViewItems= new ArrayList<>();


                getRequest(dte);

            }

        };


        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String d= sm.format(Calendar.getInstance().getTime());
       // loadNativeAds();
        getRequest(d);
        return root;
    }



    void showDate() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                R.style.datepicker,
                toListenr, year, month, day);

        dialog.show();


    }


    void getRequest(String date ){
        this.date.setText("Date: "+date);
        Log.d("Response", "onResponse: " + date);

        Call<ResponseFixture> call = RetrofitClientt.getInstance().getApi().getFixtureFromDate(date);
        call.enqueue(new Callback<ResponseFixture>() {
            @Override
            public void onResponse(Call<ResponseFixture> call, Response<ResponseFixture> response) {
                bar
                        .setVisibility(View.INVISIBLE);
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: " + response.body().toString());
                    if(response.body().getApi().getFixtures()!=null)

                        mRecyclerViewItems.addAll(response.body().getApi().getFixtures());
                          loadmenu();
                }
                else{

                    Log.d("Response", "onResponse: Faliure Fixture" + response.message());
                  empty.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ResponseFixture> call, Throwable t) {

                bar
                        .setVisibility(View.INVISIBLE);
                Log.d("Responce", "Error: "+t.toString());
                empty.setVisibility(View.VISIBLE);

            }
        });


    }









    void loadmenu(){
        adapter = new MatchesAdapter(getContext(), mRecyclerViewItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}