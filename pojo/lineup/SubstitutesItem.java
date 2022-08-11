package com.soccer.pojo.lineup;


import com.google.gson.annotations.SerializedName;


public class SubstitutesItem{

	@SerializedName("number")
	private int number;

	@SerializedName("player_id")
	private int playerId;

	@SerializedName("pos")
	private String pos;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("player")
	private String player;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setPos(String pos){
		this.pos = pos;
	}

	public String getPos(){
		return pos;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setPlayer(String player){
		this.player = player;
	}

	public String getPlayer(){
		return player;
	}

	@Override
 	public String toString(){
		return 
			"SubstitutesItem{" + 
			"number = '" + number + '\'' + 
			",player_id = '" + playerId + '\'' + 
			",pos = '" + pos + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",player = '" + player + '\'' + 
			"}";
		}
}