package com.soccer.pojo.fixtureodd;


import com.google.gson.annotations.SerializedName;


public class ResponseFixtureOdd{

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
			"ResponseFixtureOdd{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}