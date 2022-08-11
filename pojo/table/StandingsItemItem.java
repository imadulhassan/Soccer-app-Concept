package com.soccer.pojo.table;


import com.google.gson.annotations.SerializedName;
public class StandingsItemItem{

	@SerializedName("teamName")
	private String teamName;

	@SerializedName("lose")
	private String lose;

	@SerializedName("team_id")
	private String teamId;

	@SerializedName("draw")
	private String draw;

	@SerializedName("goalsDiff")
	private String goalsDiff;

	@SerializedName("points")
	private String points;

	@SerializedName("matchsPlayed")
	private String matchsPlayed;

	@SerializedName("goalsFor")
	private String goalsFor;

	@SerializedName("lastUpdate")
	private String lastUpdate;

	@SerializedName("rank")
	private String rank;

	@SerializedName("goalsAgainst")
	private String goalsAgainst;

	@SerializedName("win")
	private String win;

	@SerializedName("group")
	private String group;

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setLose(String lose){
		this.lose = lose;
	}

	public String getLose(){
		return lose;
	}

	public void setTeamId(String teamId){
		this.teamId = teamId;
	}

	public String getTeamId(){
		return teamId;
	}

	public void setDraw(String draw){
		this.draw = draw;
	}

	public String getDraw(){
		return draw;
	}

	public void setGoalsDiff(String goalsDiff){
		this.goalsDiff = goalsDiff;
	}

	public String getGoalsDiff(){
		return goalsDiff;
	}

	public void setPoints(String points){
		this.points = points;
	}

	public String getPoints(){
		return points;
	}

	public void setMatchsPlayed(String matchsPlayed){
		this.matchsPlayed = matchsPlayed;
	}

	public String getMatchsPlayed(){
		return matchsPlayed;
	}

	public void setGoalsFor(String goalsFor){
		this.goalsFor = goalsFor;
	}

	public String getGoalsFor(){
		return goalsFor;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setRank(String rank){
		this.rank = rank;
	}

	public String getRank(){
		return rank;
	}

	public void setGoalsAgainst(String goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public String getGoalsAgainst(){
		return goalsAgainst;
	}

	public void setWin(String win){
		this.win = win;
	}

	public String getWin(){
		return win;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

	@Override
 	public String toString(){
		return 
			"StandingsItemItem{" + 
			"teamName = '" + teamName + '\'' + 
			",lose = '" + lose + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",draw = '" + draw + '\'' + 
			",goalsDiff = '" + goalsDiff + '\'' + 
			",points = '" + points + '\'' + 
			",matchsPlayed = '" + matchsPlayed + '\'' + 
			",goalsFor = '" + goalsFor + '\'' + 
			",lastUpdate = '" + lastUpdate + '\'' + 
			",rank = '" + rank + '\'' + 
			",goalsAgainst = '" + goalsAgainst + '\'' + 
			",win = '" + win + '\'' + 
			",group = '" + group + '\'' + 
			"}";
		}
}