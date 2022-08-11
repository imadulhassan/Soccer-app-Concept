package com.soccer.pojo.leauge;

import com.google.gson.annotations.SerializedName;

public class ResponseLeauge{

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
			"ResponseLeauge{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}