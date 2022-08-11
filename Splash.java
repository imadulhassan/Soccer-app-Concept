package com.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soccer.auth.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;


public class Splash extends AppCompatActivity {


    FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView= findViewById(R.id.image);
        final Animation animShake = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animShake.setDuration(3000);
        imageView.startAnimation(animShake);
//        mAuth = FirebaseAuth.getInstance();
//        currentUser = mAuth.getCurrentUser();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                if(currentUser!=null) {

                    Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                    Splash.this.startActivity(mainIntent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    Splash.this.finish();
//                }else {
//                    Intent mainIntent = new Intent(Splash.this, LoginActivity.class);
//                    Splash.this.startActivity(mainIntent);
//                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                    Splash.this.finish();
//                }
          }
       }, 3000);
    }



}
