package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class GoalsAvg{

	@SerializedName("goalsFor")
	private GoalsFor goalsFor;

	@SerializedName("goalsAgainst")
	private GoalsAgainst goalsAgainst;

	public void setGoalsFor(GoalsFor goalsFor){
		this.goalsFor = goalsFor;
	}

	public GoalsFor getGoalsFor(){
		return goalsFor;
	}

	public void setGoalsAgainst(GoalsAgainst goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public GoalsAgainst getGoalsAgainst(){
		return goalsAgainst;
	}

	@Override
 	public String toString(){
		return 
			"GoalsAvg{" + 
			"goalsFor = '" + goalsFor + '\'' + 
			",goalsAgainst = '" + goalsAgainst + '\'' + 
			"}";
		}
}