package com.soccer.pojo.fixture;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class HomeTeam implements Serializable {

	@SerializedName("logo")
	private String logo;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("team_name")
	private String teamName;

	private  String league_id;

	public String getLeague_id() {
		return league_id;
	}

	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	@Override
 	public String toString(){
		return 
			"HomeTeam{" + 
			"logo = '" + logo + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",team_name = '" + teamName + '\'' + 
			"}";
		}
}