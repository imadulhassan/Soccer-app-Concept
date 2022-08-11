package com.soccer.pojo.standing;


import com.google.gson.annotations.SerializedName;


public class All{

	@SerializedName("matchsPlayed")
	private int matchsPlayed;

	@SerializedName("goalsFor")
	private int goalsFor;

	@SerializedName("lose")
	private int lose;

	@SerializedName("draw")
	private int draw;

	@SerializedName("goalsAgainst")
	private int goalsAgainst;

	@SerializedName("win")
	private int win;

	public void setMatchsPlayed(int matchsPlayed){
		this.matchsPlayed = matchsPlayed;
	}

	public int getMatchsPlayed(){
		return matchsPlayed;
	}

	public void setGoalsFor(int goalsFor){
		this.goalsFor = goalsFor;
	}

	public int getGoalsFor(){
		return goalsFor;
	}

	public void setLose(int lose){
		this.lose = lose;
	}

	public int getLose(){
		return lose;
	}

	public void setDraw(int draw){
		this.draw = draw;
	}

	public int getDraw(){
		return draw;
	}

	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsAgainst(){
		return goalsAgainst;
	}

	public void setWin(int win){
		this.win = win;
	}

	public int getWin(){
		return win;
	}

	@Override
 	public String toString(){
		return 
			"All{" + 
			"matchsPlayed = '" + matchsPlayed + '\'' + 
			",goalsFor = '" + goalsFor + '\'' + 
			",lose = '" + lose + '\'' + 
			",draw = '" + draw + '\'' + 
			",goalsAgainst = '" + goalsAgainst + '\'' + 
			",win = '" + win + '\'' + 
			"}";
		}
}