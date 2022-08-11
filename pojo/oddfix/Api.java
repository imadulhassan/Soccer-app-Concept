package com.soccer.pojo.oddfix;

import java.util.List;

import com.google.gson.annotations.SerializedName;
public class Api{

	@SerializedName("odds")
	private List<OddsItem> odds;

	@SerializedName("results")
	private int results;

	public void setOdds(List<OddsItem> odds){
		this.odds = odds;
	}

	public List<OddsItem> getOdds(){
		return odds;
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
			"odds = '" + odds + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}