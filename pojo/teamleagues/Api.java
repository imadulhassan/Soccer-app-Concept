package com.soccer.pojo.teamleagues;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Api{

	@SerializedName("leagues")
	private List<LeaguesItem> leagues;

	@SerializedName("results")
	private int results;

	public void setLeagues(List<LeaguesItem> leagues){
		this.leagues = leagues;
	}

	public List<LeaguesItem> getLeagues(){
		return leagues;
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
			"leagues = '" + leagues + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}