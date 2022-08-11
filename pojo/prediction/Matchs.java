package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Matchs{

	@SerializedName("wins")
	private Wins wins;

	@SerializedName("matchsPlayed")
	private MatchsPlayed matchsPlayed;

	@SerializedName("loses")
	private Loses loses;

	@SerializedName("draws")
	private Draws draws;

	public void setWins(Wins wins){
		this.wins = wins;
	}

	public Wins getWins(){
		return wins;
	}

	public void setMatchsPlayed(MatchsPlayed matchsPlayed){
		this.matchsPlayed = matchsPlayed;
	}

	public MatchsPlayed getMatchsPlayed(){
		return matchsPlayed;
	}

	public void setLoses(Loses loses){
		this.loses = loses;
	}

	public Loses getLoses(){
		return loses;
	}

	public void setDraws(Draws draws){
		this.draws = draws;
	}

	public Draws getDraws(){
		return draws;
	}

	@Override
 	public String toString(){
		return 
			"Matchs{" + 
			"wins = '" + wins + '\'' + 
			",matchsPlayed = '" + matchsPlayed + '\'' + 
			",loses = '" + loses + '\'' + 
			",draws = '" + draws + '\'' + 
			"}";
		}
}