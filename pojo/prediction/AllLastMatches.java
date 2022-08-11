package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class AllLastMatches{

	@SerializedName("matchs")
	private Matchs matchs;

	@SerializedName("goalsAvg")
	private GoalsAvg goalsAvg;

	@SerializedName("goals")
	private Goals goals;

	public void setMatchs(Matchs matchs){
		this.matchs = matchs;
	}

	public Matchs getMatchs(){
		return matchs;
	}

	public void setGoalsAvg(GoalsAvg goalsAvg){
		this.goalsAvg = goalsAvg;
	}

	public GoalsAvg getGoalsAvg(){
		return goalsAvg;
	}

	public void setGoals(Goals goals){
		this.goals = goals;
	}

	public Goals getGoals(){
		return goals;
	}

	@Override
 	public String toString(){
		return 
			"AllLastMatches{" + 
			"matchs = '" + matchs + '\'' + 
			",goalsAvg = '" + goalsAvg + '\'' + 
			",goals = '" + goals + '\'' + 
			"}";
		}
}