package com.soccer.pojo.standing;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("standings")
	private List<List<StandingsItemItem>> standings;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setStandings(List<List<StandingsItemItem>> standings){
		this.standings = standings;
	}

	public List<List<StandingsItemItem>> getStandings(){
		return standings;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",standings = '" + standings + '\'' + 
			"}";
		}
}