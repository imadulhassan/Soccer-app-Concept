package com.soccer.pojo.teamPlayer;
import com.google.gson.annotations.SerializedName;


public class TeamPlayerResponse{

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
			"TeamPlayerResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}