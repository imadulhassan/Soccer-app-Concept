package com.soccer.pojo.lineup;


import com.google.gson.annotations.SerializedName;


public class LineupResponse{

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
			"LineupResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}