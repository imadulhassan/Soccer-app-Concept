package com.soccer.pojo.standing;


import com.google.gson.annotations.SerializedName;


public class StandingsItemItem{

	@SerializedName("teamName")
	private String teamName;

	@SerializedName("all")
	private All all;

	@SerializedName("away")
	private Away away;

	@SerializedName("description")
	private String description;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("goalsDiff")
	private int goalsDiff;

	@SerializedName("home")
	private Home home;

	@SerializedName("points")
	private int points;

	@SerializedName("forme")
	private String forme;

	@SerializedName("lastUpdate")
	private String lastUpdate;

	@SerializedName("rank")
	private int rank;

	@SerializedName("logo")
	private String logo;

	@SerializedName("group")
	private String group;

	@SerializedName("status")
	private String status;

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setAll(All all){
		this.all = all;
	}

	public All getAll(){
		return all;
	}

	public void setAway(Away away){
		this.away = away;
	}

	public Away getAway(){
		return away;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setGoalsDiff(int goalsDiff){
		this.goalsDiff = goalsDiff;
	}

	public int getGoalsDiff(){
		return goalsDiff;
	}

	public void setHome(Home home){
		this.home = home;
	}

	public Home getHome(){
		return home;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}

	public void setForme(String forme){
		this.forme = forme;
	}

	public String getForme(){
		return forme;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"StandingsItemItem{" + 
			"teamName = '" + teamName + '\'' + 
			",all = '" + all + '\'' + 
			",away = '" + away + '\'' + 
			",description = '" + description + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",goalsDiff = '" + goalsDiff + '\'' + 
			",home = '" + home + '\'' + 
			",points = '" + points + '\'' + 
			",forme = '" + forme + '\'' + 
			",lastUpdate = '" + lastUpdate + '\'' + 
			",rank = '" + rank + '\'' + 
			",logo = '" + logo + '\'' + 
			",group = '" + group + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}