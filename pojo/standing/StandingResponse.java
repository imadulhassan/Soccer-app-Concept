package com.soccer.pojo.standing;


import com.google.gson.annotations.SerializedName;


public class StandingResponse{

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
			"StandingResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}