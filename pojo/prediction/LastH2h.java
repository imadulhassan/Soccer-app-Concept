package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class LastH2h{

	@SerializedName("wins")
	private Wins wins;

	@SerializedName("loses")
	private Loses loses;

	@SerializedName("draws")
	private Draws draws;

	@SerializedName("played")
	private Played played;

	public void setWins(Wins wins){
		this.wins = wins;
	}

	public Wins getWins(){
		return wins;
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

	public void setPlayed(Played played){
		this.played = played;
	}

	public Played getPlayed(){
		return played;
	}

	@Override
 	public String toString(){
		return 
			"LastH2h{" + 
			"wins = '" + wins + '\'' + 
			",loses = '" + loses + '\'' + 
			",draws = '" + draws + '\'' + 
			",played = '" + played + '\'' + 
			"}";
		}
}