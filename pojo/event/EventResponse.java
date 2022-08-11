package com.soccer.pojo.event;


import com.google.gson.annotations.SerializedName;
public class EventResponse{

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
			"EventResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}