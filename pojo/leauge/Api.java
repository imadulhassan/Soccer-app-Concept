package com.soccer.pojo.leauge;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.soccer.pojo.countries.CountriesItem;

public class Api{

	@SerializedName("leagues")
	private ArrayList<LeaguesItem> leagues;

	@SerializedName("results")
	private int results;

	public void setLeagues(ArrayList<LeaguesItem> leagues){
		this.leagues = leagues;
	}

	public ArrayList<LeaguesItem> getLeagues(){
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