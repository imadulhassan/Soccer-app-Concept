package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class PredictionResponce{

	@SerializedName("api")
	private Api api;

	public void setApi(Api api){
		this.api = api;
	}

	public Api getApi(){
		return api;
	}

	@Override
 	public String toString(){
		return 
			"PredictionResponce{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}