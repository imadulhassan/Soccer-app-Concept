package com.soccer.pojo.teamleagues;


import com.google.gson.annotations.SerializedName;
public class Fixtures{

	@SerializedName("players_statistics")
	private boolean playersStatistics;

	@SerializedName("events")
	private boolean events;

	@SerializedName("lineups")
	private boolean lineups;

	@SerializedName("statistics")
	private boolean statistics;

	public void setPlayersStatistics(boolean playersStatistics){
		this.playersStatistics = playersStatistics;
	}

	public boolean isPlayersStatistics(){
		return playersStatistics;
	}

	public void setEvents(boolean events){
		this.events = events;
	}

	public boolean isEvents(){
		return events;
	}

	public void setLineups(boolean lineups){
		this.lineups = lineups;
	}

	public boolean isLineups(){
		return lineups;
	}

	public void setStatistics(boolean statistics){
		this.statistics = statistics;
	}

	public boolean isStatistics(){
		return statistics;
	}

	@Override
 	public String toString(){
		return 
			"Fixtures{" + 
			"players_statistics = '" + playersStatistics + '\'' + 
			",events = '" + events + '\'' + 
			",lineups = '" + lineups + '\'' + 
			",statistics = '" + statistics + '\'' + 
			"}";
		}
}