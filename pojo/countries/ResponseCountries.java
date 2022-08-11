package com.soccer.pojo.countries;
import com.google.gson.annotations.SerializedName;


public class ResponseCountries{

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
			"ResponseCountries{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}