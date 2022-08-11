package com.soccer.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;



/**
 * Created by android on 21/3/17.
 */


public class CheckConnection {



    Activity activity;
    private String TAG = "CheckConnection";

    public CheckConnection(Activity activity) {
        this.activity = activity;
    }


    public static boolean haveNetworkConnection(Context context) {
        boolean conntected = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null) {
                @SuppressLint("MissingPermission")
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        conntected=true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        conntected=true;

                    }
                }
            }
        } else {
            if (cm != null) {
                @SuppressLint("MissingPermission") NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    // connected to the internet
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        conntected=true;

                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        conntected=true;

                    }
                }
            }
        }

        return conntected;
    }

    public static void hideKeyboard(Context context, View view) {
        // hide virtual keyboard
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


    }
}
