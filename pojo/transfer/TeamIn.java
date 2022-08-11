package com.soccer.pojo.transfer;


import com.google.gson.annotations.SerializedName;


public class TeamIn{

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("team_name")
	private String teamName;

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
			"TeamIn{" + 
			"team_id = '" + teamId + '\'' + 
			",team_name = '" + teamName + '\'' + 
			"}";
		}
}