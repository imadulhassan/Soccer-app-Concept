package com.soccer.pojo.transfer;


import com.google.gson.annotations.SerializedName;


public class TransfersItem{

	@SerializedName("team_in")
	private TeamIn teamIn;

	@SerializedName("player_id")
	private int playerId;

	@SerializedName("lastUpdate")
	private int lastUpdate;

	@SerializedName("player_name")
	private String playerName;

	@SerializedName("transfer_date")
	private String transferDate;

	@SerializedName("type")
	private Object type;

	@SerializedName("team_out")
	private TeamOut teamOut;

	public void setTeamIn(TeamIn teamIn){
		this.teamIn = teamIn;
	}

	public TeamIn getTeamIn(){
		return teamIn;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setLastUpdate(int lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public int getLastUpdate(){
		return lastUpdate;
	}

	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}

	public String getPlayerName(){
		return playerName;
	}

	public void setTransferDate(String transferDate){
		this.transferDate = transferDate;
	}

	public String getTransferDate(){
		return transferDate;
	}

	public void setType(Object type){
		this.type = type;
	}

	public Object getType(){
		return type;
	}

	public void setTeamOut(TeamOut teamOut){
		this.teamOut = teamOut;
	}

	public TeamOut getTeamOut(){
		return teamOut;
	}

	@Override
 	public String toString(){
		return 
			"TransfersItem{" + 
			"team_in = '" + teamIn + '\'' + 
			",player_id = '" + playerId + '\'' + 
			",lastUpdate = '" + lastUpdate + '\'' + 
			",player_name = '" + playerName + '\'' + 
			",transfer_date = '" + transferDate + '\'' + 
			",type = '" + type + '\'' + 
			",team_out = '" + teamOut + '\'' + 
			"}";
		}
}