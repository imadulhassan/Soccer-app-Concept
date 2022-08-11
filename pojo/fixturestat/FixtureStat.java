package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class FixtureStat{

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
			"FixtureStat{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}