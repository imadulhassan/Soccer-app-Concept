package com.soccer.pojo.teamPlayer;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("players")
	private List<PlayersItem> players;

	@SerializedName("results")
	private int results;

	public void setPlayers(List<PlayersItem> players){
		this.players = players;
	}

	public List<PlayersItem> getPlayers(){
		return players;
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
			"players = '" + players + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}