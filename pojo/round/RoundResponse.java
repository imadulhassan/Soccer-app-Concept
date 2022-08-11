package com.soccer.pojo.round;


import com.google.gson.annotations.SerializedName;


public class RoundResponse{

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
			"RoundResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}