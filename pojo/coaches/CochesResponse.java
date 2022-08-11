package com.soccer.pojo.coaches;


import com.google.gson.annotations.SerializedName;


public class CochesResponse{

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
			"CochesResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}