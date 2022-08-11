package com.soccer.pojo.searchpojo;
import com.google.gson.annotations.SerializedName;
public class SearchResponse{

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
			"SearchResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}