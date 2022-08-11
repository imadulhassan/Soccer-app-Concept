package com.soccer.pojo.event;


import com.google.gson.annotations.SerializedName;
public class EventsItem{

	@SerializedName("elapsed")
	private int elapsed;

	@SerializedName("teamName")
	private String teamName;

	@SerializedName("player_id")
	private int playerId;

	@SerializedName("comments")
	private Object comments;

	@SerializedName("assist_id")
	private int assistId;

	@SerializedName("assist")
	private String assist;

	@SerializedName("elapsed_plus")
	private Object elapsedPlus;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("detail")
	private String detail;

	@SerializedName("type")
	private String type;

	@SerializedName("player")
	private String player;

	public void setElapsed(int elapsed){
		this.elapsed = elapsed;
	}

	public int getElapsed(){
		return elapsed;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setComments(Object comments){
		this.comments = comments;
	}

	public Object getComments(){
		return comments;
	}

	public void setAssistId(int assistId){
		this.assistId = assistId;
	}

	public int getAssistId(){
		return assistId;
	}

	public void setAssist(String assist){
		this.assist = assist;
	}

	public String getAssist(){
		return assist;
	}

	public void setElapsedPlus(Object elapsedPlus){
		this.elapsedPlus = elapsedPlus;
	}

	public Object getElapsedPlus(){
		return elapsedPlus;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
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
			"EventsItem{" + 
			"elapsed = '" + elapsed + '\'' + 
			",teamName = '" + teamName + '\'' + 
			",player_id = '" + playerId + '\'' + 
			",comments = '" + comments + '\'' + 
			",assist_id = '" + assistId + '\'' + 
			",assist = '" + assist + '\'' + 
			",elapsed_plus = '" + elapsedPlus + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",detail = '" + detail + '\'' + 
			",type = '" + type + '\'' + 
			",player = '" + player + '\'' + 
			"}";
		}
}