package com.soccer.pojo.fixture;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class FixturesItem  implements  Serializable{

	@SerializedName("fixture_id")
	private int fixtureId;

	@SerializedName("venue")
	private String venue;

	@SerializedName("goalsHomeTeam")
	private int goalsHomeTeam;

	@SerializedName("goalsAwayTeam")
	private int goalsAwayTeam;

	@SerializedName("awayTeam")
	private AwayTeam awayTeam;

	@SerializedName("league")
	private League league;

	@SerializedName("event_timestamp")
	private int eventTimestamp;

	@SerializedName("referee")
	private String referee;

	@SerializedName("elapsed")
	private int elapsed;

	@SerializedName("score")
	private Score score;

	@SerializedName("round")
	private String round;

	@SerializedName("event_date")
	private String eventDate;

	@SerializedName("statusShort")
	private String statusShort;

	@SerializedName("homeTeam")
	private HomeTeam homeTeam;

	@SerializedName("secondHalfStart")
	private int secondHalfStart;

	@SerializedName("firstHalfStart")
	private int firstHalfStart;

	@SerializedName("league_id")
	private int leagueId;

	@SerializedName("status")
	private String status;

	public void setFixtureId(int fixtureId){
		this.fixtureId = fixtureId;
	}

	public int getFixtureId(){
		return fixtureId;
	}

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
	}

	public void setGoalsHomeTeam(int goalsHomeTeam){
		this.goalsHomeTeam = goalsHomeTeam;
	}

	public int getGoalsHomeTeam(){
		return goalsHomeTeam;
	}

	public void setGoalsAwayTeam(int goalsAwayTeam){
		this.goalsAwayTeam = goalsAwayTeam;
	}

	public int getGoalsAwayTeam(){
		return goalsAwayTeam;
	}

	public void setAwayTeam(AwayTeam awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam(){
		return awayTeam;
	}

	public void setLeague(League league){
		this.league = league;
	}

	public League getLeague(){
		return league;
	}

	public void setEventTimestamp(int eventTimestamp){
		this.eventTimestamp = eventTimestamp;
	}

	public int getEventTimestamp(){
		return eventTimestamp;
	}

	public void setReferee(String referee){
		this.referee = referee;
	}

	public String getReferee(){
		return referee;
	}

	public void setElapsed(int elapsed){
		this.elapsed = elapsed;
	}

	public int getElapsed(){
		return elapsed;
	}

	public void setScore(Score score){
		this.score = score;
	}

	public Score getScore(){
		return score;
	}

	public void setRound(String round){
		this.round = round;
	}

	public String getRound(){
		return round;
	}

	public void setEventDate(String eventDate){
		this.eventDate = eventDate;
	}

	public String getEventDate(){
		return eventDate;
	}

	public void setStatusShort(String statusShort){
		this.statusShort = statusShort;
	}

	public String getStatusShort(){
		return statusShort;
	}

	public void setHomeTeam(HomeTeam homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam(){
		return homeTeam;
	}

	public void setSecondHalfStart(int secondHalfStart){
		this.secondHalfStart = secondHalfStart;
	}

	public int getSecondHalfStart(){
		return secondHalfStart;
	}

	public void setFirstHalfStart(int firstHalfStart){
		this.firstHalfStart = firstHalfStart;
	}

	public int getFirstHalfStart(){
		return firstHalfStart;
	}

	public void setLeagueId(int leagueId){
		this.leagueId = leagueId;
	}

	public int getLeagueId(){
		return leagueId;
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
			"FixturesItem{" + 
			"fixture_id = '" + fixtureId + '\'' + 
			",venue = '" + venue + '\'' + 
			",goalsHomeTeam = '" + goalsHomeTeam + '\'' + 
			",goalsAwayTeam = '" + goalsAwayTeam + '\'' + 
			",awayTeam = '" + awayTeam + '\'' + 
			",league = '" + league + '\'' + 
			",event_timestamp = '" + eventTimestamp + '\'' + 
			",referee = '" + referee + '\'' + 
			",elapsed = '" + elapsed + '\'' + 
			",score = '" + score + '\'' + 
			",round = '" + round + '\'' + 
			",event_date = '" + eventDate + '\'' + 
			",statusShort = '" + statusShort + '\'' + 
			",homeTeam = '" + homeTeam + '\'' + 
			",secondHalfStart = '" + secondHalfStart + '\'' + 
			",firstHalfStart = '" + firstHalfStart + '\'' + 
			",league_id = '" + leagueId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}