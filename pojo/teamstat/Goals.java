package com.soccer.pojo.teamstat;


import com.google.gson.annotations.SerializedName;


public class Goals{

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
			"Goals{" + 
			"goalsFor = '" + goalsFor + '\'' + 
			",goalsAgainst = '" + goalsAgainst + '\'' + 
			"}";
		}
}