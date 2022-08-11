package com.soccer.pojo.prediction;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PredictionsItem{

	@SerializedName("under_over")
	private Object underOver;

	@SerializedName("winning_percent")
	private WinningPercent winningPercent;

	@SerializedName("comparison")
	private Comparison comparison;

	@SerializedName("teams")
	private Teams teams;

	@SerializedName("match_winner")
	private String matchWinner;

	@SerializedName("advice")
	private String advice;

	@SerializedName("goals_home")
	private String goalsHome;

	@SerializedName("goals_away")
	private String goalsAway;

	@SerializedName("h2h")
	private List<H2hItem> h2h;

	public void setUnderOver(Object underOver){
		this.underOver = underOver;
	}

	public Object getUnderOver(){
		return underOver;
	}

	public void setWinningPercent(WinningPercent winningPercent){
		this.winningPercent = winningPercent;
	}

	public WinningPercent getWinningPercent(){
		return winningPercent;
	}

	public void setComparison(Comparison comparison){
		this.comparison = comparison;
	}

	public Comparison getComparison(){
		return comparison;
	}

	public void setTeams(Teams teams){
		this.teams = teams;
	}

	public Teams getTeams(){
		return teams;
	}

	public void setMatchWinner(String matchWinner){
		this.matchWinner = matchWinner;
	}

	public String getMatchWinner(){
		return matchWinner;
	}

	public void setAdvice(String advice){
		this.advice = advice;
	}

	public String getAdvice(){
		return advice;
	}

	public void setGoalsHome(String goalsHome){
		this.goalsHome = goalsHome;
	}

	public String getGoalsHome(){
		return goalsHome;
	}

	public void setGoalsAway(String goalsAway){
		this.goalsAway = goalsAway;
	}

	public String getGoalsAway(){
		return goalsAway;
	}

	public void setH2h(List<H2hItem> h2h){
		this.h2h = h2h;
	}

	public List<H2hItem> getH2h(){
		return h2h;
	}

	@Override
 	public String toString(){
		return 
			"PredictionsItem{" + 
			"under_over = '" + underOver + '\'' + 
			",winning_percent = '" + winningPercent + '\'' + 
			",comparison = '" + comparison + '\'' + 
			",teams = '" + teams + '\'' + 
			",match_winner = '" + matchWinner + '\'' + 
			",advice = '" + advice + '\'' + 
			",goals_home = '" + goalsHome + '\'' + 
			",goals_away = '" + goalsAway + '\'' + 
			",h2h = '" + h2h + '\'' + 
			"}";
		}
}