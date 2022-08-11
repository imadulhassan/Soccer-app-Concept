package com.soccer.pojo.playerStat;


import com.google.gson.annotations.SerializedName;


public class PlayerStatictics{

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
			"PlayerStatictics{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}