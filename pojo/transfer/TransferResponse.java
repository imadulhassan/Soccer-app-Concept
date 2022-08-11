package com.soccer.pojo.transfer;


import com.google.gson.annotations.SerializedName;


public class TransferResponse{

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
			"TransferResponse{" + 
			"api = '" + api + '\'' + 
			"}";
		}
}