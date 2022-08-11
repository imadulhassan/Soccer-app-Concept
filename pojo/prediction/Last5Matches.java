package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Last5Matches{

	@SerializedName("forme")
	private String forme;

	@SerializedName("att")
	private String att;

	@SerializedName("def")
	private String def;

	@SerializedName("goals_against")
	private int goalsAgainst;

	@SerializedName("goals_avg")
	private double goalsAvg;

	@SerializedName("goals_against_avg")
	private double goalsAgainstAvg;

	@SerializedName("goals")
	private int goals;

	public void setForme(String forme){
		this.forme = forme;
	}

	public String getForme(){
		return forme;
	}

	public void setAtt(String att){
		this.att = att;
	}

	public String getAtt(){
		return att;
	}

	public void setDef(String def){
		this.def = def;
	}

	public String getDef(){
		return def;
	}

	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsAgainst(){
		return goalsAgainst;
	}

	public void setGoalsAvg(double goalsAvg){
		this.goalsAvg = goalsAvg;
	}

	public double getGoalsAvg(){
		return goalsAvg;
	}

	public void setGoalsAgainstAvg(double goalsAgainstAvg){
		this.goalsAgainstAvg = goalsAgainstAvg;
	}

	public double getGoalsAgainstAvg(){
		return goalsAgainstAvg;
	}

	public void setGoals(int goals){
		this.goals = goals;
	}

	public int getGoals(){
		return goals;
	}

	@Override
 	public String toString(){
		return 
			"Last5Matches{" + 
			"forme = '" + forme + '\'' + 
			",att = '" + att + '\'' + 
			",def = '" + def + '\'' + 
			",goals_against = '" + goalsAgainst + '\'' + 
			",goals_avg = '" + goalsAvg + '\'' + 
			",goals_against_avg = '" + goalsAgainstAvg + '\'' + 
			",goals = '" + goals + '\'' + 
			"}";
		}
}