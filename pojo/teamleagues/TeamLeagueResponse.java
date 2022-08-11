package com.soccer.pojo.teamleagues;


import com.google.gson.annotations.SerializedName;
public class TeamLeagueResponse{

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
			"TeamLeagueResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}