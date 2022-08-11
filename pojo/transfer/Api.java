package com.soccer.pojo.transfer;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("transfers")
	private List<TransfersItem> transfers;

	@SerializedName("results")
	private int results;

	public void setTransfers(List<TransfersItem> transfers){
		this.transfers = transfers;
	}

	public List<TransfersItem> getTransfers(){
		return transfers;
	}

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"transfers = '" + transfers + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}