package com.soccer.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soccer.interfce.ApiNet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientt {

    public static Retrofit retrofit;
    public static final String BASE_URL = "https://api-football-v1.p.rapidapi.com/v2/";
    public static final String   HOST= "x-rapidapi-host:api-football-v1.p.rapidapi.com";
    public static final String  KEY= "x-rapidapi-key:cb919315bfmsh34c699feb4d6ed5p1716c3jsn523ceb98c90e";

    public static RetrofitClientt instance;

    private RetrofitClientt(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized RetrofitClientt getInstance(){
        if (retrofit == null){
            instance = new RetrofitClientt();
            return  instance;
        }
        return instance;
    }
    public static ApiNet getApi(){
        return retrofit.create(ApiNet.class);
    }
}
