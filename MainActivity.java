package com.soccer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.soccer.auth.LoginActivity;
import com.soccer.auth.SignUpActivity;
import com.soccer.auth.User;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.searchpojo.SearchResponse;
import com.soccer.pojo.searchpojo.TeamsItem;
import com.soccer.pojo.teamstat.TeamStat;
import com.soccer.tools.Constants;
import com.soccer.tools.Preferences;
import com.soccer.ui.fragment.League_Frag;
import com.soccer.ui.fragment.Match_live;
import com.soccer.ui.fragment.Matches_frag;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ImageView imageView;
    RelativeLayout  live , leagues, matches;
    AutoCompleteTextView tv_search;
    ImageView searchBtn, help;
    TextView username;
    ArrayAdapter<String> searchAdapter;
    ArrayList<String>  searchItems= new ArrayList<>();
    ArrayList<TeamsItem>  searchList = new ArrayList<>();
    AdView madAdView ;
   InterstitialAd interstitial;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    int postionsearch;
    CircleImageView userimage;
    LinearLayout userdetails_layout;
    MaterialButton login_Button;

    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        imageView=findViewById(R.id.drawer_image);
         tv_search = findViewById(R.id.tv_search);
         searchBtn= findViewById(R.id.img_search);

        List<String> testDeviceIds = Arrays.asList("33BE2250B43518CCDA7DE426D04EE231");

        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
        madAdView= findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        madAdView.loadAd(adRequest);

        interstitial = new InterstitialAd(getApplicationContext());
        interstitial.setAdUnitId(getResources().getString(R.string.intertialid));
        AdRequest adRequesti = new AdRequest.Builder().build();
        interstitial.loadAd(adRequesti);
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);

            }

            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();


                Intent intent=  new Intent(getApplicationContext(), TeamMactaches.class);
                intent.putExtra("Obj",searchList.get(postionsearch));
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        help= findViewById(R.id.help);

        tv_search.setThreshold(1); //will start working from first character
        searchAdapter = new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.select_dialog_item,searchItems );
        tv_search.setAdapter(searchAdapter);


        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.inflateHeaderView(R.layout.nav_header_main);
        username= view.findViewById(R.id.username);
        userimage=view.findViewById(R.id.imageView);
        login_Button= view.findViewById(R.id.login_button);
        userdetails_layout= view.findViewById(R.id.userdetails_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }else{
                   drawer.openDrawer(GravityCompat.START);
               }

               }
       });

       help.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                 showDailog();
           }
       });
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Matches_frag()).commit();

        init();



        tv_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String  s= (String) adapterView.getItemAtPosition(i);

                if(searchList.size()>0 && i<searchList.size()){
                    postionsearch=i;
                    if (interstitial.isLoaded()) {
                        interstitial.show();
                    }else{

                        Intent intent=  new Intent(getApplicationContext(), TeamMactaches.class);
                        intent.putExtra("Obj",searchList.get(i));
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }



                }
            }
        });


        tv_search.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                // TODO Auto-generated method stub

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String newText = s.toString();
                Log.d("Search", "onTextChanged: "+newText);
                getSearchAutoComplte(newText);

            }

        });


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tv_search.getText().toString().equals("")) {
                    tv_search.setError("Please enter team to search");
                    tv_search.requestFocus();
                } else {
                    if (searchItems.contains(tv_search.getText().toString())) {

                        postionsearch = searchItems.indexOf(tv_search.getText().toString());
                        if(searchList.size()>0 && postionsearch<searchList.size()){

                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }else{

                                Intent intent=  new Intent(getApplicationContext(), TeamMactaches.class);
                                intent.putExtra("Obj",searchList.get(postionsearch));
                                startActivity(intent);
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                            }


                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "No result found", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
        if(currentUser!=null) {
              userdetails_layout.setVisibility(View.VISIBLE);
             login_Button.setVisibility(View.GONE);
              getUserName();
        }else{
            login_Button.setVisibility(View.VISIBLE);
            login_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      startActivity( new Intent( getApplicationContext(), LoginActivity.class));
                      overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
            });
        }

    }

    private void fn_profilepic(String image) {
     if(AccessToken.getCurrentAccessToken()!=null) {
      Bundle params = new Bundle();
      params.putBoolean("redirect", false);
      params.putString("type", "large");
      new GraphRequest(
              AccessToken.getCurrentAccessToken(),
              "me/picture",
              params,
              HttpMethod.GET,
              new GraphRequest.Callback() {
                  public void onCompleted(GraphResponse response) {

                      Log.e("Response 2", response + "");

                      try {
                          String str_facebookimage = (String) response.getJSONObject().getJSONObject("data").get("url");
                          Log.e("Picture", str_facebookimage);

                          Glide.with(MainActivity.this).load(str_facebookimage).skipMemoryCache(true).into(userimage);

                      } catch (Exception e) {
                          e.printStackTrace();
                      }


                  }
              }
      ).executeAsync();
        }else {
         Picasso.with(getApplicationContext()).load(Uri.parse(image))
                 .into(userimage);

         Toast.makeText(this, "Access Token is null", Toast.LENGTH_SHORT).show();
     }
    }


    void getUserName(){
         FirebaseDatabase.getInstance().getReference().child(Constants.USERS).child(FirebaseAuth.getInstance().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         if(dataSnapshot.exists()){
                             User user= dataSnapshot.getValue(User.class);
                            if(user!=null){
                                username.setText(user.getName()+"");
                                if(user.getPhoto()!=null){
                                    fn_profilepic(user.getPhoto());
                                   //                                    Glide.with(MainActivity.this)
//                                            .load(user.getPhoto())
//                                            .into(userimage);

                                }
                            }
                         }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("Firebase", "onCancelled: "+databaseError);
                    }
                });
    }


    public void showDailog() {

        TextView close;
        final Dialog dialog;
        dialog = new Dialog(MainActivity.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.helpdailog);
        dialog.getWindow().getAttributes().windowAnimations = R.style.diologAnimatioLocation;
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        close=(TextView) dialog.findViewById(R.id.ok);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.show();

    }




    public void ExitDailog() {

        Button close,no;
        final Dialog dialog;
        dialog = new Dialog(MainActivity.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.exitdialog);
        dialog.getWindow().getAttributes().windowAnimations = R.style.diologAnimatioLocation;
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        no=(Button) dialog.findViewById(R.id.no);
        close=(Button) dialog.findViewById(R.id.yes);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }



    private void getSearchAutoComplte( String search_keyword) {
        Log.e("response",  " key"+search_keyword);

//        if (DetectConnection.checkInternetConnection(getActivity())) {

        Call<SearchResponse> call = RetrofitClientt.getInstance().getApi().getSearch(search_keyword);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()) {

                    Log.e("response", "" + response.body().toString());
                        if(searchList.size()!=0) {
                            searchList.clear();
                        }

                        if(searchItems.size()!=0) {
                            searchItems.clear();

                        } if(response.body().getApi().getTeams()!=null)
                            for (int i = 0; i < response.body().getApi().getTeams().size(); i++) {
                                searchItems.add(response.body().getApi().getTeams().get(i).getName()+"");
                                searchList.add(response.body().getApi().getTeams().get(i));
                            }

                            if(tv_search!=null) {
                                searchAdapter = new ArrayAdapter<String>
                                        (getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, searchItems);
                                searchAdapter.notifyDataSetChanged();
                                tv_search.setAdapter(searchAdapter);
                            }
                    Log.d("Response", "onResponse: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d("Responce", "Error: "+t.toString());

            }
        });



    }



    void init(){
         matches= findViewById(R.id.matches);
         live= findViewById(R.id.live);
         leagues = findViewById(R.id.leaque);

         matches.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getSupportFragmentManager().beginTransaction().replace(R.id.container,
                         new Matches_frag()).commit();

             }
         });


       live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Match_live()).commit();

            }
        });


       leagues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new League_Frag()).commit();

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        switch (id){
            case  R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Matches_frag()).commit();
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

                break;
            case  R.id.nav_league:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new League_Frag()).commit();
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

                break;
            case  R.id.nav_live:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Match_live()).commit();
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

                break;



            case  R.id.nav_share:

                   shareApp(getApplicationContext());


                break;
            case  R.id.nav_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getApplicationContext().getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                }

                break;
            case  R.id.nav_feedback:

             sendEmail();

                break;
            case  R.id.logout:
                LoginManager.getInstance().logOut();
                mAuth.signOut();
                // Google sign out
                mGoogleSignInClient.signOut();
//                .addOnCompleteListener(this,
//                        new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                            }
//                        });

                Preferences preferences = new Preferences(getApplicationContext());
                preferences.setBoolean(Constants.LOGIN,false);
                preferences.commit();
                startActivity(new Intent( getApplicationContext() , MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();


                break;

        }

        return false;
    }


    @Override
    public void onBackPressed() {


                 ExitDailog();


    }

    private void sendEmail(){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + "football@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "My email's body");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
    public  void shareApp(Context context)
    {
        try{
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, " Check out the App at: https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName() );
            shareIntent.setType("*/*");
            startActivity(Intent.createChooser(shareIntent, "send"));

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



    }



    void getTeamStatRequest(){

        Call<TeamStat> call = RetrofitClientt.getInstance().getApi().getTeamStatistics("33","2");
        call.enqueue(new Callback<TeamStat>() {
            @Override
            public void onResponse(Call<TeamStat> call, Response<TeamStat> response) {
                if(response.isSuccessful()) {

                    Log.d("Response", "onResponse: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<TeamStat> call, Throwable t) {
                Log.d("Responce", "Error: "+t.toString());

            }
        });


    }
//

}
