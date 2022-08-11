package com.soccer.pojo.searchpojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class Api{

	@SerializedName("teams")
	private List<TeamsItem> teams;

	@SerializedName("results")
	private int results;

	public void setTeams(List<TeamsItem> teams){
		this.teams = teams;
	}

	public List<TeamsItem> getTeams(){
		return teams;
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
			"teams = '" + teams + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}