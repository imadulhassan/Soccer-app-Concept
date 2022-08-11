package com.soccer.pojo.teamstat;


import com.google.gson.annotations.SerializedName;


public class TeamStat{

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
			"TeamStat{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}