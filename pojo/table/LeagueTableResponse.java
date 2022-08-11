package com.soccer.pojo.table;


import com.google.gson.annotations.SerializedName;
public class LeagueTableResponse{

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
			"LeagueTableResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}