package com.soccer.pojo.oddfix;


import com.google.gson.annotations.SerializedName;
public class OddResponce{

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
			"OddResponce{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}