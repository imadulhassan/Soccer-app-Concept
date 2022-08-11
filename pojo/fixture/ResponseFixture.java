package com.soccer.pojo.fixture;


import com.google.gson.annotations.SerializedName;


public class ResponseFixture{

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
			"ResponseFixture{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}